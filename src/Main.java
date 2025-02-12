import dbase.DbaseConnection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Student ID: ");
        int studentID = sc.nextInt();
        System.out.println(DbaseConnection.checkStudent(studentID));
    }
}




