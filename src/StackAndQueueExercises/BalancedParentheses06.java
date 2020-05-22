package StackAndQueueExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.System.in;

public class BalancedParentheses06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String[] braces = scanner.nextLine().split("");

        int avg = braces.length / 2;

        ArrayDeque<String> open = new ArrayDeque<>();
        ArrayDeque<String> close = new ArrayDeque<>();
        for (int i = 0; i < avg; i++) {
            open.add(braces[i]);

        }
        for (int r = braces.length - 1; r >= avg; r--) {
            close.push(braces[r]);
        }

        boolean balanceOne = true;

        for (int i = 0; i < avg; i++) {
            if (open.contains("(") && close.contains(")")||
                    open.contains("[") && close.contains("]")||
                    open.contains("{") && close.contains("}")) {
                balanceOne = true;

            } else {
                balanceOne = false;
                break;

            }

            open.removeLast();
            close.removeFirst();
        }

        if (balanceOne ) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
