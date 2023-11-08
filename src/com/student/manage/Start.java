package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Welcome to student management app....");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to Add students ");
			System.out.println("Press 2 to Delete students");
			System.out.println("Press 3 to display student");
			System.out.println("Press 4 to update student name");
			System.out.println("Press 5 to exit app");
			
			int choice = Integer.parseInt(br.readLine());
			
			if(choice == 1) {
				// add student ...
				System.out.println("Enter user name: ");
				String name = br.readLine();
				
				System.out.println("Enter user phone: ");
				String phone = br.readLine();
				
				System.out.println("Enter user city: ");
				String city = br.readLine();
				
				// create student object to store student
				Student st = new Student(name, phone, city);
				System.out.println(st);
				boolean ans = StudentDao.insertStudentToDB(st);
				if(ans) {
					System.out.println("Sudent added successfully!");
				} else {
					System.out.println("Something went wrong. please check!");
				}
				
				
			} else if(choice == 2) {
				// delete student ...
				System.out.println("Enter studentId to be deleted!");
				int studId = Integer.parseInt(br.readLine());
				boolean ans = StudentDao.deleteStudent(studId);
				if(ans) {
					System.out.println("deleted");
				} else {
					System.out.println("Something went wrong");
				}
				
			} else if(choice == 3) {
				StudentDao.showAllStudents();
				
			} else if(choice == 4) {
				// update
				System.out.println("Enter student id: ");
				int id = Integer.parseInt(br.readLine());
				System.out.println("Enter updated name");
				String updatedName = br.readLine();
				
				boolean ans = StudentDao.updateStudentName(id, updatedName);
				if(ans) {
					System.out.println("Student name has been updated!");
				} else {
					System.out.println("Something went wrong");
				}
			}
			else if(choice == 5){
				// exit
				break;
			} else {
				continue;
			}
		}
		
		System.out.println("Thank you for using the application");
	}
}
