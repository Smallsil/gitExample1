package ca.saultcollege;

class Book {
    String title, author, isbn;
    int pages;

    Book(String t, String a, String i, int p) {
        title = t; author = a; isbn = i; pages = p;
    }

    public String toString() {
        return "Title: " + title +
                "    Author: " + author +
                "    Pages: " + pages +
                "    ISBN: " + isbn;
    }
}