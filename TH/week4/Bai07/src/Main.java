import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

interface Operation<T> {
    T execute(T a, T b);
}

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }

    public String toString() {
        return id + " " + name + " " + gpa;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        int n = input.nextInt();
        while(n-- > 0) {
            String id = input.next();
            String name = input.next();
            double gpa = input.nextDouble();

            students.add(new Student(id, name, gpa));
        }

        students.removeIf(student -> student.getGpa() < 5.0);
        System.out.println("After removing GPA < 5.0:");
        students.forEach(student -> System.out.println(student));

        students.sort((a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("After sorting by name:");
        students.forEach(student -> System.out.println(student));

        Operation<Integer> add = (a, b) -> a + b;
        System.out.println(add.execute(10, 20));
    }
}