package FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class CustomMinFunction {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        Set<Integer>set= Arrays.stream(rd.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toSet());

        Function<int[],Integer>function=(a)->{
            int min=Integer.MAX_VALUE;
            for (int integer : a) {
                if (integer<min){
                    min=integer;
                }
            }
            return min;
        };
        int[] arr=new int[set.size()];
        int index=0;
        for (Integer integer : set) {
            arr[index++]=integer;

        }

        int n=function.apply(arr);
        System.out.println(n);
    }
}
