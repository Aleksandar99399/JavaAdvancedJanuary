package JavaAdvancedExams.December172019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class PresentFactory {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        int []input1= Arrays.stream(rd.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int []input2= Arrays.stream(rd.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer>materialsInBox=new ArrayDeque<>();

        ArrayDeque<Integer>magicLevel=new ArrayDeque<>();

        for (int i = 0; i < input1.length; i++) {
            materialsInBox.push(input1[i]);
        }
        for (int i = 0; i < input2.length; i++) {
            magicLevel.add(input2[i]);
        }

        Map<String,Integer>presents=new TreeMap<>();

        while (materialsInBox.size()!=0 && magicLevel.size()!=0){


            int sum=magicLevel.getFirst()*materialsInBox.getFirst();
            if (sum==0){
                if (magicLevel.getFirst()==0){
                    magicLevel.removeFirst();
                }
                if (materialsInBox.getFirst()==0){
                    materialsInBox.removeFirst();
                }
            }else if (sum>0){
                if (sum==150){
                    if (!presents.containsKey("Doll")) {
                        presents.put("Doll", 1);
                    }else {
                        presents.put("Doll",presents.get("Doll")+1);
                    }

                }else if (sum==250){

                    if (!presents.containsKey("Wooden train")) {
                        presents.put("Wooden train", 1);
                    }else {
                        presents.put("Wooden train",presents.get("Wooden train")+1);
                    }

                }else if (sum==300){

                    if (!presents.containsKey("Teddy bear")) {
                        presents.put("Teddy bear", 1);
                    }else {
                        presents.put("Teddy bear",presents.get("Teddy bear")+1);
                    }


                }else if (sum==400){

                    if (!presents.containsKey("Bicycle")) {
                        presents.put("Bicycle", 1);
                    }else {
                        presents.put("Bicycle",presents.get("Bicycle")+1);
                    }

                }else {
                    int plus=materialsInBox.removeFirst()+15;
                    magicLevel.removeFirst();
                    materialsInBox.push(plus);
                    continue;
                }
                materialsInBox.removeFirst();
                magicLevel.removeFirst();

            }else {
                int plus=magicLevel.getFirst()+materialsInBox.getFirst();
                materialsInBox.removeFirst();
                magicLevel.removeFirst();
                materialsInBox.push(plus);

            }

        }
        if (presents.containsKey("Teddy bear")&&presents.containsKey("Bicycle")
                || presents.containsKey("Doll")&&presents.containsKey("Wooden train")){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }
        if (materialsInBox.size()>0){
            System.out.println("Materials left: "+materialsInBox.toString().replaceAll("[\\[\\]]", ""));
        }
        if (magicLevel.size()>0){
            System.out.println("Magic left: "+magicLevel.toString().replaceAll("[\\[\\]]", ""));
        }
        for (Map.Entry<String, Integer> entry : presents.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }


        }

}

