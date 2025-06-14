import java.io.*;

public class FileManager {

    private String inputFilePath = null;
    private String outputFilePath = null;
    private int encryptionKey = 0;
    public String getInputFilePath() {return inputFilePath;}
    public String getOutputFilePath() {return outputFilePath;}
    public int getEncryptionKey() {return encryptionKey;}

    public FileManager(String inputFilepath, int encryptionKey ,String outputFilePath){
        this.inputFilePath = inputFilepath;
        this.encryptionKey = encryptionKey;
        this.outputFilePath = outputFilePath;
    }

    public String readFile() throws IOException {
        StringBuilder fileContent = new StringBuilder();
        String currentLine;

        try(BufferedReader br = new BufferedReader(new FileReader(this.inputFilePath))) {
            while((currentLine = br.readLine()) != null) {
                fileContent.append(currentLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fileContent.toString();
    }

    public void writeFile(String content) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.outputFilePath))) {
            bw.write(content);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createFile(String fileName) throws IOException {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Unable to create the file. Error: " + e.getMessage());
        }
    }
}