import java.io.*;

public class FileManager {

    private String inputFilePath = null;
    private String outputFilePath = null;
    public String getInputFilePath() {return inputFilePath;}
    public String getOutputFilePath() {return outputFilePath;}

    public FileManager(String inputFilepath, /*int encryptionKey ,*/String outputFilePath){
        this.inputFilePath = inputFilepath;
        this.outputFilePath = outputFilePath;
    }

    public String readFile() throws IOException {
        StringBuilder fileContent = new StringBuilder();
        String currentLine;

        try (BufferedReader br = new BufferedReader(new FileReader(this.inputFilePath))) {
            while((currentLine = br.readLine()) != null) {
                fileContent.append(currentLine);
            }
        }
        return fileContent.toString();
    }

    public static void writeFile(String content, String fileName) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(content);
        } catch (IOException e) {
            System.out.println("Unable to write the file. Error: " + e.getMessage());
        }
    }
}