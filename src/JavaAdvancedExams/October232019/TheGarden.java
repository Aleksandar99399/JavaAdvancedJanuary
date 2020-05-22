package JavaAdvancedExams.October232019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class TheGarden {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        int n = Integer.parseInt(rd.readLine());

        String[][] matrix = new String[n][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = rd.readLine().split("\\s+");
        }

        String end = rd.readLine();

        int lettuce = 0;
        int potatoes = 0;
        int carrots = 0;
        int harmed = 0;

        while (!end.equals("End of Harvest")) {
            String[] comm = end.split("\\s+");
            int start = Integer.parseInt(comm[1]);
            int last = Integer.parseInt(comm[2]);


            if (comm[0].equals("Harvest")) {
                if (indexBound(matrix, start, last)) {
                    String symb = matrix[start][last];
                    if (symb.equals("L")) {
                        lettuce++;
                    } else if (symb.equals("P")) {
                        potatoes++;
                    } else if (symb.equals("C")) {
                        carrots++;
                    }
                    matrix[start][last] = " ";
                }
            } else if (comm[0].equals("Mole")) {
                if (indexBound(matrix, start, last)) {
                    harmed += moveMole(matrix, start, last, comm[3]);
                }
            }

            end = rd.readLine();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.printf("Carrots: %d%n", carrots);
        System.out.printf("Potatoes: %d%n", potatoes);
        System.out.printf("Lettuce: %d%n", lettuce);
        System.out.printf("Harmed vegetables: %d%n", harmed);
    }

    private static int moveMole(String[][] matrix, int start, int last, String way) {
        int harmed = 0;
        if (way.equals("up")) {
            for (int i = start; i >= 0; i -= 2) {
                if (!matrix[i][last].equals(" ")) {
                    harmed++;
                    matrix[i][last] = " ";
                }
            }
        } else if (way.equals("down")) {
            for (int i = start; i < matrix.length; i += 2) {
                if (!matrix[i][last].equals(" ")){

                    matrix[i][last] = " ";
                    harmed++;
                }
            }
        } else if (way.equals("left")) {
            for (int i = last; i >= 0; i -= 2) {
                if (!matrix[start][i].equals(" ")) {
                    matrix[start][i] = " ";
                    harmed++;
                }
            }
        } else if (way.equals("right")) {
            for (int i = last; i < matrix[start].length; i += 2) {
                if (!matrix[start][i].equals(" ")) {
                    harmed++;
                    matrix[start][i] = " ";
                }
            }
        }
        return harmed;
    }

    private static boolean indexBound(String[][] matrix, int r, int c) { //4  2
        if (r >= 0 && r < matrix.length && c >= 0 && c<matrix[r].length){
            return true;
        }
        return false;
    }
}
