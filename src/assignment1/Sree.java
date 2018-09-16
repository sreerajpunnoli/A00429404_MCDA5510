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

public class Sree {

	Logger l = Logger.getAnonymousLogger();

	private static final String CONFIG = "config.properties";

	private static final String READ_DIRECTORY_CONFIG = "data.readDirectory";

	private static final String WRITE_DIRECTORY_CONFIG = "data.writeDirectory";

	private static final String OUTPUT_FILE_NAME = "data.outputFileName";

	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final Object[] FILE_HEADER = { "First Name", "Last Name", "Street Number", "Street", "City",
			"Province", "Postal Code", "Country", "Phone Number", "email Address", "Date (yyyy/mm/dd)" };

	public static void main(String[] args) {
		Sree s = new Sree();

		long rowCount = 0L;
		long skippedRowCount = 0L;
		Properties prop = s.fetchProperties();

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

			s.walk(prop.getProperty(READ_DIRECTORY_CONFIG), rowCount, skippedRowCount, csvFilePrinter);
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

	public void walk(String path, long rowCount, long skippedRowCount, CSVPrinter csvFilePrinter) {
		if (path == null) {
			return;
		}
		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath(), rowCount, skippedRowCount, csvFilePrinter);
			} else {
				if (!f.getName().endsWith(".csv")) {
					continue;
				}
				parseCSVFile(f.getAbsoluteFile(), rowCount, skippedRowCount, csvFilePrinter);
			}
		}
	}

	private void parseCSVFile(File file, long rowCount, long skippedRowCount, CSVPrinter csvFilePrinter) {
		Reader in;
		try {
			in = new FileReader(file.getName());
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);

			for (CSVRecord record : records) {
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
				String date = getDate(file);

				if (firstName == null || firstName.trim().isEmpty() || lastName == null || lastName.trim().isEmpty()
						|| streetNo == null || streetNo.trim().isEmpty() || street == null || street.trim().isEmpty()
						|| city == null || city.trim().isEmpty() || province == null || province.trim().isEmpty()
						|| postCode == null || postCode.trim().isEmpty() || country == null || country.trim().isEmpty()
						|| phone == null || phone.trim().isEmpty() || email == null || email.trim().isEmpty()
						|| date == null || date.trim().isEmpty()) {

					skippedRowCount++;

					StringBuilder sb = new StringBuilder();
					sb.append("Row Skipped|firstName:");
					sb.append(firstName);
					sb.append("|lastName:");
					sb.append(lastName);
					sb.append("|streetNo:");
					sb.append(streetNo);
					sb.append("|street:");
					sb.append(street);
					sb.append("|city:");
					sb.append(city);
					sb.append("|province:");
					sb.append(province);
					sb.append("|postCode:");
					sb.append(postCode);
					sb.append("|country:");
					sb.append(country);
					sb.append("|phone:");
					sb.append(phone);
					sb.append("|email:");
					sb.append(email);
					sb.append("|date:");
					sb.append(date);
					l.log(Level.WARNING, sb.toString());
					continue;
				}
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
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String getDate(File file) {
		String[] directories = file.getAbsolutePath().split(File.pathSeparator);
		return directories[directories.length - 3] + directories[directories.length - 2]
				+ directories[directories.length - 1];
	}

}
