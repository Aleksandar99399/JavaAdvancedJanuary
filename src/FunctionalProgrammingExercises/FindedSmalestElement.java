package FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class FindedSmalestElement {

    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        List<Integer>list= Arrays.stream(rd.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>,Integer>function=e->{
            int min=Integer.MAX_VALUE;
            int index=0;
            for (Integer integer : e) {
                if (integer<min){
                    min=integer;
                    index=e.indexOf(integer);
                }else if (integer==min){
                    index=e.indexOf(integer);
                }
            }
            return index;
        };
        int n=function.apply(list);
        out.println(n);


    }
}
