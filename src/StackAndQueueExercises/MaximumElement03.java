package StackAndQueueExercises;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class MaximumElement03 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        int n=Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer>sequence=new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int []input= Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (input[0]==1){
                sequence.push(input[1]);
            }else if (input[0]==2){
                sequence.pop();
            }else if (input[0]==3){
                int num=Integer.MIN_VALUE;
                for (Integer integer : sequence) {
                    if (integer>num){
                        num=integer;
                    }
                }
                System.out.println(num);

            }
        }

    }
}
