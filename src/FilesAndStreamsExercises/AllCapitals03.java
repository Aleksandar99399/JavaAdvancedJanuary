package FilesAndStreamsExercises;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllCapitals03 {
    public static void main(String[] args) throws FileNotFoundException {

        Path path= Paths.get("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        String outPath="C:\\\\Users\\\\User\\\\Desktop\\\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        FileReader reader=new FileReader(String.valueOf(path));

        try (BufferedReader rd=new BufferedReader(reader)){
            String line=rd.readLine();

            PrintWriter pW=new PrintWriter(outPath);
            while (line!=null){

                for (int i = 0; i < line.length(); i++) {
                    char ch=Character.toUpperCase(line.charAt(i));

                    pW.write(ch);
                    pW.flush();
                }
                pW.write("\r\n");
                line=rd.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
