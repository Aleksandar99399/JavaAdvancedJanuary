package FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class KnightsOfHonor {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        Consumer<String>consumer=e-> System.out.println("Sir "+ e);

        List<String> collect = Arrays.stream(rd.readLine().split("\\s+")).collect(Collectors.toList());

        collect.forEach(e->consumer.accept(e));
    }
}
