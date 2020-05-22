package SetAndMapsAdvancedExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class SetsOfElements02 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        int[]setsLength= Arrays.stream(rd.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstLength=setsLength[0];
        int secondLength=setsLength[1];

        Set<Integer>oneSet=new LinkedHashSet<>();
        Set<Integer>twoSet=new LinkedHashSet<>();

        for (int i = 1; i <= firstLength + secondLength; i++) {
            int num = Integer.parseInt(rd.readLine());
            if (i <= firstLength) {
                oneSet.add(num);
            } else {
                twoSet.add(num);
            }

        }
        for (int curr:oneSet){
            if (twoSet.contains(curr)){
                System.out.print(curr+" ");
            }
        }
//
        //for (Integer integer : save) {
        //    System.out.print(integer+ " ");
        //}
    }
}
