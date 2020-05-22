package StackAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import static java.lang.System.in;

public class RecursiveFibonacci {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        ArrayDeque<Long> fibo=new ArrayDeque<>();

        int n=Integer.parseInt(scanner.nextLine());

        fibo.push((long) 1);
        fibo.push((long) 1);
        int count=1;
        for (int i = 0; i < n-1; i++) {
            long num =fibo.getFirst()+fibo.getLast();
            fibo.push(num);
            fibo.removeLast();
        }
        long sum=fibo.pop();
        System.out.println(sum);
    }
}
