package HRM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testjdbcconnection {

	public static void main(String[] args) throws SQLException 
	{
		String dburl= "jdbc:sqlserver://10.10.180.52:1433";
		String user="IND_DEV";
		String pass="Pass$123";
		Connection con = DriverManager.getConnection(dburl, user, pass);
		Statement s =con.createStatement();
		ResultSet rs = s.executeQuery("Select * from application where applicationid='9999000064'");
		System.out.println(rs.getString("FIRSTNAME"));
		System.out.println(rs.getString("LASTNAME"));
	}

}
