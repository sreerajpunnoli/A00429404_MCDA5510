package assignment2;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Assignment2 {

	private static final Logger l = Logger.getLogger("Assignment2");

	private static final String CONFIG_PROPERTIES = "config.properties";

	private static final String USER_NAME = "user.name";

	DateFormat format = new SimpleDateFormat("MM/yyyy");

	public static void main(String[] args) {
		Assignment2 assignment = new Assignment2();
		Properties conf = assignment.fetchConfigProperties();

		MySQLTransaction transact = new MySQLTransaction();
		try {
			transact.createConnection(conf);
			assignment.sqlOperations(transact);
		} catch (Exception e) {
			transact.closeConnection();
			l.log(Level.SEVERE, "Error with MySQL Connection|" + e);
		}
	}

	private void sqlOperations(MySQLTransaction transact) {
		String userName = System.getProperty(USER_NAME);

		Scanner reader = new Scanner(System.in);
		reader.useDelimiter("\n");

		int num = 6;
		while (num > 0) {
			l.log(Level.INFO,
					"Enter a number: 0 to exit, 1 to Create, 2 to Update, 3 to Get, 4 to Get all, 5 to remove");
			try {
				num = validateInteger(reader.nextLine());

				boolean status = false;
				boolean isValid = false;
				Transaction transaction = new Transaction();
				Integer transactionId = null;
				switch (num) {
				case 0:
					l.log(Level.INFO, "Exiting...");
					status = true;
					break;
				case 1:
					isValid = setTransactionObject(transaction, reader, userName);
					if (isValid) {
						status = transact.createTransaction(transaction, userName);
					}
					break;
				case 2:
					isValid = updateTransactionObject(transaction, reader, userName, transact);
					if (isValid) {
						status = transact.updateTransaction(transaction);
					}
					break;
				case 3:
					l.log(Level.INFO, "Enter Transaction Id");
					transactionId = validateInteger(reader.nextLine());
					transaction = transact.getTransaction(transactionId);
					if (transaction != null) {
						l.log(Level.INFO, transaction.toString());
					}
					status = true;
					break;
				case 4:
					Collection<Transaction> transactions = transact.getAllTransaction();
					if (transactions != null) {
						for (Transaction t : transactions) {
							l.log(Level.INFO, t.toString());
						}
					}
					status = true;
					break;
				case 5:
					l.log(Level.INFO, "Enter Transaction Id");
					transactionId = validateInteger(reader.nextLine());
					status = transact.removeTransaction(transactionId);
					break;
				default:
					l.log(Level.WARNING, "Invalid Operation. Select a valid operation");
					break;
				}

				if (status) {
					l.log(Level.INFO, "Operation Successful");
				} else {
					l.log(Level.INFO, "Operation UnSuccessful");
				}
				status = false;
			} catch (Exception e) {
				l.log(Level.SEVERE, "Error|Operation UnSuccessful|" + e);
			}
		}

		reader.close();
	}

	private boolean updateTransactionObject(Transaction transaction, Scanner reader, String userName,
			MySQLTransaction transact) {
		try {
			l.log(Level.INFO, "Enter Transaction Id");
			String id = reader.nextLine();
			transaction.setId(validateInteger(id));

			l.log(Level.INFO, "Enter columns (seperated by ,) to be changed");
			// createdOn, createdBy, cardType cannot be modified as they are system
			// generated
			l.log(Level.INFO,
					"Enter 0 for nameOnCard, 1 for cardNo, 2 for unitPrice, 3 for quantity, 4 for totalPrice, 5 for expDate");
			String[] indexes = reader.nextLine().split(",");
			if (indexes.length < 1 || indexes.length > 6) {
				l.log(Level.WARNING, "Invalid Column Numbers to be updated");
				return false;
			}

			for (String index : indexes) {
				switch (index.trim()) {
				case "0":
					l.log(Level.INFO, "Enter Name On Card");
					String name = reader.nextLine();
					if (validateString(name)) {
						transaction.setNameOnCard(name);
					} else {
						throw new Exception("Invalid Name on Card");
					}
					break;
				case "1":
					l.log(Level.INFO, "Enter Card Number");
					String cardNo = reader.nextLine();
					if (validateString(cardNo) && cardNo.matches("[0-9]+")) {
						transaction.setCardNo(cardNo);
						transaction.setCardType(getCardType(cardNo));
					} else {
						throw new Exception("Invalid Card Number");
					}
					break;
				case "2":
					l.log(Level.INFO, "Enter Unit Price");
					String unitPrice = reader.nextLine();
					transaction.setUnitPrice(validateFloat(unitPrice));
					break;
				case "3":
					l.log(Level.INFO, "Enter Quantity");
					String quantity = reader.nextLine();
					transaction.setQuantity(validateInteger(quantity));

					break;
				case "4":
					l.log(Level.INFO, "Enter Total Price");
					String totalPrice = reader.nextLine();
					transaction.setTotalPrice(validateFloat(totalPrice));
					break;
				case "5":
					l.log(Level.INFO, "Enter Expiry Date (MM/YYYY)");
					String expDate = reader.nextLine();
					if (validateDate(expDate)) {
						transaction.setExpDate(expDate);
					} else {
						throw new Exception("Invalid Expiry Date");
					}
					break;
				default:
					l.log(Level.WARNING, "Invalid Column|Select a valid Column|Skipped Index:" + index.trim());
					break;
				}
			}
		} catch (Exception e) {
			l.log(Level.SEVERE, "Validation Failed|" + e);
			return false;
		}
		return true;
	}

	private boolean setTransactionObject(Transaction transaction, Scanner reader, String userName) {
		try {
			l.log(Level.INFO, "Enter Transaction Id");
			String id = reader.nextLine();
			transaction.setId(validateInteger(id));

			l.log(Level.INFO, "Enter Name On Card");
			String name = reader.nextLine();
			if (validateString(name)) {
				transaction.setNameOnCard(name);
			} else {
				throw new Exception("Invalid Name on Card");
			}

			l.log(Level.INFO, "Enter Card Number");
			String cardNo = reader.nextLine();
			if (validateString(cardNo) && cardNo.matches("[0-9]+")) {
				transaction.setCardNo(cardNo);
				transaction.setCardType(getCardType(cardNo));
			} else {
				throw new Exception("Invalid Card Number");
			}

			l.log(Level.INFO, "Enter Unit Price");
			String unitPrice = reader.nextLine();
			transaction.setUnitPrice(validateFloat(unitPrice));

			l.log(Level.INFO, "Enter Quantity");
			String quantity = reader.nextLine();
			transaction.setQuantity(validateInteger(quantity));

			l.log(Level.INFO, "Enter Total Price");
			String totalPrice = reader.nextLine();
			transaction.setTotalPrice(validateFloat(totalPrice));

			l.log(Level.INFO, "Enter Expiry Date (MM/YYYY)");
			String expDate = reader.nextLine();
			if (validateDate(expDate)) {
				transaction.setExpDate(expDate);
			} else {
				throw new Exception("Invalid Expiry Date");
			}

			transaction.setCreatedOn(new Date(System.currentTimeMillis()));
			transaction.setCreatedBy(userName);
		} catch (Exception e) {
			l.log(Level.SEVERE, "Validation Failed|" + e);
			return false;
		}
		return true;
	}

	private Float validateFloat(String nextLine) {
		return Float.parseFloat(nextLine);
	}

	private String getCardType(String cardNo) {
		if (cardNo.matches("^[5][1-5].*") && cardNo.length() == 16) {
			return "MasterCard";
		} else if (cardNo.matches("^[4].*") && cardNo.length() == 16) {
			return "Visa";
		} else if (cardNo.matches("^[3][4|7].*") && cardNo.length() == 15) {
			return "American Express";
		}
		return "Other";
	}

	private Integer validateInteger(String nextLine) {
		return Integer.parseInt(nextLine);
	}

	private boolean validateDate(String expDate) {
		try {
			format.parse(expDate);
			int year = Integer.parseInt(expDate.split("/")[1]);
			if (year < 2016 && year > 2031) {
				throw new Exception("Invalid year (Not between 2016 and 2031)|year:" + year);
			}
		} catch (Exception e) {
			l.log(Level.WARNING, "Invalid Date(MM/YYYY)|" + expDate + "|" + e);
			return false;
		}
		return true;
	}

	private boolean validateString(String string) {
		if (string == null || string.trim().equals("")) {
			return false;
		}
		return !string.matches(".*[;:!@#$%^*+?<>].*");
	}

	private Properties fetchConfigProperties() {
		Properties prop = new Properties();

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES);
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			l.log(Level.WARNING, "Property File Not Found|FileName:" + CONFIG_PROPERTIES);
		}

		try {
			inputStream.close();
		} catch (IOException e) {
			l.log(Level.SEVERE, "" + e);
		}
		return prop;

	}
}
