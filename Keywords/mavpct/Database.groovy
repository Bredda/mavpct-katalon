package mavpct

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable



public class Database {
	private static Connection connection = null;

	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */

	//Establishing a connection to the DataBase

	@Keyword(keywordObject="Base de donnée")
	def connectDB(){

		//Load driver class for your specific database type

		String conn = "jdbc:sqlserver://${GlobalVariable.MAVPCT_DB['host']}:1433;databaseName=${GlobalVariable.MAVPCT_DB['db_name']}"

		if(connection != null && !connection.isClosed()){
			connection.close()
		}

		connection = DriverManager.getConnection(conn, GlobalVariable.MAVPCT_DB['username'], GlobalVariable.MAVPCT_DB['password'])

		return connection

	}

	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */

	//Executing the constructed Query and Saving results in resultset

	@Keyword(keywordObject="Base de donnée")
	def executeQuery(String queryString) {

		Statement stm = connection.createStatement()

		ResultSet rs = stm.executeQuery(queryString)

		return rs

	}

	//Closing the connection

	@Keyword(keywordObject="Base de donnée")
	def closeDatabaseConnection() {

		if(connection != null && !connection.isClosed()){

			connection.close()

		}

		connection = null

	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */

	@Keyword(keywordObject="Base de donnée")
	def execute(String queryString) {

		Statement stm = connection.createStatement()

		boolean result = stm.execute(queryString)

		return result

	}
}
