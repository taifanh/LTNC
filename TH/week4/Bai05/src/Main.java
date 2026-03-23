class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public String toString() {
        return key + " - " + value;
    }
}

public class Main {
    public static void main(String[] args) {
        Pair <String, Integer> A = new Pair<>("Tuổi", 20);
        Pair <String, String> B = new Pair<>("Mã SV", "SV001");
        Pair <Integer, Double> C = new Pair<>(105, 21.5);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
    }
}