package FilesAndStreamsExercises;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountCharacterTypes04 {
    public static void main(String[] args) throws FileNotFoundException {

        Path path= Paths.get("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        String outPath="C:\\\\Users\\\\User\\\\Desktop\\\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        FileReader fileReader=new FileReader(String.valueOf(path));

        String vowels="aeoiu";
        String punctuation="!,.?";

        int vow=0;
        int pun=0;
        int cons=0;
        try (BufferedReader rd=new BufferedReader(fileReader)){
            String line=rd.readLine();

            FileWriter fileWriter=new FileWriter(outPath);

            while (line!=null){
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);

                    if (vowels.contains(Character.toString(c))) {
                        vow += 1;
                    } else if (punctuation.contains(Character.toString(c))){
                        pun+=1;
                    }else if (c==32){
                        continue;
                    }else {
                        cons+=1;
                    }


                }

                line=rd.readLine();
            }
            fileWriter.write("Vowels: "+ vow);
            fileWriter.write("\r\nConsonants: "+ cons);
            fileWriter.write("\r\nPunctuation: "+ pun);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
