package JavaAdvancedExams.October232019;

import java.util.*;
import java.util.stream.Collectors;

public class proba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vegetables = new ArrayDeque<>();
        ArrayDeque<String> salads = new ArrayDeque<>();

        vegetables = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        salads = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int currentSalad = 0;
        List<String> readySalads = new ArrayList<>();



        while (!salads.isEmpty() && !vegetables.isEmpty()) {

            if (currentSalad <= 0) {
                currentSalad = Integer.parseInt(salads.peekLast());
            }
            int currentCalories = getCalories(vegetables.poll());
            currentSalad -= currentCalories;

            if (currentSalad <= 0) {
                readySalads.add(salads.pollLast());
                currentSalad = 0;
            }

        }
        if (!readySalads.isEmpty()) {
            readySalads.forEach(e -> System.out.print(e + " "));
        }
        System.out.println();
        if (salads.isEmpty()) {
            vegetables.forEach(e -> System.out.print(e + " "));
        }
        if (vegetables.isEmpty()) {
            while (!salads.isEmpty()) {
                System.out.print(salads.pollLast() + " ");
            }
        }
    }

    private static int getCalories(String vegetable) {
        int value = 0;

        switch (vegetable) {
            case "tomato":
                value = 80;
                break;
            case "carrot":
                value = 136;
                break;
            case "lettuce":
                value = 109;
                break;
            case "potato":
                value = 215;
                break;
        }
        return value;

    }
}