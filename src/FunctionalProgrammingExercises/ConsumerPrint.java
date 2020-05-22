package FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class ConsumerPrint {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        List<String> list=  Arrays.stream(rd.readLine().split("\\s+")).collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
