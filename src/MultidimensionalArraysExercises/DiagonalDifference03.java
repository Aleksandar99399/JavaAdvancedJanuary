package MultidimensionalArraysExercises;

import java.util.Scanner;

import static java.lang.System.in;

public class DiagonalDifference03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        int primarySum = getPrimaryDiagonal(matrix, n);
        int secondarySum = getSecondary(matrix, n);
        int finalSum=Math.abs(primarySum-secondarySum);
        System.out.println(finalSum);

    }

    private static int getPrimaryDiagonal(int[][] matrix, int n) {
        int sum = 0;
        int r = 0;
        int c = 0;
        while (r < n && c < n) {
            sum += matrix[r][c];
            r++;
            c++;
        }
        return sum;
    }

    private static int getSecondary(int[][] matrix, int n) {
        int sum = 0;
        int r = 0;
        int c = matrix[0].length-1;

       while (r<n&&c>=0){
           sum+=matrix[r][c];
           c--;
           r++;
       }
        return sum;
    }
}
