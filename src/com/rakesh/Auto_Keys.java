package com.rakesh;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Auto_Keys {

	public static void main(String[] args) throws SQLException {
		
		String dburl ="jdbc:mysql://localhost:3306/testdb";
		String dbuser="root";
		String dbpassword ="rakesh301";
		
		Connection conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
		
		DatabaseMetaData metaData = conn.getMetaData();
		System.out.println(metaData.supportsGetGeneratedKeys());
		System.out.println(metaData.generatedKeyAlwaysReturned());
		
		String sql ="insert into employee(emp_name,emp_email) values('raki','raki@gmail.com')";
		String sql1="insert into employee(emp_name,emp_email) values('sai','sai@gmail.com')";
		String sql2="insert into employee(emp_name,emp_email) values('ajay','ajay@gmail.com')";
		
		
		Statement st = conn.createStatement();
		
		int count = st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		int count1 = st.executeUpdate(sql1,Statement.RETURN_GENERATED_KEYS);
		int count2 = st.executeUpdate(sql2,Statement.RETURN_GENERATED_KEYS);
		
		
		
		
		
		ResultSet rs = st.getGeneratedKeys();
		
		while(rs.next()) {
			int key = rs.getInt(1);
			
			System.out.println("generated key was-----"+key );
		}
		System.out.println("done");

	}

}
