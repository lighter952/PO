public class FictionBook extends Book  implements Borrowable{
    private String genre;

    public FictionBook(String title, String author, int year, String genre) {
        super(title, author, year);
        this.genre = genre;
    }

    @Override
    public void getDetails() {
        System.out.println("Fiction Book - Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getYear() + ", Genre: " + genre);
    }

    @Override
    public void borrow() {
        System.out.println("Borrowing a fiction book: " + super.getTitle());
    }

    @Override
    public void returnBook() {
        System.out.println("Returning a fiction book: " + super.getTitle());
    }
}
