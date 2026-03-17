package in.biduaedtech.controller;

import java.util.Scanner;

import in.biduaedtech.Service.RStudentService;
import in.biduaedtech.dto.Student;
import in.biduaedtech.serviceFactory.StudentServiceFactory;

//controller layer
public class TestApp {
		public static void main(String[] args) {
			RStudentService studentService = StudentServiceFactory.getStudentService();// new StudentServiceImplementation();
			
			Scanner sc = new Scanner(System.in);
			
				int choice;
				while(true) {
					System.out.println();
					System.out.println("====Crud app menu====");
					System.out.println("1. Add Students Data");
					System.out.println("2. View Student Data");
					System.out.println("3. Update Data");
					System.out.println("4. Delete Data");
					System.out.println("5. Exit");
					
					System.out.println("Enter your choice");
					choice = sc.nextInt();
					
					switch (choice) {
						case 1: {
							System.out.println("Enter the Id: ");
							int id = sc.nextInt();
							
							sc.nextLine(); // consume leftover newline
							
							System.out.println("Enter the name of the student: ");
							String name = sc.nextLine();
							
							System.out.println("Enter the age of the student");
							int age = sc.nextInt();
							sc.nextLine();
							
							System.out.println("Enter the Address of the student");
							String Address = sc.nextLine();
							
							String msg = studentService.addStudent(id, name, age, Address);
							if(msg.equalsIgnoreCase("success")) {
								System.out.println("Record Inserted Successfully");
							}else {
								System.out.println("Record Insertion Failed");
							}
							break;
						}
						case 2: {
							System.out.println("Enter the user id: ");
							int id = sc.nextInt();
							Student s1 = studentService.searchStudent(id);
							System.out.println(s1.toString());
							break;
						}
						case 3: {
						    System.out.println("Enter the ID you want to update: ");
						    int id = sc.nextInt();
						    sc.nextLine(); 

						    System.out.println("Enter the new name of the student: ");
						    String name = sc.nextLine();

						    System.out.println("Enter the new age of the student: ");
						    int age = sc.nextInt();
						    sc.nextLine(); // consume leftover newline

						    System.out.println("Enter the new address of the student: ");
						    String address = sc.nextLine();

						    String msg = studentService.updateStudent(id, name, age, address);

						    if (msg.equalsIgnoreCase("success")) {
						        System.out.println("Record Updated Successfully");
						    } else {
						        System.out.println("Record Updation Failed");
						    }
						    break;
						}
						case 4:{
							System.out.println("Enter the id which you want to Delete: ");
							int id = sc.nextInt();
							String msg = studentService.deleteStudent(id);
							if(msg.equalsIgnoreCase("success")) {
								System.out.println("Record Deleted Successfully");
							}else {
								System.out.println("Record Deletion Failed");
							}
							break;
						}
						case 5:{
							System.out.println("Come soon, we'll be waiting for you..");
							sc.close();
							System.exit(0);
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + choice);
						}
				}
				
		}
}
