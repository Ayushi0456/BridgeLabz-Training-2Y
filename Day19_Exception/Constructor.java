import java.io.File;
import java.io.IOException;

class FileHandler {
    FileHandler(String filePath) throws IOException {
        File f = new File(filePath);
        if (!f.exists()) {
            throw new IOException("File not found during object creation!");
        }
    }
}

public class Constructor {
    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("abc.txt");
        } catch (IOException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }
    }
}

