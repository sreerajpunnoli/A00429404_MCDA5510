package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLTransaction {

	private static final Logger l = Logger.getLogger("Assignment2");

	private static final String MYSQL_URL = "mysql.url";

	private static final String MYSQL_USERNAME = "mysql.username";

	private static final String MYSQL_PASSWORD = "mysql.password";

	private Connection connection = null;

	private Statement statement = null;

	public void createConnection(Properties conf) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = conf.getProperty(MYSQL_URL, "jdbc:mysql://localhost/transactions");
		String username = conf.getProperty(MYSQL_USERNAME, "root");
		String password = conf.getProperty(MYSQL_PASSWORD, "bullet");

		connection = DriverManager.getConnection(url + "?" + "user=" + username + "&password=" + password // Creds
				+ "&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"); // timezone

		statement = connection.createStatement();

	}

	public void closeConnection() {
		try {
			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean removeTransaction(Integer transactionId) {
		int rowCount = 0;
		try {
			rowCount = statement.executeUpdate("delete from transaction where id = " + transactionId);
		} catch (Exception e) {
			l.log(Level.SEVERE, "Error in removing Transaction from MySQL|" + e);
		}
		if (rowCount == 0) {
			l.log(Level.INFO, "No transaction with transaction id:" + transactionId);
			return false;
		}
		return true;
	}

	public Transaction getTransaction(Integer transactionId) {
		Transaction transaction = null;
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery("select * from transaction where id = " + transactionId);
			if (resultSet == null) {
				l.log(Level.WARNING, "Error|No Transaction with transaction id:" + transactionId);
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
			l.log(Level.SEVERE, "Error in getting Transaction from MySQL|" + e);
		}

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				l.log(Level.SEVERE, "Error in closing resultSet|" + e);
			}
		}
		return transaction;
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
				l.log(Level.SEVERE, "Transaction doesnot exits|Only Insertion is possible|" + e);
			} else {
				l.log(Level.SEVERE, "Error in updating transaction|" + e);
			}
		}

		if (rowCount == 0) {
			return false;
		}
		return true;
	}

	public boolean createTransaction(Transaction transaction, String userName) {
		int rowCount = 0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into transaction values (?, ?, ?, ?, ? , ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, transaction.getId());
			preparedStatement.setString(2, transaction.getNameOnCard());
			preparedStatement.setString(3, transaction.getCardNo());
			preparedStatement.setFloat(4, transaction.getUnitPrice());
			preparedStatement.setInt(5, transaction.getQuantity());
			preparedStatement.setFloat(6, transaction.getTotalPrice());
			preparedStatement.setString(7, transaction.getExpDate());
			preparedStatement.setTimestamp(8, transaction.getCreatedOn());
			preparedStatement.setString(9, transaction.getCreatedBy());
			preparedStatement.setString(10, transaction.getCardType());
			rowCount = preparedStatement.executeUpdate();

		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				l.log(Level.SEVERE, "Transaction already exits|Only Updation is possible|" + e);
			} else {
				l.log(Level.SEVERE, "Error in inserting into transaction|" + e);
			}
		}

		if (rowCount == 0) {
			return false;
		}
		return true;
	}

	public Collection<Transaction> getAllTransaction() {
		Collection<Transaction> transactions = null;
		try {
			ResultSet resultSet = statement.executeQuery("select * from transaction");
			transactions = createTrxns(resultSet);

			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			l.log(Level.SEVERE, "Error in getting Transaction from MySQL|" + e);
		}
		return transactions;
	}

	private Collection<Transaction> createTrxns(ResultSet resultSet) throws SQLException {
		Collection<Transaction> results = new ArrayList<Transaction>();

		while (resultSet.next()) {
			Transaction transaction = new Transaction();

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

			results.add(transaction);
		}
		return results;
	}
}
