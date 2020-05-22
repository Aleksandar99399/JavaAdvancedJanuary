package FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class PredicateForNames {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        int n=Integer.parseInt(rd.readLine());

        List<String>list= Arrays.stream(rd.readLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String>predicate=i->i.length()<=n;
        list=list.stream().filter(e->predicate.test(e)).collect(Collectors.toList());

        for (String s : list) {
            System.out.println(s);
        }


    }
}
