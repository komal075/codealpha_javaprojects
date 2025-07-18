import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter " + name + "'s score: ");
            int score = sc.nextInt();
            sc.nextLine();
            students.add(new Student(name, score));
        }

        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        for (Student s : students) {
            total += s.score;
            if (s.score > highest) highest = s.score;
            if (s.score < lowest) lowest = s.score;
        }

        System.out.println("\n--- Student Report ---");
        for (Student s : students) {
            System.out.println(s.name + ": " + s.score);
        }
        System.out.println("Average Score: " + (total / n));
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        sc.close();
    }
}