package Prob2_9;
import java.util.Scanner;

public class Product {
    String name;
    double price, discount;
    int quantity;
    static double taxRate = 0.1, totalRevenue = 0;

    Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    Product(String id, Scanner input) {
        System.out.println("Info of product " + id);

        System.out.print("Name: ");
        this.name = input.next();

        System.out.print("Price: ");
        this.price = input.nextDouble();

        System.out.print("Quantity: ");
        this.quantity = input.nextInt();

        System.out.print("Discount: ");
        this.discount = input.nextDouble();
    }

    static void updateTaxRate(double newRate) {
        taxRate = newRate;
    }

    double calculateFinalPrice() {
        double finalPrice = (price - discount) * (1 + taxRate);
        return finalPrice;
    }

    void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void sell(int amount) {
        if(amount <= quantity) {
            totalRevenue += amount * calculateFinalPrice();
            System.out.println("Sold!");
        }
        else 
            System.out.println("Error: Not enough product!");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Product p1 = new Product("1", input);
        Product p2 = new Product("2", input);

        System.out.print("Quantity of product 1 to buy: ");
        p1.sell(input.nextInt());
        System.out.print("Quantity of product 2 to buy: ");
        p2.sell(input.nextInt());

        System.out.println(p1.calculateFinalPrice() + " " + p2.calculateFinalPrice());
        updateTaxRate(0.08);
        System.out.println(p1.calculateFinalPrice() + " " + p2.calculateFinalPrice());
        p1.updateDiscount(10);
        System.out.println(p1.calculateFinalPrice() + " " + p2.calculateFinalPrice());

        System.out.println(totalRevenue);
    }
}
