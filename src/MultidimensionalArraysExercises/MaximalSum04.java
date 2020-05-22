package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class MaximalSum04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }

        int r=0;
        int c=0;

        int maxSum=Integer.MIN_VALUE;

        for (int row = 1; row <rows-1 ; row++) {
            for (int col = 1; col < cols-1; col++) {
                int sum=sumOfMatrix(matrix,row,col);
                if (sum>maxSum){
                    maxSum=sum;
                    r=row;
                    c=col;
                }
            }

        }
        System.out.println("Sum = "+maxSum);
        printSubMatrix(matrix,r,c);




    }

    private static void printSubMatrix(int[][] matrix, int r, int c) {
        for (int row = r-1; row <= r+1; row++) {
            for (int col = c-1; col <= c+1 ; col++) {
                System.out.print(matrix[row][col]+ " ");
            }
            System.out.println();
        }

    }

    private static int sumOfMatrix(int[][] matrix,int r,int c) {
        int sum = 0;
        int rowCurr = r;
        int colCurr = c;
        //curr
        sum += matrix[rowCurr][colCurr];
        //L
        sum += matrix[rowCurr][colCurr - 1];
        //R
        sum += matrix[rowCurr][colCurr + 1];
        //U
        sum += matrix[rowCurr - 1][colCurr];
        //D
        sum += matrix[rowCurr + 1][colCurr];
        //LU
        sum += matrix[rowCurr - 1][colCurr - 1];
        //LD
        sum += matrix[rowCurr + 1][colCurr - 1];
        //RU
        sum += matrix[rowCurr - 1][colCurr + 1];
        //RD
        sum += matrix[rowCurr + 1][colCurr + 1];
        return sum;
    }
}
