package StackAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.in;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.addFirst("");

        String save="";

        StringBuilder text =new StringBuilder("");

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String num = tokens[0];
            String comm = tokens[1];


            if (num.equals("1")) {
                deque.addLast(comm);
                text.append(comm);
            } else if (num.equals("2")) {
                int count = Integer.parseInt(comm);
                for (int j = text.length()-1; j > text.length()-count; j--) {
                    ;
                }
            } else if (num.equals("3")) {
                int index=Integer.parseInt(comm);
                System.out.println(text.charAt(index-1));
            }

        }

    }
}
