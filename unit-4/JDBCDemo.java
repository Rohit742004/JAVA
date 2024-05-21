package sdmcet.cse.oop.jdbc;

import java.sql.*;

public class JDBCDemo {
	//JDBC Driver and DB URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/2SD22CS075?characterEncoding=utf8";
	//DB credentials
	static final String USER = "root";
	static final String PASSWD = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//Step-1: Register JDBC Driver
			Class.forName(JDBC_DRIVER);
			//step-2: Create a connection
			System.out.println("Connection to the database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWD);
			System.out.println("Connected to: "+ conn.getCatalog());
			//step-3: Create statement
			System.out.println("Creating statement :");
			stmt = conn.createStatement();
			//step-4: Execute queries
			String sql = "SELECT * FROM student";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int rollNo = rs.getInt("rollNo");
				String usn = rs.getString("usn");
				String name = rs.getString("name");
				
				System.out.println("Roll Number : "+ rollNo);
				System.out.println("USN : "+ usn);
				System.out.println("Name : "+ name);
			}
			//step-5: Close connection
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}


Output : 
        Connection to the database...
        Connected to: 2SD22CS075
        Creating statement :
        Roll Number : 1
        USN : 2SD22CS074
        Name : Rohit B
        Roll Number : 2
        USN : 2SD22CS075
        Name : Rohit H
        Roll Number : 3
        USN : 2SD22CS076
        Name : Rohit K
