package FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class CustomComparator {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        List<Integer> list= Arrays.stream(rd.readLine().split("\\s+")).map(Integer::parseInt).sorted().collect(Collectors.toList());

        List<Integer>smen=new ArrayList<>();
        List<Integer>odd=new ArrayList<>();
        smen=list.stream().filter(e->e%2==0).collect(Collectors.toList());
        odd=list.stream().filter(e->e%2!=0).collect(Collectors.toList());
        Arrays.sort(smen.toArray());
        Arrays.sort(odd.toArray());
        for (Integer integer : smen) {
            System.out.print(integer+" ");
        }
        for (Integer integer : odd) {
            System.out.print(integer+" ");
        }


    }
}
