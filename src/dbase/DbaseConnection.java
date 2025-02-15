package dbase;

import java.sql.*;
import java.util.Scanner;

public class DbaseConnection {
    public static int studentID;
    public static String password;
    public static String first_name;

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
            password = sc.next();
            if(DbaseConnection.checkPassword(studentID, password)){
                break;
            }
            System.out.println("Invalid Password");
        }
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

    //check if studentID exists
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

            while(resultSet.next()){
                first_name = resultSet.getString(2);
                System.out.println("Hello " + first_name +
                        "! What would you like to do?");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static void mainMenu() {
        System.out.println("Main Menu");

    }
}
