package FilesAndStreamsExercises;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.in;

public class SumLines01 {
    public static void main(String[] args) throws FileNotFoundException {

        Path path= Paths.get("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        FileReader reader=new FileReader(String.valueOf(path));

        try (BufferedReader rd=new BufferedReader(reader)){
            String text=rd.readLine();

            while (text!=null){
                int sum=0;

                for (int i = 0; i < text.length(); i++) {
                    sum+=text.charAt(i);
                }
                System.out.println(sum);
                text=rd.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
