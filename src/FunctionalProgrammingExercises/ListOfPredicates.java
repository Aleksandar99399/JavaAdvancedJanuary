package FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class ListOfPredicates {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(rd.readLine());

        List<Integer> nums = Arrays.stream(rd.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> divisibleByCriteria = num -> {

            boolean print = true;

            for (Integer number : nums) {
                if (num%number!=0){
                    print = false;
                    break;
                }
            }
            return print;
        };

        for (int i = 1; i <=n; i++) {
            if (divisibleByCriteria.test(i)){
                System.out.print(i+" ");
            }
        }

    }
}
