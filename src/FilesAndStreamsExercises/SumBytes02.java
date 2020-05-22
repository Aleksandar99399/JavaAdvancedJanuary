package FilesAndStreamsExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes02 {
    public static void main(String[] args) throws FileNotFoundException {


        Path path= Paths.get("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        FileReader reader=new FileReader(String.valueOf(path));

        try (BufferedReader rd=new BufferedReader(reader)){
            int count = 0;

            String line=rd.readLine();
            while (line!=null){

                for (int i = 0; i < line.length(); i++) {
                    count+=line.charAt(i);

                }
                line=rd.readLine();
            }
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
