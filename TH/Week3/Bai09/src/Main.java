import java.util.Scanner;
interface IPayable {
    double getPaymentAmount();
    void getter();
}
abstract class Staff implements IPayable {
    String id;
    String name;
    public Staff(String id, String name) {
        this.name = name;
        this.id = id;
    }
    public void getter() {}
    void setter() {}
}
class PartTimeStaff extends Staff {
    int workingHours;
    double hourlyRate;
    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate =hourlyRate;
    }
    @Override
    public double getPaymentAmount() {
        return this.workingHours * this.hourlyRate;
    }
    @Override
    public void getter() {
        System.out.println("PartTimeStaff " + this.name + "-Payment: " + getPaymentAmount());
    }
}
class Invoice implements IPayable {
    String itemName;
    int quantity;
    double pricePerItem;
    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.pricePerItem = pricePerItem;
        this.quantity = quantity;
        this.itemName = itemName;
    }
    @Override
    public double getPaymentAmount() {
        return this.quantity * this.pricePerItem;
    }
    @Override
    public void getter() {
        System.out.println("Invoice " + this.itemName + "-Payment: " + getPaymentAmount());
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        IPayable[] payableList = new IPayable[n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] comp = line.split("\\s+");
            if(comp[0].equals("S")) {
                payableList[i] = new PartTimeStaff(comp[1], comp[2], Integer.parseInt(comp[3]), Double.parseDouble(comp[4]));
            }
            else {
                payableList[i] = new Invoice(comp[1], Integer.parseInt(comp[2]), Double.parseDouble(comp[3]));
            }
        }
        double sum = 0;
        for (IPayable it : payableList) {
            it.getter();
            sum += it.getPaymentAmount();
        }
        System.out.println("Total Payment = " + sum);
    }
}