import java.util.*;

interface WifiConnectable {
    void setupWifi();
}

abstract class Device {
    protected String id;
    protected String name;
    protected boolean isOn;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.isOn = true;
    }

    public abstract void turnOff();
}

class Light extends Device {
    public Light(String id, String name) {
        super(id, name); 
    }
    public void turnOff() {
        System.out.println(name + " turned off"); 
    }
}

class AirConditioner extends Device implements WifiConnectable {
    public AirConditioner(String id, String name) {
        super(id, name); 
    }

    public void turnOff() {
        System.out.println(name + " turned off"); 
    }
    
    public void setupWifi() {
        System.out.println(name + " connected to wifi");
    }
}

class Speaker extends Device implements WifiConnectable {
    public Speaker(String id, String name) {
        super(id, name);
    }
   
    public void turnOff() {
        System.out.println(name + " turned off");
    }
    
    public void setupWifi() { 
        System.out.println(name + " connected to wifi");
    }
}

class Curtain extends Device {
    public Curtain(String id, String name) {
        super(id, name);
    }

    public void turnOff() {
        System.out.println(name + " turned off");
    }
}


class SmartHub {
    private List<Device> devices = new ArrayList<>();

    public void addDevice(Device d) {
        devices.add(d);
    }

    public void turnOffAll() {
        System.out.println("Turn Off All Devices:");
        for (Device d : devices) 
            d.turnOff();
    }

    public void setupWifiAll() {
        System.out.println("\nSetup Wifi:");
        for (Device d : devices) {
            if (d instanceof WifiConnectable) {
                ((WifiConnectable) d).setupWifi();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SmartHub hub = new SmartHub();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];

            switch (type) {
                case "L": 
                    hub.addDevice(new Light(id, name)); 
                    break;
                case "AC": 
                    hub.addDevice(new AirConditioner(id, name)); 
                    break;
                case "S": 
                    hub.addDevice(new Speaker(id, name)); 
                    break;
                case "C": 
                    hub.addDevice(new Curtain(id, name)); 
                    break;
            }
        }

        hub.turnOffAll();
        hub.setupWifiAll();
    }
}