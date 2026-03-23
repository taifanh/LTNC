interface IData {
    void show();
}

class DataManager implements IData {
    public void show() {
        System.out.println("Show Data");
    }
}

public class Main {
    public static void main(String[] args) {
        DataManager dm = new DataManager();
        dm.show();
    }
}