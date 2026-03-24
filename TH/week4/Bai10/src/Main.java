import java.util.*;

abstract class MediaItem {
    protected String id;
    protected String title;

    public MediaItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public abstract String getDetails();
}

class Book extends MediaItem {
    private String author;
    private int pages;

    public Book(String id, String title, String author, int pages) {
        super(id, title);
        this.author = author;
        this.pages = pages;
    }

    public String getDetails() {
        return title + " - " + author + " - " + pages;
    }
}

class DVD extends MediaItem {
    private String director;
    private int duration;

    public DVD(String id, String title, String director, int duration) {
        super(id, title);
        this.director = director;
        this.duration = duration;
    }

    public String getDetails() {
        return title + " - " + director + " - " + duration;
    }
}

class LibrarySection<T extends MediaItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void displayItems() {
        for (T item : items) {
            System.out.println(item.getDetails());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<DVD> dvdSection = new LibrarySection<>();

        if (!sc.hasNextInt()) return;
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] p = line.split(" ");
            String type = p[0];

            if (type.equals("B")) {
                bookSection.addItem(new Book(p[1], p[2], p[3], Integer.parseInt(p[4])));
            } else if (type.equals("D")) {
                dvdSection.addItem(new DVD(p[1], p[2], p[3], Integer.parseInt(p[4])));
            }
        }

        System.out.println("Khu vực Sách:");
        bookSection.displayItems();

        System.out.println("\nKhu vực DVD:");
        dvdSection.displayItems();
        
        sc.close();
    }
}