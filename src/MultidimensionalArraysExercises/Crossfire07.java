package MultidimensionalArraysExercises;

import java.util.Scanner;

public class Crossfire07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputRow = scanner.nextInt();
        int inputColumn = scanner.nextInt();
        int[][] matrix = new int[inputRow][inputColumn];
        scanner.nextLine();
        int n = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = n;
                n++;
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] data = command.split(" ");
            int row = Integer.parseInt(data[0]);
            int column = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);
            int[][] memoMatrix = new int[inputRow][inputColumn];
            int r = -1;
            for (int i = 0; i < matrix.length; i++) {
                int c = 0;
                if (i == row) {
                    boolean validRow = false;
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (j < column - radius || j > column + radius) {
                            if (!validRow) {
                                r++;
                                validRow = true;
                            }
                            memoMatrix[r][c] = matrix[i][j];

                            c++;
                        }
                    }
                } else {
                    r++;
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (j == column) {
                            if (i < row - radius || i > row + radius) {
                                memoMatrix[r][c] = matrix[i][j];

                                c++;
                            }
                        } else {
                            memoMatrix[r][c] = matrix[i][j];
                            c++;
                        }
                    }
                }

            }
            matrix = memoMatrix;

            command = scanner.nextLine();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();

        }
    }
}