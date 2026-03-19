import java.util.Scanner;
import java.util.ArrayList;

abstract class RentRoom {
    int price, rentDays;

    abstract public int getFinalPrice();
}

class Standard extends RentRoom {
    Standard(int rentDays) {
        this.price = 500000;
        this.rentDays = rentDays;
    }
    public int getFinalPrice() {
        return (int) (price * rentDays * (1 - (rentDays > 3 ? 0.05 : 0)));
    }
}

class VIP extends RentRoom {
    VIP(int rentDays) {
        this.price = 2000000;
        this.rentDays = rentDays;
    }
    public int getFinalPrice() {
        return price * rentDays;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String type = input.next();
        int cnt = input.nextInt();
        if(type.equals("S")) {
            Standard s = new Standard(cnt);
            System.out.println(s.getFinalPrice());
        }
        else {
            VIP s = new VIP(cnt);
            System.out.println(s.getFinalPrice());
        }
    }
}