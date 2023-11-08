package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public static boolean insertStudentToDB(Student student) {
		boolean flag = false;
		try {
			Connection connection = ConnectionProvider.createConnection();
			
			String query = "insert into students(sname, sphone, scity) values(?,?,?)";
			
			// PreparedStatement
			PreparedStatement statement = connection.prepareStatement(query);
			// set values of parameters
			statement.setString(1, student.getSname());
			statement.setString(2, student.getSphone());
			statement.setString(3, student.getScity());
			
			// execute query
			statement.executeUpdate();
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return flag;
	}

	public static boolean deleteStudent(int studId) {
		boolean flag = false;
		try {
			Connection connection = ConnectionProvider.createConnection();
			
			String query = "delete from students where sid = ?";
			
			// PreparedStatement
			PreparedStatement statement = connection.prepareStatement(query);
			// set values of parameters
			statement.setInt(1, studId);
			
			// execute query
			int rowAffected = statement.executeUpdate();
			if(rowAffected > 0)
				flag = true;
			else {
				System.out.println(studId + " does not exits");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return flag;
	}

	public static void showAllStudents() {
		try {
			Connection connection = ConnectionProvider.createConnection();
			
			String query = "select * from students";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String phone = resultSet.getString(3);
				String city = resultSet.getString(4);
				
				System.out.println("id: " + id);
				System.out.println("name: " + name);
				System.out.println("phone: " + phone);
				System.out.println("city: " + city);
				System.out.println("*****************");
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean updateStudentName(int id, String updatedName) {
		
		boolean flag = false;
		try {
			Connection connection = ConnectionProvider.createConnection();
			
			String query = "update students set sname=? where sid=?";
			
			// PreparedStatement
			PreparedStatement statement = connection.prepareStatement(query);
			// set values of parameters
			statement.setString(1, updatedName);
			statement.setInt(2, id);
			
			// execute query
			int rowAffected = statement.executeUpdate();
			if(rowAffected > 0)
				flag = true;
			else {
				System.out.println("Row with " + id+ " does nt exits");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return flag;
	}
}
