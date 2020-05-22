package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class MatrixShuffling05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split(" ");

        }

        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("END")) {
            if (input[0].equals("swap") && input.length == 5) {
                int oneRow = Integer.parseInt(input[1]);
                int oneCol = Integer.parseInt(input[2]);
                int twoRow = Integer.parseInt(input[3]);
                int twoCol = Integer.parseInt(input[4]);
                if (rows >= oneRow && rows >= twoRow && cols >= oneCol && cols >= twoCol) {
                    String one = matrix[oneRow][oneCol];
                    String two = matrix[twoRow][twoCol];
                    matrix[twoRow][twoCol]=one;
                    matrix[oneRow][oneCol]=two;
                    printMatrix(matrix, rows, cols);
                }else {
                    System.out.println("Invalid input!");
                }
            }else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
