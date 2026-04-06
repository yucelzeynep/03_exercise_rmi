import java.io.Serializable;

public class PrintedBook extends Book implements Serializable {    
    private int numberOfPages;

    public PrintedBook(String title, String author, int pages) {
        super(title, author);
        this.numberOfPages = pages;
    }

    public String getDetails() {
        return super.getDetails() + " [Printed, Pages: " + numberOfPages + "]";
    }
}