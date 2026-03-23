abstract class Shape {
    protected int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw();
    public abstract void erase();

    public void moveTo(int newX, int newY) {
        erase();
        this.x = newX; 
        this.y = newY;
        draw(); 
    }
}

class Circle extends Shape {
    public Circle(int x, int y) {
        super(x, y);
    }

    public void draw() {
        System.out.printf("Vẽ hình tròn tại (%d, %d)%n", x, y);
    }

    public void erase() {
        System.out.printf("Xóa hình tròn tại (%d, %d)%n", x, y);
    }
}

class Square extends Shape {
    public Square(int x, int y) {
        super(x, y);
    }

    public void draw() {
        System.out.printf("Vẽ hình vuông tại (%d, %d)%n", x, y);
    }

    public void erase() {
        System.out.printf("Xóa hình vuông tại (%d, %d)%n", x, y);
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(10, 10);
    
        circle.moveTo(20, 20);
        Shape square = new Square(5, 5);
        square.moveTo(15, 15);
    }
}