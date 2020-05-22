package GenericsExercises.SwapMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd=new BufferedReader(new InputStreamReader(in));

        List<Swap>list=new ArrayList<>();

        int n=Integer.parseInt(rd.readLine());

        while (n-- >0){
            String word=rd.readLine();
            Swap<String>swap=new Swap<>(word);
            list.add(swap);

        }
        int []indexes= Arrays.stream(rd.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Swap.getSwap(list, indexes[0], indexes[1]);
        for (Swap swap : list) {
            System.out.println(swap);
        }


    }
}
