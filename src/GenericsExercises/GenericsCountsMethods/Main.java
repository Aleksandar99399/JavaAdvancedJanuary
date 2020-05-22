package GenericsExercises.GenericsCountsMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        int n=Integer.parseInt(scanner.nextLine());
        List<Double>list=new ArrayList<>();

        while (n-- >0){
            double sequence=Double.parseDouble(scanner.nextLine());
            list.add(sequence);
        }
        double word=Double.parseDouble(scanner.nextLine());
        Comparable.getMax(list,word);
        System.out.println(Comparable.getCount());
    }
}
