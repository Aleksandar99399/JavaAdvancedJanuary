package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class MatrixOfPalindrome02 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        int [] input= Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e->Integer.parseInt(e))
                .toArray();

        int rows=input[0];
        int cols=input[1];
        String[][] matrix=new String[rows][cols];
        takeSymb(rows,cols,matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


    }
    private static void takeSymb (int row,int col,String[][]matrix){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char []lett=new char[3];

                for (int k = 0; k < lett.length; k++) {
                    if (k%2!=0){
                        lett[k]=(char)('a'+i+j);
                    }else {
                        lett[k]=(char)('a'+i);
                    }

                }
                matrix[i][j]=String.valueOf(lett);
            }
        }

    }
}
