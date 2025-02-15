package dbase;

import java.sql.*;
import java.util.Scanner;

public class DbaseConnection {
    private static int studentID;


    // Display Login Menu on screen
    public static void loginMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("<< Student Information System >>\n" +
                "Login to Continue");

        while(true) {
            System.out.print("Student ID: ");
            // Check for valid studentID
            if(sc.hasNextInt()){
                studentID = sc.nextInt();
                studentID = studentID == 0 ? -1 : studentID;
            }else{
                sc.next();
            }

            if(DbaseConnection.checkStudent(studentID)){
                break;
            }
            System.out.println("Invalid ID");
        }

        while(true) {
            System.out.print("Password: ");
            String password = sc.next();
            if(DbaseConnection.checkPassword(studentID, password)){
                break;
            }
            System.out.println("Invalid Password");
        }
        sc.next();
        sc.close();
    }
    //check if studentID exists
    public static boolean checkStudent(int studentID) {
        try {
            Connection con = DriverManager.getConnection(
                    LoginConstants.DB_URL,
                    LoginConstants.DB_USERNAME,
                    LoginConstants.DB_PASSWORD
            );

            PreparedStatement checkStudentIdExists = con.prepareStatement(
                    "SELECT * FROM " + LoginConstants.DB_TABLE_NAME +
                            " WHERE STUDENT_ID = ?"
            );

            checkStudentIdExists.setInt(1, studentID);
            ResultSet resultSet = checkStudentIdExists.executeQuery();

            if(!resultSet.isBeforeFirst()){
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    //check password
    public static boolean checkPassword(int studentID, String password) {
        try {
            Connection con = DriverManager.getConnection(
                    LoginConstants.DB_URL,
                    LoginConstants.DB_USERNAME,
                    LoginConstants.DB_PASSWORD
            );

            PreparedStatement validateStudent = con.prepareStatement(
                    "SELECT * FROM " + LoginConstants.DB_TABLE_NAME +
                            " WHERE STUDENT_ID = ? AND PASSWORD = ?"
            );

            validateStudent.setInt(1, studentID);
            validateStudent.setString(2, password);
            ResultSet resultSet = validateStudent.executeQuery();

            if(!resultSet.isBeforeFirst()){
                return false;
            }

            if (resultSet.next()){
                String first_name = resultSet.getString(2);
                System.out.println("\nHello " + first_name +
                        "! What would you like to do?");
                mainMenu();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public static void mainMenu(){

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Display Schedule");
            System.out.println("2. Register for a Class");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nYou selected Display Schedule.\n");
                    break;
                case 2:
                    System.out.println("\nYou selected Register for a Class.\n");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("\nInvalid choice, try again.\n");
            }
        } while (choice != 3);

        sc.close();

        System.exit(0);



    }

}
