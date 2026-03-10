class MyDate {
    int day, month, year;
    MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    MyDate(MyDate other) {
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }
}

class Employee {
    String name;
    MyDate birthday;
    Employee(String name, int day, int month, int year) {
        this.name = name;
        this.birthday = new MyDate(day, month, year);
    }
    Employee(Employee other) {
        this.name = other.name;
        this.birthday = new MyDate(other.birthday);
    }

    public String toString() {
        return name + " borns " + birthday.toString();
    }
}
public class Company {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Tai Anh", 1, 1, 2000);
        Employee emp2 = new Employee(emp1);
        System.out.println(emp1);
        System.out.println(emp2);

        emp1.birthday.day = 2;
        emp1.name = "Messi";
        System.out.println(emp1);
        System.out.println(emp2);
    }
}
