package JavaAdvancedExams.Octomber2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class DatingApp {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        int []firstLine= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer>males=new ArrayDeque<>();

        int []secondLine= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer>females=new ArrayDeque<>();

        for (int i = 0; i < firstLine.length; i++) {
            males.push(firstLine[i]);

        }

        for (int i = 0; i < secondLine.length; i++) {
            females.add(secondLine[i]);

        }

        int countMatches=0;
        while (males.size()!=0&&females.size()!=0){
            if (males.getFirst()<=0){
                males.removeFirst();
                continue;
            }else if (females.getFirst()<=0){
                females.removeFirst();
                continue;
            }
            if (males.getFirst()%25==0){
                males.removeFirst();
                males.removeFirst();
                continue;
            }
            if (females.getFirst()%25==0){
                females.removeFirst();
                females.removeFirst();
                continue;
            }
            if (males.getFirst().equals(females.getFirst())){
                males.removeFirst();
                females.removeFirst();
                countMatches++;
            }else {
                females.removeFirst();
                int num=males.getFirst()-2;
                males.pop();
                males.addFirst(num);
            }
        }
        System.out.println("Matches: "+countMatches);

        if (males.size()==0){
            System.out.println("Males left: none");
        }else {
            System.out.println("Males left: "+males.toString().replaceAll("[\\[\\]]", ""));
        }
        if (females.size()==0){
            System.out.println("Females left: none");
        }else {

            System.out.println("Females left: "+females.toString().replaceAll("[\\[\\]]", ""));
        }

    }
}
