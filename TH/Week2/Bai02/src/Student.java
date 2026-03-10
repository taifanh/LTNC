public class Student {
    private String id, name, email;
    private double gpa;

    Student() {
        id = "25021642";
        name = "Tai Anh";
        email = "taifanhde118@gmail.com";
        gpa = 4.0;
    }

    Student(String id, String name) {
        this.id = id;
        this.name = name;
        email = "None";
        gpa = 0.0;
    }

    Student(String id, String name, String email, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gpa = gpa;
    }

    public boolean setId(String id) {
        if(id.length() != 8) {
            System.out.println("Error: ID has 8 characters!");
            return false;
        }
        this.id = id;
        return true;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

    public boolean setEmail(String email) {
        int at = 0, dot = 0;
        for(int i = 0; i < email.length(); ++i) {
            if(email.charAt(i) == ' ') {
                at = 0;
                break;
            }
            if(email.charAt(i) == '@')
                at++;
            if(email.charAt(i) == '.' && at > 0)
                dot++;
        }
        if(at != 1 || dot == 0) {
            System.out.println("Error: Email!");
            return false;
        }
        this.email = email;
        return true;
    }

    public boolean setGpa(double gpa) {
        if(gpa < 0 || gpa > 4) { 
            System.out.println("Error: 0 <= GPA <= 4");
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    public static void main(String[] args) {
        Student Tanh = new Student();
        Student Phuc = new Student("23032007", "Phuc");
        Student Nam = new Student("27042007", "Nam", "nvn2704@gmail.com", 3.98);
        Nam.setGpa(-1);
    }
}
