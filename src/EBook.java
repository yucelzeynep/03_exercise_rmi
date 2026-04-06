import java.io.Serializable;

public class EBook extends Book implements Serializable {
    private int fileSize;

    // Constructor for the EBook class
    public EBook(String title, String author, int fileSize) {
        // Call the constructor of the superclass Book and
        // initialize the fileSize attribute
        super(title, author);
        this.fileSize = fileSize;
    }

    // Override the getDetails method to include E-Book specific information
    public String getDetails() {
        // Call the superclass's getDetails method to get common details
        // Append E-Book specific detail: file size in MB
        return super.getDetails() + " [E-Book, File size (MB): " + fileSize + "]";    }
}