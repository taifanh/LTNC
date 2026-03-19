import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

abstract class Product {
    String name;
    double price;

    abstract public double getFinalPrice();
    abstract public String toString();
}

class Electronics extends Product {
    double warantfee;
    Electronics(String name, double price, double fee) {
        this.name = name;
        this.price = price;
        this.warantfee = fee;
    }

    public double getFinalPrice() {
        return price * (1 + 0.1) + warantfee;
    }

    public String toString() {
        return name + " - Electronics - " + getFinalPrice();
    }
}

class Food extends Product {
    boolean expired;

    Food(String name, double price, boolean expired) {
        this.name = name;
        this.price = price;
        this.expired = expired;
    }

    public double getFinalPrice() {
        return price * (expired ? 0.8 : 1);
    }

    public String toString() {
        return name + " - Food - " + getFinalPrice();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ArrayList<Product> list = new ArrayList<>();

        int n = input.nextInt();
        while(n-- > 0) {
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
            double price = input.nextDouble();
            if(type.equals("F")) {
                String DateExpired = input.next();
                LocalDate Expired = LocalDate.parse(DateExpired, formatter);
                list.add(new Food(name, price, now.isAfter(Expired.minusWeeks(1))));
            }
            else {
                double fee = input.nextDouble();
                list.add(new Electronics(name, price, fee));
            }
        }

        double total = 0;
        for (Product product : list) {
            System.out.println(product);
            total += product.getFinalPrice();
        }
        System.out.println("Total = " + total);
    }
}