package com.mcda5510.assignment3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.mcda5510.assignment3.entity.Transaction;

public class MySQLAccess implements SQLAccess{

	public static final Logger l = Logger.getLogger("Assignment3");

	private Statement statement;

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
				if (!firstRow) {
					sb.append(",");
				}
				firstRow = false;
				sb.append(" NameOnCard = '");
				sb.append(transaction.getNameOnCard());
				sb.append("'");
			}
			if (transaction.getCardNo() != null) {
				if (!firstRow) {
					sb.append(",");
				}
				firstRow = false;
				sb.append(" CardNumber = '");
				sb.append(transaction.getCardNo());
				sb.append("'");

				sb.append(",");
				sb.append(" CardType = '");
				sb.append(transaction.getCardType());
				sb.append("'");
			}
			if (transaction.getUnitPrice() != null) {
				if (!firstRow) {
					sb.append(",");
				}
				firstRow = false;
				sb.append(" UnitPrice = ");
				sb.append(transaction.getUnitPrice());
			}
			if (transaction.getQuantity() != null) {
				if (!firstRow) {
					sb.append(",");
				}
				firstRow = false;
				sb.append(" Quantity = ");
				sb.append(transaction.getQuantity());
			}
			if (transaction.getTotalPrice() != null) {
				if (!firstRow) {
					sb.append(",");
				}
				firstRow = false;
				sb.append(" TotalPrice = ");
				sb.append(transaction.getTotalPrice());
			}
			if (transaction.getExpDate() != null) {
				if (!firstRow) {
					sb.append(",");
				}
				firstRow = false;
				sb.append(" ExpDate = '");
				sb.append(transaction.getExpDate());
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
			return false;
		}
		return true;
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
		int rowCount = 0;
		try {
			rowCount = statement.executeUpdate("delete from transaction where id = " + transactionId);
		} catch (Exception e) {
			l.severe("Error in removing Transaction from MySQL|" + e);
		}
		if (rowCount == 0) {
			l.warning("No transaction with transaction id:" + transactionId);
			return false;
		}
		return true;
	}

	public boolean createTransaction(Transaction transaction) {
		int rowCount = 0;
		try {
			rowCount = statement.executeUpdate(
					"insert into transaction values (" + transaction.getId() + ", '" + transaction.getNameOnCard()
							+ "', '" + transaction.getCardNo() + "', " + transaction.getUnitPrice() + ", "
							+ transaction.getQuantity() + " , " + transaction.getTotalPrice() + ", '"
							+ transaction.getExpDate() + "', " + transaction.getCreatedOn() + ", '"
							+ transaction.getCreatedBy() + "', '" + transaction.getCardType() + "')");

		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				l.severe("Transaction already exits|Only Updation is possible|" + e);
			} else {
				l.severe("Error in inserting into transaction|" + e);
			}
		}

		if (rowCount == 0) {
			return false;
		}
		return true;
	}
}
