import java.util.Scanner;
abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;
    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }
    public void getName() {
        System.out.print(this.modelName + " ");
    }
    public void chargeBattery() {
        batteryLevel = 100;
    }
    final void showIdentity() {
        System.out.println(id + " " + modelName);
    }
    abstract void performMainTask();
}
interface ElectronicDevice {
    void turnOn();
}
interface Flyable {
    void fly();
}
interface Swimmable {
    void swim();
}
interface GPS {
    void getCoordinates();
}
class DroneRobot extends Robot implements Flyable, GPS, ElectronicDevice {
    public DroneRobot(int id, String modelName) {
        super(id,modelName);
    }
    public void fly() {
        System.out.println("flying");
    }
    public void turnOn() {System.out.println("turning on");}
    public void getCoordinates() {
        System.out.println("getting the coordinates");
    }
    @Override
    public void performMainTask() {
        System.out.println("performing main task");
    }
} 
class FishRobot extends Robot implements Swimmable {
    public FishRobot(int id, String modelName) {
        super(id,modelName);
    }
    public void swim() {
        System.out.println("swimming");
    }
    @Override
    public void performMainTask() {
        System.out.println("performing main task");
    }
}
class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {
    public AmphibiousRobot(int id, String modelName) {
        super(id,modelName);
    }
    public void fly() {
        System.out.println("flying");
    }
    public void swim() {
        System.out.println("swimming");
    }
    public void getCoordinates() {
        System.out.println("getting the coordinates");
    }
    @Override
    public void performMainTask() {
        System.out.println("performing main task");
    }
} 
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       sc.nextLine();
       Robot[] robot = new Robot[n];
       for (int i = 0; i < n; i++) {
           String line = sc.nextLine();
           String[] comp = line.split("\\s+");
           if(comp[0].equals("DR")) {
               robot[i] = new DroneRobot(Integer.parseInt(comp[1]), comp[2]);
           }
           else if(comp[0].equals("FR")) {
               robot[i] = new FishRobot(Integer.parseInt(comp[1]), comp[2]);
           }
           else {
               robot[i] = new AmphibiousRobot(Integer.parseInt(comp[1]), comp[2]);
           }
       }
       for(Robot bot : robot) {
           bot.getName();
           bot.performMainTask();
           if(bot instanceof Flyable) {
                Flyable temp = (Flyable) bot;
                bot.getName();
                temp.fly();
           }
           if(bot instanceof Swimmable) {
               Swimmable temp = (Swimmable) bot;
               bot.getName();
               temp.swim();
           }
           if(bot instanceof GPS) {
               GPS temp = (GPS) bot;
               bot.getName();
               temp.getCoordinates();
           }
       }
       /*Robot[] robot = new Robot[1];
       robot[0] = new DroneRobot(1, "hi");
       DroneRobot temp = (DroneRobot) robot[0];
       if(temp instanceof Flyable) {
           temp.fly();
       }*/
    }
}