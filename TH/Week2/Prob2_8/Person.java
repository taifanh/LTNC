package Prob2_8;
public class Person {
    private String name;
    private Person me;

    Person(String name) {
        this.name = name;
    }

    public void setMe(Person other) {
        this.me = other;
    }

    public Person getMe() {
        return this.me;
    }

    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        Person p = new Person("Tai Anh");
        p.setMe(p);
        System.out.println(p.getMe().getName());
    }
}
