package test;

import java.sql.*;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn =null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Problem in loading drivers");
			e.printStackTrace();
		}
		
		try {
			String dbName = "Employee.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL);
			double sa = 66000;
			stat = conn.createStatement();
			String query = "INSERT INTO Employee (name, salary)" + "values ('ABC',65000)";
			//stat.executeUpdate(query);
			query = "UPDATE Employee SET salary = 120000"
					+ "WHERE  name = 'AAA'";
			query = "DELETE Employee WHERE name = 'BBB'";
			stat.executeUpdate(query);
			rs = stat.executeQuery("SELECT * From Employee");
			
			
			
			int id;
			String name;
			double sl;
			
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sl = rs.getDouble(3);
				System.out.println("id " + id + " name " + name
				+" salary " + sl);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		finally {
			try {
				if(conn!=null) {
					rs.close();
					stat.close();
					conn.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
