package StackAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;

public class BasicStackOperations02 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        int[]tokens= Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int pushCount=tokens[0];
        int popCount=tokens[1];
        int isExist=tokens[2];

        int[] numbers=Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Stack<Integer> operation=new Stack<>();

        for (int i = 0; i < pushCount; i++) {
            operation.push(numbers[i]);
        }

        for (int i = 0; i < popCount; i++) {
            operation.pop();
        }

        if (!operation.isEmpty()) {
            if (operation.contains(isExist)) {
                System.out.println("true");
            } else {
                int num = Integer.MAX_VALUE;
                for (Integer integer : operation) {
                    if (integer < num) {
                        num = integer;
                    }
                }
                System.out.println(num);

            }
        }else {
            System.out.println(0);
        }
    }
}
