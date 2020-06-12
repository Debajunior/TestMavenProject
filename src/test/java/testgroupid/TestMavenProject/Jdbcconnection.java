package testgroupid.TestMavenProject;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Jdbcconnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		String host = "localhost";
		String port = "3306";
		Connection db = DriverManager.getConnection("jdbc:mysql://" +host+ ":" +port+ "/testdb","Walkydelta","Debajunior");

		Statement stmt = db.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Employee_info where id = 132120");
		
		while(rs.next())
		{	
			System.out.println(rs.getString("ID"));
			System.out.println(rs.getString("Name"));
			System.out.println(rs.getString("DOB"));
			System.out.println(rs.getString("Age"));
			System.out.println(rs.getString("Education"));
			System.out.println(rs.getString("Location"));
			System.out.println(rs.getString("Department"));
			System.out.println(rs.getString("Experience"));
		}
	}

}
