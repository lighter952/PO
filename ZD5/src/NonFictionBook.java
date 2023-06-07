public class NonFictionBook extends Book implements Borrowable {

    private String topic;

    public NonFictionBook(String title, String author, int year, String topic) {
        super(title, author, year);
        this.topic = topic;
    }

    @Override
    public void getDetails() {
        System.out.println("Non-Fiction Book - Title: " + getTitle() + ", Author: " + getAuthor() + ", Year: " + getYear() + ", Topic: " + topic);
    }

    @Override
    public void borrow() {
        System.out.println("Borrowing a non-fiction book: " + getTitle());
    }

    @Override
    public void returnBook() {
        System.out.println("Returning a non-fiction book: " + getTitle());
    }
}
