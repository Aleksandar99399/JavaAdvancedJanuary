package SetAndMapsAdvancedExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class FixEmails07 {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        Map<String,String>sequence=new LinkedHashMap<>();

        String name=rd.readLine();
        int count=1;
        String save="";

        while (!"stop".equals(name)){

            if (count%2!=0){
                save=name;
            }else {
                if (!sequence.containsKey(save)) {
                    if (!(name.contains("us") || name.contains("uk") || name.contains("com"))) {
                        sequence.put(save, name);
                    }
                }
            }

            count++;
            name=rd.readLine();
        }
        for (Map.Entry<String, String> entry : sequence.entrySet()) {
            System.out.printf("%s -> %s%n",entry.getKey(),entry.getValue());
        }

    }
}
