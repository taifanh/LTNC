package Prob2_10;

class SmartLight {
    private String id, name;
    private int brightness;

    SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }

    SmartLight(String id, String name) {
        this(id, name, 50);
    }

    void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    void setBrightness(String preset) {
        if(preset == "MAX")
            setBrightness(100);
        else if(preset == "MIN")
            setBrightness(10);
        else if(preset == "ECO")
            setBrightness(30);
    }

    int getBrightness() {
        return brightness;
    }

    String getName() {
        return name;
    }

    void connectToHub(CentralHub hub) {
        hub.registerDevice(this);
    }
}

class CentralHub {
    void registerDevice(SmartLight light) {
        System.out.println("[HUB] is connecting to " + light.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        CentralHub hub = new CentralHub();
        SmartLight l1 = new SmartLight("L01", "A", 80);
        SmartLight l2 = new SmartLight("L02", "B");
        System.out.println(l1.getBrightness() + " " + l2.getBrightness());

        l2.setBrightness("ECO");
        System.out.println(l1.getBrightness() + " " + l2.getBrightness());

        l1.connectToHub(hub);
        l2.connectToHub(hub);
    }
}
