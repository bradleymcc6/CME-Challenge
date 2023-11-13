import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public void createFile(String text){
        try {
            File file = new File("ValuesAndResults.txt");
            //Create new file if does not exist already
            file.createNewFile();
            writeToFile(text);
            } catch (IOException exception) {
                    System.out.println("An error occurred when interacting with the file.");
                    exception.printStackTrace();
                }
            }
    public void writeToFile(String text){
            try {
                FileWriter fileWriter = new FileWriter("ValuesAndResults.txt", true);
                fileWriter.write(text);
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred when writing to the file");
                e.printStackTrace();
            }
        }
    }



