package JavaAdvancedExams.Fubruary222020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class Lootbox {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        ArrayDeque<Integer> firstLoot= Arrays.stream(rd.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondLoot= Arrays.stream(rd.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer>claimed=new ArrayList<>();


        while (!firstLoot.isEmpty()&&!secondLoot.isEmpty()){

            int sum=firstLoot.getFirst()+secondLoot.getLast();

            if (sum%2==0){
                claimed.add(sum);
                firstLoot.removeFirst();
                secondLoot.removeLast();
            }else {
                firstLoot.addLast(secondLoot.removeLast());
            }
        }

        if (firstLoot.isEmpty()){

            System.out.println("First lootbox is empty");

        }

        if (secondLoot.isEmpty()){

            System.out.println("Second lootbox is empty");
        }

        int sum=0;
        for (Integer integer : claimed) {
            sum+=integer;
        }

        if (sum>=100){
            System.out.printf("Your loot was epic! Value: %d",sum);
        }else {
            System.out.printf("Your loot was poor... Value: %d",sum);
        }

    }
}
