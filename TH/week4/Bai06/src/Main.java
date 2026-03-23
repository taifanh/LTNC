class ArrayUtils {
    public static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}

class Student implements Comparable<Student> {
    int id;
    String name;
    double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int compareTo(Student other) {
        return Double.compare(this.id, other.id);
    }

    public String toString() {
        return id + " (" + name + ", " + gpa + ")";
    }
}

public class Main {
    public static <T> void printarray(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] A = new Integer[]{5, 1, 3, 2};
        String[] B = new String[]{"Java", "C++", "Python"};
        Student[] C = new Student[]{
            new Student(25021642, "Tai Anh", 3.73),
            new Student(24061987, "Messi", 4.0)
        };

        ArrayUtils.sort(A);
        ArrayUtils.sort(B);
        ArrayUtils.sort(C);

        printarray(A);
        printarray(B);
        printarray(C);
    }
}