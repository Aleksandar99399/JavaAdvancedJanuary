package StackAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class ReverseNumbersWithaStack01 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        int[]numbers= Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer>revers=new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            revers.push(numbers[i]);

        }
        for (Integer rever : revers) {
            System.out.print(rever+" ");
        }

    }
}
