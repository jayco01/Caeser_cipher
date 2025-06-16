import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    private String inputFilePath = null;
    private String outputFilePath = null;
    public String getInputFilePath() {return inputFilePath;}
    public String getOutputFilePath() {return outputFilePath;}

    public FileManager(String inputFilepath, String outputFilePath){
        this.inputFilePath = inputFilepath;
        this.outputFilePath = outputFilePath;
    }


    //Reads the entire content of a file into a single string using Java NIO.2.
    public String readFile() throws IOException {

        Path path = Paths.get(this.inputFilePath);
        return Files.readString(path);
    }

    /**
     * Writes the given string to a file using Java NIO.2.
     * This method will overwrite the file if it already exists.
     */
    public static void writeFile(String content, String fileName) throws IOException {
        try {
            Path path = Paths.get(fileName);
            Files.writeString(path, content);
        } catch (IOException e) {
            System.out.println("Unable to write the file. Error: " + e.getMessage());
            System.out.println(e.getStackTrace().toString());
            throw e;
        }
    }
}

