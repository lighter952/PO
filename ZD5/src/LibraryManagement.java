import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Book> booksInLibrary = new ArrayList<Book>();
    private ArrayList<Book> booksInBorrow = new ArrayList<Book>();

    void printListlibraryBooks(){
        if(booksInLibrary.isEmpty()){
            System.out.println("No books in library!");
            menu();
        }
        for(int i = 0; i < booksInLibrary.size(); i++) {
            System.out.print((i + 1) + ": ");
            booksInLibrary.get(i).getDetails();
        }
    }

    void printListBorrowedBooks(){
        if(booksInBorrow.isEmpty()){
            System.out.println("No borrowed books!");
            menu();
        }
        for(int i = 0; i < booksInBorrow.size(); i++) {
            System.out.print((i + 1) + ": ");
            booksInBorrow.get(i).getDetails();
        }
    }

    void addBookToLibrary(Book book) {
        booksInLibrary.add(book);
    }

    void removeBookFromLibrary(Book book) {
        booksInLibrary.remove(book);
    }

    void printMenuOfBorrowing(Book book, boolean isBorrowed) {
        if(isBorrowed) {

            System.out.println("1 - Return a book");
            System.out.println("2 - Get details");

            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    book.returnBook();
                    booksInLibrary.add(book);
                    booksInBorrow.remove(book);
                }
                case 2 -> {
                    book.getDetails();
                }
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }

        } else {
            System.out.println("1 - Borrow a book");
            System.out.println("2 - Get details");

            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    book.borrow();
                    booksInBorrow.add(book);
                    booksInLibrary.remove(book);
                }
                case 2 -> {
                    book.getDetails();
                }
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        }
    }

    void menu() {
        while (true) {
            boolean isBorrowed = false;
            System.out.println("1 - Books in library");
            System.out.println("2 - Borrowed books");
            System.out.println("0: Exit");
            int input = scanner.nextInt();

            if(input == 1){
                printListlibraryBooks();
                isBorrowed = false;
            } else if (input == 2) {
                printListBorrowedBooks();
                isBorrowed = true;
            } else if(input == 0){
                System.exit(1);
            }
            System.out.println("0: Exit");
            System.out.println("Chose the book: ");
            input = scanner.nextInt();
            if(input == 0) {
                System.exit(1);
            }
            printMenuOfBorrowing(booksInLibrary.get(input - 1), isBorrowed);

        }
    }



}
