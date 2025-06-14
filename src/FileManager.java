import java.io.*;

public class FileManager {

    private String inputFilePath = null;
    private String outputFilePath = null;
    public String getInputFilePath() {return inputFilePath;}
    public String getOutputFilePath() {return outputFilePath;}

    public FileManager(String inputFilepath, String outputFilePath){
        this.inputFilePath = inputFilepath;
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
}