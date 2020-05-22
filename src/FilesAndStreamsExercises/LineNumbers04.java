package FilesAndStreamsExercises;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LineNumbers04 {
    public static void main(String[] args) throws FileNotFoundException {

        Path path= Paths.get("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        String output="C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLineNumbers.txt";
        FileReader fileReader=new FileReader(String.valueOf(path));

        int count=1;
        try (BufferedReader rd=new BufferedReader(fileReader)){
            String line=rd.readLine();

            FileWriter fileWriter=new FileWriter(output);
            while (line!=null){
                fileWriter.write(count+ ". "+line);

                line=rd.readLine();
                count++;

                fileWriter.write("\r\n");
                fileWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
