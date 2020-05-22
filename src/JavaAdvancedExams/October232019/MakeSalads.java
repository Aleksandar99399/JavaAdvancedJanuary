package JavaAdvancedExams.October232019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class MakeSalads {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        Map<String, Integer> saveVegetable = new HashMap<>();
        saveVegetable.put("tomato", 80);
        saveVegetable.put("carrot", 136);
        saveVegetable.put("lettuce", 109);
        saveVegetable.put("potato", 215);

        String[] inpVegetable = rd.readLine().split("\\s+");
        int[] inpCalories = Arrays.stream(rd.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<String> vegetable = new ArrayDeque<>(Arrays.asList(inpVegetable));
        ArrayDeque<Integer> calories = new ArrayDeque<>();

        ArrayDeque<Integer>saveCalories=new ArrayDeque<>();
        LinkedList<Integer> readySalads = new LinkedList<>();
        for (int i = 0; i < inpCalories.length; i++) {
            saveCalories.push(inpCalories[i]);
            calories.push(inpCalories[i]);
        }


        int save=0;
        int wait=0;
        int res=0;

        while (!vegetable.isEmpty() && !saveCalories.isEmpty()) {

            if (saveVegetable.containsKey(vegetable.getFirst())) {
                res=calories.getFirst();
                res-= saveVegetable.get(vegetable.getFirst());
                if (res<=0){
                    if (calories.getFirst()>saveVegetable.get(vegetable.getFirst())){
                        readySalads.add(saveCalories.getFirst());
                        saveCalories.removeFirst();
                        calories.push(Math.abs(calories.removeFirst() - saveVegetable.get(vegetable.getFirst())));
                    }else {
                        calories.push(Math.abs(calories.removeFirst() - saveVegetable.get(vegetable.getFirst())));

                    }

                }else {
                    calories.push(Math.abs(calories.removeFirst() - saveVegetable.get(vegetable.getFirst())));
                }

                vegetable.removeFirst();

            }
        }

        for (Integer readySalad : readySalads) {
            System.out.print(readySalad+" ");
        }
        System.out.println();

        if (!vegetable.isEmpty()){
            for (String s : vegetable) {
                System.out.print(s+ " ");
            }

        }else {
            for (Integer calory : saveCalories) {
                System.out.print(calory+" ");
            }

        }


    }
}
