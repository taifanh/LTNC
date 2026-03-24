import java.util.*;

abstract class Product {
    protected String id;
    protected String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract String getInfo();
}

class Food extends Product {
    private String expiryDate;

    public Food(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    public String getInfo() {
        return name + " - " + expiryDate;
    }
}

class Electronic extends Product {
    private int warrantyMonths;

    public Electronic(String id, String name, int warrantyMonths) {
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }

    public String getInfo() {
        return name + " - " + warrantyMonths + " tháng bảo hành";
    }
}

class Warehouse<T extends Product> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void inventoryCheck() {
        for (T item : items) {
            System.out.println(item.getInfo());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        Warehouse<Food> foodWH = new Warehouse<>();
        Warehouse<Electronic> elecWH = new Warehouse<>();

        int n = Integer.parseInt(input.nextLine());

        while(n-- > 0) {
            String line = input.nextLine();
            String[] p = line.split(" ");
            String type = p[0];
            
            if (type.equals("F")) {
                foodWH.addItem(new Food(p[1], p[2], p[3]));
            } else if (type.equals("E")) {
                elecWH.addItem(new Electronic(p[1], p[2], Integer.parseInt(p[3])));
            }
        }

        System.out.println("Kho Thực phẩm:");
        foodWH.inventoryCheck();

        System.out.println("\nKho Điện tử:");
        elecWH.inventoryCheck();
    }
}