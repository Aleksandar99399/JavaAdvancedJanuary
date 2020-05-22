package MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



import static java.lang.System.in;

public class ReverseMatrixDiagonals11 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd=new BufferedReader(new InputStreamReader(in));


            int[] info = Arrays.stream(rd.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = info[0];
            int cols = info[1];
            int[][] mat = new int[row][cols];

            for (int i = 0; i < row; i++) {
                mat[i] = Arrays.stream(rd.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int col = cols - 1;
            row--;

            while (row >= 0) {
                int r = row;
                int c = col;

                while (c < cols && r >= 0)
                    System.out.print(mat[r--][c++] + " ");

                System.out.println();

                if (--col == -1) {
                    col = 0;
                    row--;
                }
            }
        }

}



