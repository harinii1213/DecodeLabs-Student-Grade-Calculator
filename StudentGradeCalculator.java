
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n========================================");
        System.out.println("       STUDENT GRADE CALCULATOR");
        System.out.println("========================================");

        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Student name cannot be empty!");
            sc.close();
            return;
        }

        System.out.print("Enter number of subjects: ");

        if (!sc.hasNextInt()) {
            System.out.println("Please enter a valid whole number!");
            sc.close();
            return;
        }

        int n = sc.nextInt();

        if (n <= 0 || n > 20) {
            System.out.println("Enter subjects between 1 and 20.");
            sc.close();
            return;
        }

        String[] subjects = new String[n];
        int[] marks = new int[n];
        int total = 0;
        boolean allPassed = true;

        for (int i = 0; i < n; i++) {
            sc.nextLine();

            System.out.print("\nEnter subject " + (i + 1) + " name: ");
            subjects[i] = sc.nextLine().trim();

            if (subjects[i].isEmpty()) {
                System.out.println("Subject name cannot be empty!");
                sc.close();
                return;
            }

            System.out.print("Enter marks for " + subjects[i] + " (0-100): ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter whole-number marks!");
                sc.close();
                return;
            }

            marks[i] = sc.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Marks must be between 0 and 100.");
                sc.close();
                return;
            }

            total += marks[i];

            if (marks[i] < 35) {
                allPassed = false;
            }
        }

        double percentage = (double) total / n;

        String grade;
        String remark;

        if (percentage >= 90) {
            grade = "A";
            remark = "Excellent";
        } else if (percentage >= 80) {
            grade = "B";
            remark = "Very Good";
        } else if (percentage >= 70) {
            grade = "C";
            remark = "Good";
        } else if (percentage >= 60) {
            grade = "D";
            remark = "Satisfactory";
        } else if (percentage >= 50) {
            grade = "E";
            remark = "Needs Improvement";
        } else {
            grade = "F";
            remark = "Work Hard";
        }

        System.out.println("\n========================================");
        System.out.println("             STUDENT REPORT");
        System.out.println("========================================");
        System.out.println("Student Name : " + name);
        System.out.println("----------------------------------------");
        System.out.printf("%-20s %-10s %-10s%n",
                "Subject", "Marks", "Status");
        System.out.println("----------------------------------------");

        for (int i = 0; i < n; i++) {
            String status = marks[i] >= 35 ? "PASS" : "FAIL";
            System.out.printf("%-20s %-10d %-10s%n",
                    subjects[i], marks[i], status);
        }

        System.out.println("----------------------------------------");
        System.out.println("Total Marks  : " + total + "/" + (n * 100));
        System.out.printf("Percentage   : %.2f%%%n", percentage);
        System.out.println("Grade        : " + grade);
        System.out.println("Remark       : " + remark);
        System.out.println("Final Result : " + (allPassed ? "PASS" : "FAIL"));
        System.out.println("========================================");

        sc.close();
    }
}
