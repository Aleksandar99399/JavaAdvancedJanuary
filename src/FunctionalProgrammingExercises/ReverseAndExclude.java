package FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class ReverseAndExclude {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        List<Integer>list= Arrays.stream(rd.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int n=Integer.parseInt(rd.readLine());

        Predicate<Integer>predicate=i->i%n!=0;

        Collections.reverse(list);
        list=list.stream().filter(i->predicate.test(i)).collect(Collectors.toList());

        for (Integer integer : list) {
            System.out.print(integer+ " ");
        }

    }
}
