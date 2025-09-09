package ca.saultcollege;

import static ca.saultcollege.BookStorage.books;
import static ca.saultcollege.BookStorage.in;


public class Main {
    public static void main(String[] args) {
        int choice;
        do {
            menu();
            choice = getInt("Enter your choice: ");
            switch (choice) {
                case 1 -> add();
                case 2 -> edit();
                case 3 -> del();
                case 4 -> list();
                case 99 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 99);
    }

    static void menu() {
        System.out.println("\n ----------------");
        System.out.println("   1. Add Book\n   2. Edit Book\n   3. Delete Book\n   4. List Books\n  99. Exit");
        System.out.println(" ----------------");
    }

    static void add() {
        System.out.print("Enter Title: ");  String t = in.nextLine();
        System.out.print("Enter Author: "); String a = in.nextLine();
        System.out.print("Enter ISBN: ");   String i = in.nextLine();
        int p = getInt("Enter page count: ");
        books.add(new Book(t,a,i,p));
    }

    static void edit() {
        if (books.isEmpty()) { System.out.println("No books."); return; }
        list();
        int n = getInt("Enter book number to edit: ") - 1;
        if (n < 0 || n >= books.size()) return;
        Book b = books.get(n);
        System.out.print("New Title ("+b.title+"): "); b.title = in.nextLine();
        System.out.print("New Author ("+b.author+"): "); b.author = in.nextLine();
        System.out.print("New ISBN ("+b.isbn+"): "); b.isbn = in.nextLine();
        b.pages = getInt("New Pages ("+b.pages+"): ");
    }

    static void del() {
        if (books.isEmpty()) { System.out.println("No books."); return; }
        list();
        int n = getInt("Enter book number to delete: ") - 1;
        if (n >= 0 && n < books.size()) books.remove(n);
    }

    static void list() {
        if (books.isEmpty()) { System.out.println("No books."); return; }
        for (int i=0;i<books.size();i++)
            System.out.println((i+1)+". " + books.get(i));
    }

    static int getInt(String msg) {
        System.out.print(msg);
        while (!in.hasNextInt()) { in.next(); System.out.print(msg); }
        int x = in.nextInt(); in.nextLine();
        return x;
    }
}