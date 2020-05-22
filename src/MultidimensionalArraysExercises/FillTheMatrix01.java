package MultidimensionalArraysExercises;

import java.util.Scanner;

import static java.lang.System.in;

public class FillTheMatrix01 {
    public static void main(String[] args){

        Scanner scanner=new Scanner(in);

        String[]strings=scanner.nextLine().split(", ");
        String patt=strings[1];
        int rowsAndCols=Integer.parseInt(strings[0]);
        int [][] matrix=new int[rowsAndCols][rowsAndCols];
        if (patt.equals("A")){
            matrix=getPatternA(rowsAndCols);
            printMatrix(matrix);
        }else {
            matrix=getPatternB(rowsAndCols);
            printMatrix(matrix);
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();

        }
    }

    private static int [][] getPatternA(int rowsAndCols){
        int [][]matrix=new int[rowsAndCols][rowsAndCols];

        int value=1;
        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < rowsAndCols; j++) {
                matrix[j][i]=value++;
            }
        }
        return matrix;
    }
    private static int [][] getPatternB(int rowsAndCols){
        int [][]matrix=new int[rowsAndCols][rowsAndCols];

        int value=1;
        for (int i = 0; i < rowsAndCols; i++) {
            if (i%2==0) {
                for (int j = 0; j < rowsAndCols; j++) {
                    matrix[j][i] = value++;
                }
            }else {
                for (int j = matrix.length-1; j >=0 ; j--) {
                    matrix[j][i]=value++;
                }
            }
        }
        return matrix;
    }
}
