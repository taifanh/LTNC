class Person {
    String name, dob;

    Person(String name) {
        this.name = name;
        System.out.println("1. Person is created");
    }
}

class Employee extends Person {
    double salary;

    Employee() {
        super("Tanh");
        System.out.println("2. Employee is created");
    }
}

class Manager extends Employee {
    String department;

    Manager() {
        System.out.println("3. Manager is created");
    }
}

public class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
    }
}