import java.io.*;
import java.util.*;

public class Library {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Save Books");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    saveBooks();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);
    }

    static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        Book b = new Book(id, name, author);
        books.add(b);

        System.out.println("Book Added Successfully");
    }

    static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available");
            return;
        }

        for (Book b : books) {
            b.display();
        }
    }

    static void saveBooks() {

        try {

            FileOutputStream fos = new FileOutputStream("library.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(books);

            oos.close();
            fos.close();

            System.out.println("Books saved successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
