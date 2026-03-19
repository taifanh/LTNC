import java.util.Scanner;
import java.util.ArrayList;
class Employee {
    String name;
    double baseSalary;
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public double calculateBonus() {
        return 0.1*this.baseSalary;
    }
}
class Developer extends Employee {
    int overtimeHours;
    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }
    @Override
    public double calculateBonus() {
        return 0.1*this.baseSalary + overtimeHours * 200000;
    }
}
class Tester extends Employee {
    int bugsFound;
    public Tester(String name, double baseSalary, int bugsFound) {
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }
    public double calculateBonus() {
        return 0.1*this.baseSalary + bugsFound * 50000;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Employee> arr = new ArrayList<Employee>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] comp = line.split("\\s+");
            if(comp[0].equals("E")) {
                arr.add(new Employee(comp[1], Double.parseDouble(comp[2])));
            }
            else if (comp[0].equals("D")) {
                arr.add(new Developer(comp[1],Double.parseDouble(comp[2]),Integer.parseInt(comp[3])));
            }
            else {
                arr.add(new Tester(comp[1],Double.parseDouble(comp[2]),Integer.parseInt(comp[3])));
            }
        }
        for (Employee employee : arr) {
            System.out.println(employee.name + "-Bonus: " + employee.calculateBonus());
            if(employee instanceof Developer) {
                System.out.println("Tang khoa hoc AWS");
            }
            else if (employee instanceof Tester) {
                System.out.println("Tang tool Test");
            }
        }
    }
}