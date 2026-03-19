import java.util.Scanner;
import java.util.ArrayList;

abstract class Employee {
    String name, type;
    Employee(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract public double getSalary();

    public String toString() {
        return name + " - " + type + " - " + getSalary();
    }
}

class FullTimeEmployee extends Employee {
    double baseSalary, bonus, penalty;

    FullTimeEmployee(String name, double baseSalary, double bonus, double penalty) {
        super(name, "Full-time");
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    public double getSalary() {
        return baseSalary + bonus - penalty;
    }
}



class PartTimeEmployee extends Employee {
    double workingHours, hourlyRate;

    PartTimeEmployee(String name, double workingHours, double hourlyRate) {
        super(name, "Part-time");
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public double getSalary() {
        return workingHours * hourlyRate;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList <Employee> list = new ArrayList<>();

        int countEmployee = input.nextInt();
        while(countEmployee-- > 0) {
            String type = input.next();
            String name = "";
            while(true) {
                String tmp = input.next();
                if(tmp.charAt(0) == '\"' && tmp.charAt(tmp.length() - 1) == '\"') {
                    name = tmp.substring(1, tmp.length() - 1);
                    break;
                }
                else if(tmp.charAt(0) == '\"') {
                    name += tmp.substring(1, tmp.length()) + " ";
                }
                else if(tmp.charAt(tmp.length() - 1) == '\"') {
                    name += tmp.substring(0, tmp.length() - 1);
                    break;
                }
                else
                    name += tmp;
            }

            if(type == "F") {
                double baseSalary = input.nextDouble();
                double bonus = input.nextDouble();
                double penalty = input.nextDouble();

                list.add(new FullTimeEmployee(name, baseSalary, bonus, penalty));
            }
            else {
                double workingHours = input.nextDouble();
                double hourlyRate = input.nextDouble();
                list.add(new PartTimeEmployee(name, workingHours, hourlyRate));
            }
            System.out.println(type);
        }

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}