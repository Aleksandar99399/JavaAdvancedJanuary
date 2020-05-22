package StackAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class BasicQueueOperations04 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        int []tokens= Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n=tokens[0];
        int s=tokens[1];
        int isExist=tokens[2];

        int[]numbers=Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer>deque=new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque.add(numbers[i]);
        }

        for (int i = 0; i < s; i++) {
            deque.pop();
        }

        if (!deque.isEmpty()){
            if (deque.contains(isExist)){
                System.out.println("true");
            }else {
                int min=Integer.MAX_VALUE;
                for (Integer integer : deque) {
                    if (integer < min) {
                        min = integer;
                    }
                }
                System.out.println(min);

            }
        }else {
            System.out.println(0);
        }
    }
}
