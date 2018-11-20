package com.mcda5510.assignment3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import com.mcda5510.assignment3.entity.Transaction;

public class MySQLAccess implements SQLAccess {

	private final Logger l = Logger.getLogger("Assignment3");

	private Statement statement;

	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public MySQLAccess(Statement statement) {
		this.statement = statement;
	}

	public boolean updateTransaction(Transaction transaction) {
		int rowCount = 0;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE transaction SET");

			// To incorporate the first (,) after 1st column in update query
			boolean firstRow = true;
			if (transaction.getNameOnCard() != null) {
				firstRow = isFirst(sb, firstRow);

				sb.append(" NameOnCard = '");
				sb.append(validateString(transaction.getNameOnCard()));
				sb.append("'");
			}
			if (transaction.getCardNo() != null) {
				firstRow = isFirst(sb, firstRow);

				sb.append(" CardNumber = '");
				sb.append(transaction.getCardNo());

				sb.append("', CardType = '");
				sb.append(getCardType(transaction.getCardNo()));
				sb.append("'");
			}

			if (transaction.getUnitPrice() != null || transaction.getQuantity() != null) {
				firstRow = isFirst(sb, firstRow);

				if (transaction.getUnitPrice() == null) {
					l.severe("Error|Unit Price cannot be null");
					return false;
				}
				sb.append(" UnitPrice = ");
				sb.append(transaction.getUnitPrice());
				sb.append(",");

				if (transaction.getQuantity() == null) {
					l.severe("Error|Quantity cannot be null");
					return false;
				}
				sb.append(" Quantity = ");
				sb.append(transaction.getQuantity());

				sb.append(", TotalPrice = ");
				sb.append(transaction.getUnitPrice() * transaction.getQuantity());
			}

			if (transaction.getExpDate() != null) {
				firstRow = isFirst(sb, firstRow);
				sb.append(" ExpDate = '");
				sb.append(validateDate(transaction.getExpDate()));
				sb.append("'");
			}
			if (firstRow) {
				return false;
			}
			sb.append(" where ID = ");
			sb.append(transaction.getId());

			rowCount = statement.executeUpdate(sb.toString());

		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				l.severe("Transaction doesnot exits|Only Insertion is possible|" + e);
			} else {
				l.severe("Error in updating transaction|" + e);
			}
		}

		if (rowCount == 0) {
			l.info("Update Transaction unsuccessful|No transaction updated");
			return false;
		}

		l.info("Update Transaction successful");
		return true;
	}

	private String validateDate(String expDate) throws Exception {
		String[] eDate = expDate.split("/");

		int month = Integer.parseInt(eDate[0]);
		if (month < 1 && month > 12) {
			throw new Exception("Invalid month|month:" + month);
		}

		int year = Integer.parseInt(eDate[1]);
		if (year < 2016 && year > 2031) {
			throw new Exception("Invalid year (Not between 2016 and 2031)|year:" + year);
		}

		return expDate;
	}

	private String getCardType(String cardNo) throws Exception {
		if (cardNo.matches("[0-9]+")) {
			if (cardNo.matches("^[5][1-5].*") && cardNo.length() == 16) {
				return "MasterCard";
			} else if (cardNo.matches("^[4].*") && cardNo.length() == 16) {
				return "Visa";
			} else if (cardNo.matches("^[3][4|7].*") && cardNo.length() == 15) {
				return "American Express";
			}
		}
		throw new Exception("Invalid Credit Card");
	}

	private boolean isFirst(StringBuilder sb, boolean firstRow) {
		if (!firstRow) {
			sb.append(",");
		}
		firstRow = false;
		return firstRow;
	}

	private String validateString(String string) throws Exception {
		if (string == null || string.matches(".*[;:!@#$%^*+?<>].*")) {
			throw new Exception("Invalid String:" + string);
		}
		return string;
	}

	public Transaction getTransaction(int transactionId) {
		Transaction transaction = null;
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery("select * from transaction where id = " + transactionId);
			if (resultSet == null) {
				l.warning("Error|No Transaction with transaction id:" + transactionId);
				return null;
			}
			while (resultSet.next()) {
				transaction = new Transaction();

				transaction.setId(resultSet.getInt("ID"));
				transaction.setNameOnCard(resultSet.getString("NameOnCard"));
				transaction.setCardNo(resultSet.getString("CardNumber"));
				transaction.setUnitPrice(resultSet.getFloat("UnitPrice"));
				transaction.setQuantity(resultSet.getInt("Quantity"));
				transaction.setTotalPrice(resultSet.getFloat("TotalPrice"));
				transaction.setExpDate(resultSet.getString("ExpDate"));
				transaction.setCreatedOn(resultSet.getTimestamp("CreatedOn"));
				transaction.setCreatedBy(resultSet.getString("CreatedBy"));
				transaction.setCardType(resultSet.getString("CardType"));
			}

			l.info("Get Transaction successful|Transaction:" + transaction.toString());
		} catch (Exception e) {
			l.severe("Error in getting Transaction from MySQL|" + e);
		}

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				l.severe("Error in closing resultSet|" + e);
			}
		}

		return transaction;
	}

	public boolean removeTransaction(int transactionId) {
		try {
			int rowCount = statement.executeUpdate("delete from transaction where id = " + transactionId);
			if (rowCount == 0) {
				l.warning("No transaction with transaction id:" + transactionId);
			}
		} catch (Exception e) {
			l.severe("Error in removing Transaction from MySQL|" + e);
			return false;
		}

		l.info("Remove Transaction successful");
		return true;
	}

	public boolean createTransaction(Transaction transaction) {
		int rowCount = 0;
		try {
			validateTransaction(transaction);
			rowCount = statement.executeUpdate(
					"insert into transaction values (" + transaction.getId() + ", '" + transaction.getNameOnCard()
							+ "', '" + transaction.getCardNo() + "', " + transaction.getUnitPrice() + ", "
							+ transaction.getQuantity() + " , " + transaction.getTotalPrice() + ", '"
							+ transaction.getExpDate() + "', '" + format.format(transaction.getCreatedOn()) + "', '"
							+ transaction.getCreatedBy() + "', '" + transaction.getCardType() + "')");

		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				l.severe("Transaction already exits|Only Updation is possible|" + e);
			} else {
				l.severe("Error in inserting into transaction|" + e);
			}
		}

		if (rowCount == 0) {
			l.info("Create Transaction unsuccessful|No transaction created");
			return false;
		}
		l.info("Create Transaction successful");
		return true;
	}

	private void validateTransaction(Transaction transaction) throws Exception {
		if (transaction.getId() == null || transaction.getNameOnCard() == null || transaction.getCardNo() == null
				|| transaction.getUnitPrice() == null || transaction.getQuantity() == null
				|| transaction.getExpDate() == null) {

			throw new Exception("Less Transaction details");
		}
		transaction.setNameOnCard(validateString(transaction.getNameOnCard()));
		transaction.setCardType(getCardType(transaction.getCardNo()));
		transaction.setTotalPrice(transaction.getUnitPrice() * transaction.getQuantity());
		transaction.setExpDate(validateDate(transaction.getExpDate()));
		transaction.setCreatedOn(new Date());
		transaction.setCreatedBy(System.getProperty("user.name"));
	}
}
