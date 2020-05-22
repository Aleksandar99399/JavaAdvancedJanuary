package FilesAndStreamsExercises;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class WordCount06 {
    public static void main(String[] args) throws IOException {

        Path path= Paths.get("C:\\Users\\User\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources");
        String words=path+ "\\words.txt";
        String text=path+ "\\text.txt";

        FileReader wordsReader=new FileReader(words);
        BufferedReader reader=new BufferedReader(wordsReader);
        Set<String>set= Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toSet());

        Map<String,Integer>sequence=new LinkedHashMap<>();
        for (String s : set) {
            sequence.put(s,0);
        }

        FileReader textReader=new FileReader(text);
        Consumer<Map.Entry<String,Integer>>consumer= e-> System.out.println(e.getKey()+" - "+e.getValue());

        try (BufferedReader rd=new BufferedReader(textReader)){
            String[] array=rd.readLine().split("\\s+");
            for (int i = 0; i < array.length; i++) {
                if (sequence.containsKey(array[i])){
                    sequence.put(array[i],sequence.get(array[i])+1);
                }
            }
            sequence.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue())).forEach(e->consumer.accept(e));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
