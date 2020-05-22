package SetAndMapsAdvancedExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.System.in;

public class Phonebook05 {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        String[] nameAndNumber = rd.readLine().split("-");
        Map<String,String>phoneBook=new LinkedHashMap<>();

        while (!"search".equals(nameAndNumber[0])){
            String name = nameAndNumber[0];
            String number = nameAndNumber[1];

            phoneBook.put(name, number);

            nameAndNumber=rd.readLine().split("-");
        }
        String names=rd.readLine();



        while (!"stop".equals(names)){

            if (phoneBook.containsKey(names)){
                System.out.printf("%s -> %s%n",names,phoneBook.get(names));
            }else {
                System.out.printf("Contact %s does not exist.%n",names);
            }

            names=rd.readLine();
        }


    }

}
