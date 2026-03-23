import java.util.ArrayList;
import java.util.Scanner;

interface IWorkable {
    void work();
}

abstract class Employee implements IWorkable {
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculatePay();
}

class OfficeWorker extends Employee {
    public OfficeWorker(String id, String name, double baseSalary) {
        super(id, name, baseSalary);
    }

    public double calculatePay() {
        return baseSalary;
    }

    public void work() {
        System.out.println("Soạn thảo văn bản");
    }
}

class Technician extends Employee {
    private int overtimeHours;

    public Technician(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    public double calculatePay() {
        return baseSalary + overtimeHours * 20000;
    }

    public void work() {
        System.out.println("Lắp đặt thiết bị");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("O")) {
                list.add(new OfficeWorker(id, name, salary));
            } else if (type.equals("T")) {
                int ot = sc.nextInt();
                list.add(new Technician(id, name, salary, ot));
            }
        }

        double totalPay = 0;
        for (Employee e : list) {
            double pay = e.calculatePay();
            totalPay += pay;
            
            System.out.printf("%s - Pay: %.1f%n", e.name, pay);
            e.work();
            System.out.println();
        }

        System.out.printf("Total Pay = %.1f%n", totalPay);
        sc.close();
    }
}