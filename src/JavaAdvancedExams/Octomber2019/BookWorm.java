package JavaAdvancedExams.Octomber262019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class BookWorm {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        StringBuilder initial = new StringBuilder(rd.readLine());
        int rowAndCol = Integer.parseInt(rd.readLine());

        String[][] matrix = new String[rowAndCol][rowAndCol];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = rd.readLine().split("");
        }

        String comm = rd.readLine();

        int[] indexes = findPlayer(matrix);
        while (!comm.equals("end")) {

            switch (comm) {
                case "down": {
                    indexes[0] = indexes[0] + 1;
                    boolean exist = boundIndexes(matrix, indexes[0], indexes[1]);
                    if (exist) {
                        matrix[indexes[0] - 1][indexes[1]] = "-";

                        if (!matrix[indexes[0]][indexes[1]].equals("-")) {
                            initial.append(matrix[indexes[0]][indexes[1]]);
                        }
                        matrix[indexes[0]][indexes[1]] = "P";
                    } else {
                        indexes[0] = indexes[0] - 1;
                        initial.deleteCharAt(initial.length() - 1);
                    }
                    break;
                }
                case "right": {
                    indexes[1] = indexes[1] + 1;
                    boolean exist = boundIndexes(matrix, indexes[0], indexes[1]);
                    if (exist) {
                        matrix[indexes[0]][indexes[1] - 1] = "-";
                        if (!matrix[indexes[0]][indexes[1]].equals("-")) {
                            initial.append(matrix[indexes[0]][indexes[1]]);
                        }
                        matrix[indexes[0]][indexes[1]] = "P";
                    } else {
                        indexes[1] = indexes[1] - 1;
                        initial.deleteCharAt(initial.length() - 1);
                    }

                    break;
                }
                case "left": {
                    indexes[1] = indexes[1] - 1;
                    boolean exist = boundIndexes(matrix, indexes[0], indexes[1]);
                    if (exist) {
                        matrix[indexes[0]][indexes[1] + 1] = "-";
                        if (!matrix[indexes[0]][indexes[1]].equals("-")) {
                            initial.append(matrix[indexes[0]][indexes[1]]);
                        }
                        matrix[indexes[0]][indexes[1]] = "P";
                    } else {
                        indexes[1] = indexes[1] + 1;
                        initial.deleteCharAt(initial.length() - 1);
                    }
                    break;
                }
                case "up": {
                    indexes[0] = indexes[0] - 1;
                    boolean exist = boundIndexes(matrix, indexes[0], indexes[1]);
                    if (exist) {
                        matrix[indexes[0] + 1][indexes[1]] = "-";
                        if (!matrix[indexes[0]][indexes[1]].equals("-")) {
                            initial.append(matrix[indexes[0]][indexes[1]]);

                        }
                        matrix[indexes[0]][indexes[1]] = "P";
                    } else {
                        indexes[0] = indexes[0] + 1;
                        initial.deleteCharAt(initial.length() - 1);
                    }
                    break;
                }
            }
            comm = rd.readLine();
        }
        System.out.println(initial);
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

    }

    private static boolean boundIndexes(String[][] matrix, int r, int c) {
        return r >= 0 && c < matrix.length && r < matrix.length && c >= 0;
    }

    private static int[] findPlayer(String[][] matrix) {
        int[] indexes = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("P")) {
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }
        return indexes;
    }
}
