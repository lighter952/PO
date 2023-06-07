// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LibraryManagement manager = new LibraryManagement();
        FictionBook book1 = new FictionBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Classic");
        FictionBook book2 = new FictionBook("Pride and Prejudice", "Jane Austen", 1946, "Classic");
        FictionBook book3 = new FictionBook("His Dark Materials", "Philip Pullman", 1978, "Classic");
        FictionBook book4 = new FictionBook("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1912, "Classic");

        manager.addBookToLibrary(book1);
        manager.addBookToLibrary(book2);
        manager.addBookToLibrary(book3);
        manager.addBookToLibrary(book4);

        manager.menu();
    }
}