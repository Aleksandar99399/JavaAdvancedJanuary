package SetAndMapsAdvancedExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class AminerTask06 {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        Map<String,Integer>sequence=new LinkedHashMap<>();
        String input=rd.readLine();
        int count=1;
        String save="";

        while (!"stop".equals(input)){
            if (count%2!=0){
                save=input;
                if (!sequence.containsKey(save)) {
                    sequence.put(save, 0);
                }

            }else {
                int quantity=Integer.parseInt(input);
                sequence.put(save, sequence.get(save) + quantity);

            }

            count++;
            input=rd.readLine();
        }
        for (Map.Entry<String, Integer> entry : sequence.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }

    }
}
