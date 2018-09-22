package assignment1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class TraverseCSV {

	Logger l = Logger.getAnonymousLogger();

	private static long rowCount = 0L;

	private static long skippedRowCount = 0L;

	private String date;

	private static final String CONFIG = "config.properties";

	private static final String READ_DIRECTORY_CONFIG = "data.readDirectory";

	private static final String WRITE_DIRECTORY_CONFIG = "data.writeDirectory";

	private static final String OUTPUT_FILE_NAME = "data.outputFileName";

	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final Object[] FILE_HEADER = { "First Name", "Last Name", "Street Number", "Street", "City",
			"Province", "Postal Code", "Country", "Phone Number", "email Address", "Date" };

	public static void main(String[] args) {
		TraverseCSV traverseCSV = new TraverseCSV();
		long startTime = System.currentTimeMillis();
		Properties prop = traverseCSV.fetchProperties();

		String outputFileName = prop.getProperty(OUTPUT_FILE_NAME);
		if (outputFileName != null && !outputFileName.endsWith(".csv")) {
			outputFileName += ".csv";
		}

		FileWriter fileWriter = null;
		CSVPrinter csvFilePrinter = null;
		try {

			fileWriter = new FileWriter(prop.getProperty(WRITE_DIRECTORY_CONFIG) + File.separator + outputFileName);
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
			csvFilePrinter.printRecord(FILE_HEADER);

			traverseCSV.walk(prop.getProperty(READ_DIRECTORY_CONFIG), csvFilePrinter);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		traverseCSV.l.log(Level.INFO, "rowCount:" + rowCount);
		traverseCSV.l.log(Level.INFO, "skippedRowCount:" + skippedRowCount);
		traverseCSV.l.log(Level.INFO, "Total Time taken(s):" + (System.currentTimeMillis() - startTime) / 1000.0);
	}

	private Properties fetchProperties() {
		Properties prop = new Properties();

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG);

		try {
			prop.load(inputStream);
		} catch (IOException e) {
			l.log(Level.WARNING, "Property File Not Found|FileName:" + CONFIG);
		}
		return prop;

	}

	public void walk(String path, CSVPrinter csvFilePrinter) {
		if (path == null) {
			l.log(Level.WARNING, "File Path is null");
			return;
		}
		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null) {
			l.log(Level.WARNING, "File Location is empty");
			return;
		}

		boolean isDateTaken = false;
		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath(), csvFilePrinter);
			} else {
				if (!f.getName().endsWith(".csv")) {
					continue;
				}
				if (!isDateTaken) {
					date = getDate(f.getAbsoluteFile());
					isDateTaken = true;
				}
				parseCSVFile(f.getAbsoluteFile(), csvFilePrinter);
			}
		}
	}

	private void parseCSVFile(File file, CSVPrinter csvFilePrinter) {
		Reader in;
		try {
			in = new FileReader(file.getAbsolutePath());
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);

			for (CSVRecord record : records) {
				try {
					String firstName = record.get(FILE_HEADER[0].toString());
					String lastName = record.get(FILE_HEADER[1].toString());
					String streetNo = record.get(FILE_HEADER[2].toString());
					String street = record.get(FILE_HEADER[3].toString());
					String city = record.get(FILE_HEADER[4].toString());
					String province = record.get(FILE_HEADER[5].toString());
					String postCode = record.get(FILE_HEADER[6].toString());
					String country = record.get(FILE_HEADER[7].toString());
					String phone = record.get(FILE_HEADER[8].toString());
					String email = record.get(FILE_HEADER[9].toString());

//					if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()
//							|| streetNo == null || streetNo.trim().isEmpty() || street == null
//							|| street.trim().isEmpty() || city == null || city.trim().isEmpty() || province == null
//							|| province.trim().isEmpty() || postCode == null || postCode.trim().isEmpty()
//							|| country == null || country.trim().isEmpty() || phone == null || phone.trim().isEmpty()
//							|| email == null || email.trim().isEmpty() || date == null || date.trim().isEmpty()) {
//						
//					}

					List<String> output = new ArrayList<String>();
					output.add(firstName);
					output.add(lastName);
					output.add(streetNo);
					output.add(street);
					output.add(city);
					output.add(province);
					output.add(postCode);
					output.add(country);
					output.add(phone);
					output.add(email);
					output.add(date);

					csvFilePrinter.printRecord(output);

					rowCount++;
				} catch (Exception e) {
					skippedRowCount++;
					l.log(Level.SEVERE, "" + e);
					return;
				}
			}
		} catch (IOException e) {
			l.log(Level.SEVERE, "" + e);
			e.printStackTrace();
			return;
		}

	}

	private String getDate(File file) {
		String separator = File.separator;
		if (separator.equals("\\")) {
			// For splitting in windows
			separator += separator;
		}
		String[] directories = file.getAbsolutePath().split(separator);
		if (directories.length < 4) {
			return null;
		}
		String year = directories[directories.length - 4];
		String month = directories[directories.length - 3];
		if (Integer.parseInt(month) < 10) {
			month = "0" + directories[directories.length - 3];
		}
		String day = directories[directories.length - 2];
		if (Integer.parseInt(day) < 10) {
			day = "0" + directories[directories.length - 2];
		}

		return year + "/" + month + "/" + day;
	}

}
