package dbase;

import java.sql.*;

public class DbaseConnection {
    //check if studentID exists
    public static String checkStudent(int studentID) {
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
                return "False: Invalid Student ID";

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "true";
    }
}
