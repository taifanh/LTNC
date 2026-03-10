class Product {
    private final String id, name;
    private double price;

    Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    Product(Product other) {
        this.id = other.id;
        this.name = other.name;
        this.price = other.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "(" + id + " " + name + " " + price + ")";
    }
}

public class Inventory {
    Product[] Items;
    Inventory(Product[] initItems) {
        Items = new Product[initItems.length];
        for(int i = 0; i < initItems.length; ++i)
            Items[i] = new Product(initItems[i]);
    }

    public static void main(String[] args) {
        Product[] arr = new Product[]{new Product("7", "ronaldo", 5), new Product("10", "messi", 8)};
        Inventory kho = new Inventory(arr);
        arr[0].setPrice(5000);
        for(Product x : kho.Items)
            System.out.println(x);
    }
}
