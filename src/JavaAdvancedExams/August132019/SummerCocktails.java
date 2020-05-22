package JavaAdvancedExams.August132019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class SummerCocktails {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        Map<String, Integer> map = new HashMap<>();
        map.put("Mimosa", 150);
        map.put("Daiquiri", 250);
        map.put("Sunshine", 300);
        map.put("Mojito", 400);
        ArrayDeque<Integer> countIngredients = Arrays.stream(rd.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> levelIngredients = Arrays.stream(rd.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> save = new TreeMap<>();

        while (!countIngredients.isEmpty() && !levelIngredients.isEmpty()) {

            int sum = countIngredients.getFirst() * levelIngredients.getLast();

            if (countIngredients.getFirst()==0){
                countIngredients.removeFirst();
                continue;
            }
            if (map.containsValue(sum)){
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue()==sum){
                        if (!save.containsKey(entry.getKey())){
                            save.put(entry.getKey(),1);
                        }else {
                            save.put(entry.getKey(),save.get(entry.getKey())+1);
                        }
                    }
                }
                countIngredients.removeFirst();
                levelIngredients.removeLast();

            }else {

                int num=countIngredients.removeFirst();
                countIngredients.addLast(num+5);
                levelIngredients.removeLast();
            }
        }
        boolean cocktails=true;
        for (String s : map.keySet()) {
            if (!save.containsKey(s)){
                cocktails=false;
            }
        }
        for (Integer value : save.values()) {
            if (value<1){
                cocktails=false;
            }
        }


        if (cocktails){
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!countIngredients.isEmpty()){
            int sum=0;
            for (Integer integer : countIngredients) {
                sum+=integer;
            }
            System.out.printf("Ingredients left: %d%n",sum);
        }

        if (!save.isEmpty()) {
            for (Map.Entry<String, Integer> entry : save.entrySet()) {
                System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
            }
        }


    }
}
