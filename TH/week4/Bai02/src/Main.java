interface CanFly {
    void fly();
}

interface CanSwim {
    void swim();
}

interface CanFight {
    void fight();
}

class ActionCharacter {
    public void fight() {
        System.out.println("Đấm bốc...");
    }
}

class Hero extends ActionCharacter implements CanFly, CanSwim, CanFight {
    public void fly() {
        System.out.println("Hero is flying");
    }

    public void swim() {
        System.out.println("Hero is swimming");
    }

    // public void fight() {

    // }
}

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        CanSwim s = (CanSwim) hero;
        s.swim();

        CanFight f = (CanFight) hero;
        f.fight();
    }
}