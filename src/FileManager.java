import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private String filePath = null;

    public FileManager(String filepath){
        this.filePath = filepath;
    }

    public String readFile() throws IOException {
        StringBuilder fileContent = new StringBuilder();
        String currentLine;

        try(BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            while((currentLine = br.readLine()) != null) {
                fileContent.append(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fileContent.toString();
    }

    public static void writeFile(String content, String filePath) {
        // Logic for writing a file
    }
}