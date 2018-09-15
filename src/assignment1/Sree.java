package assignment1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Sree {

	Logger l = Logger.getAnonymousLogger();

	String config = "config.properties";

	public static void main(String[] args) {
		Sree s = new Sree();

		Properties prop = s.fetchProperties();
		String dir = prop.getProperty("data.directory");
		s.walk(dir);
	}

	private Properties fetchProperties() {
		Properties prop = new Properties();

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(config);

		try {
			prop.load(inputStream);
		} catch (IOException e) {
			l.log(Level.WARNING, "Property File Not Found|FileName:" + config);
		}
		return prop;

	}

	public void walk(String path) {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
//				System.out.println("Dir:" + f.getAbsoluteFile());
			} else {
				System.out.println("File:" + f.getAbsoluteFile() + f.lastModified());
				readCSVFile(f.getAbsoluteFile());
			}
		}
	}

	private void readCSVFile(File file) {
		Reader in;
		try {
			in = new FileReader(file.getName());
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
			for (CSVRecord record : records) {
				String firstName = record.get("First Name");
				String lastName = record.get("Last Name");
				String streetNo = record.get("Street Number");
				String street = record.get("Street");
				String city = record.get("City");
				String province = record.get("Province");
				String pin = record.get("Postal Code");
				String country = record.get("Country");
				String phone = record.get("Phone Number");
				String email = record.get("email Address");
				String date = getDate(file);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String getDate(File file) {
		// TODO Auto-generated method stub
		return (new Date(file.lastModified())).toString();
	}

}
