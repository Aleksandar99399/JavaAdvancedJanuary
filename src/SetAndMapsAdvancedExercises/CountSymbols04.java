package SetAndMapsAdvancedExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class CountSymbols04 {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        String input=rd.readLine();

        Set<Character>characterSet=new TreeSet<>();

        Map<Character,Integer>saveChar=new TreeMap<>();
        for (int i = 0; i <input.length() ; i++) {
            if (!saveChar.containsKey(input.charAt(i))) {
                saveChar.put(input.charAt(i),1);
            }else {
                saveChar.put(input.charAt(i),saveChar.get(input.charAt(i))+1);
            }
        }
        Collections.reverse(Collections.singletonList(saveChar));
        for (Map.Entry<Character, Integer> entry : saveChar.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue()+" time/s" );
        }

    }
}
