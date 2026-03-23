import java.util.*;

// Bước 3: Tạo Custom Functional Interface
@FunctionalInterface
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

    @Override
    public String toString() {
        return id + " " + name + " " + gpa;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double gpa = sc.nextDouble();
            students.add(new Student(id, name, gpa));
        }

        // 1. Filter: Xóa sinh viên có GPA < 5.0 sử dụng Lambda
        students.removeIf(student -> student.getGpa() < 5.0);
        
        System.out.println("\nAfter removing GPA < 5.0:");
        students.forEach(System.out::println);

        // 2. Sort: Sắp xếp theo tên sử dụng Lambda
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        System.out.println("\nAfter sorting by name:");
        students.forEach(System.out::println);

        // 3. Custom Functional Interface: Cộng, Trừ, Nhân, Chia
        Operation<Double> add = (a, b) -> a + b;
        Operation<Double> subtract = (a, b) -> a - b;
        Operation<Double> multiply = (a, b) -> a * b;
        Operation<Double> divide = (a, b) -> a / b;

        System.out.println("\nCustom Operation Test (Add 10 + 5): " + add.execute(10.0, 5.0));
        
        sc.close();
    }
}