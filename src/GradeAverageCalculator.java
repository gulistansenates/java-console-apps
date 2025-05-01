import java.util.Scanner;

public class GradeAverageCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many courses will you enter grades for? ");
        int courseCount = scanner.nextInt();

        String[] courses = new String[courseCount];
        double[] grades = new double[courseCount];

        for (int i = 0; i < courseCount; i++) {
            System.out.print("Course name: ");
            courses[i] = scanner.next();

            while (true) {
                System.out.print("Enter the grade for " + courses[i] + ": ");
                if (scanner.hasNextDouble()) {
                    grades[i] = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }
        }

        double totalGrade = 0;
        for (int i = 0; i < courseCount; i++) {
            totalGrade += grades[i];
        }
        double average = totalGrade / courseCount;

        String letterGrade = "";
        if (average >= 90) {
            letterGrade = "AA";
        } else if (average >= 85) {
            letterGrade = "BA";
        } else if (average >= 80) {
            letterGrade = "BB";
        } else if (average >= 75) {
            letterGrade = "CB";
        } else if (average >= 70) {
            letterGrade = "CC";
        } else if (average >= 65) {
            letterGrade = "DC";
        } else if (average >= 60) {
            letterGrade = "DD";
        } else if (average >= 50) {
            letterGrade = "FD";
        } else {
            letterGrade = "FF";
        }

        System.out.println("\nGrade Average: " + average);
        System.out.println("Letter Grade: " + letterGrade);
    }
}
