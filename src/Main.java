import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("Main Menu");
            System.out.println("1. Create class list");
            System.out.println("2. Provide marks for a subject");
            System.out.println("3. Get grade statistics for a subject");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //create class list
                    System.out.print("Enter the ID of the student: ");
                    String studentID = sc.next();
                    students.add(new Student(studentID));
                    break;

                case 2:
                    //provide marks for a subject
                    System.out.print("Enter the ID of the student: ");
                    studentID = sc.next();
                    Student student = findStudent(studentID);
                    System.out.print("Enter the name of the subject: ");
                    String subjectName = sc.next();
                    System.out.print("Enter the marks for the subject (separated by spaces): ");
                    String marksInput = sc.next();
                    String[] marksArray = marksInput.split(" ");
                    List<Integer> marks = new ArrayList<>();
                    for (String mark : marksArray) {
                        marks.add(Integer.parseInt(mark));
                    }
                    student.setMarks(subjectName, marks);

                    break;
             case 4:
                // Exit
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        }
        printStudentMarks();
    }
    private static Student findStudent(String name) {
        for (Student student : students) {
            if (student.getID().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public static void printStudentMarks() {
        for (Student student : students) {
            System.out.println("Student: " + student.getID());
            for (Subject subject : student.getSubjects()) {
                System.out.println("Subject: " + subject.getName());
                System.out.println("Marks: " + subject.getMarks());
            }
            System.out.println();
        }
    }
}
