package JavaAdvancedExams.December172019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class    PresentDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        int countPresents = Integer.parseInt(rd.readLine());

        int rowsAndCols = Integer.parseInt(rd.readLine());

        String[][] matrix = new String[rowsAndCols][rowsAndCols];

        for (int i = 0; i < rowsAndCols; i++) {
            matrix[i] = rd.readLine().split("\\s+");
        }

        int happy = 0;

        String comm = rd.readLine();

        int[] hep = getSanta(matrix);

        while (!comm.equals("Christmas morning")) {

            if (comm.equals("up")) {
                hep[0] = hep[0] - 1;
                if (boundIndexes(matrix, hep[0], hep[1])) {
                    matrix[hep[0]+1][hep[1]] = "-";
                    if (matrix[hep[0]][hep[1]].equals("X")) {
                        matrix[hep[0]][hep[1]] = "S";
                    } else if (matrix[hep[0]][hep[1]].equals("V")) {
                        matrix[hep[0]][hep[1]] = "S";
                        happy++;
                        countPresents--;
                    } else if (matrix[hep[0]][hep[1]].equals("C")) {
                        matrix[hep[0]][hep[1]] = "S";
                        int[] count = santaHappy(matrix, hep[0], hep[1], countPresents);
                        countPresents -= count[0];
                        happy += count[1];

                    }else {
                        matrix[hep[0]][hep[1]] = "S";
                    }
                    if (countPresents <= 0) {
                        break;
                    }

                }else {
                    hep[0]=hep[0]+1;
                }


            } else if (comm.equals("left")) {
                hep[1] = hep[1] - 1;
                if (boundIndexes(matrix, hep[0], hep[1])) {
                    matrix[hep[0]][hep[1]+1] = "-";
                    if (matrix[hep[0]][hep[1]].equals("X")) {
                        matrix[hep[0]][hep[1]] = "S";
                    } else if (matrix[hep[0]][hep[1]].equals("V")) {
                        matrix[hep[0]][hep[1]] = "S";
                        countPresents--;
                        happy++;
                    } else if (matrix[hep[0]][hep[1]].equals("C")) {
                        matrix[hep[0]][hep[1]] = "S";
                        int[] count = santaHappy(matrix, hep[0], hep[1], countPresents);
                        countPresents -= count[0];
                        happy += count[1];
                    } else {
                        matrix[hep[0]][hep[1]] = "S";
                    }
                    if (countPresents == 0) {
                        break;
                    }


                }else {
                    hep[1]=hep[1]+1;
                }
            } else if (comm.equals("right")) {
                hep[1] = hep[1] + 1;
                if (boundIndexes(matrix, hep[0], hep[1])) {
                    matrix[hep[0]][hep[1]-1] = "-";
                    if (matrix[hep[0]][hep[1]].equals("X")) {
                        matrix[hep[0]][hep[1]] = "S";
                    } else if (matrix[hep[0]][hep[1]].equals("V")) {
                        matrix[hep[0]][hep[1]] = "S";
                        countPresents--;
                        happy++;
                    } else if (matrix[hep[0]][hep[1]].equals("C")) {
                        matrix[hep[0]][hep[1]] = "S";
                        int[] count = santaHappy(matrix, hep[0], hep[1], countPresents);
                        countPresents -= count[0];
                        happy += count[1];
                    } else {
                        matrix[hep[0]][hep[1]] = "S";
                    }
                    if (countPresents == 0) {
                        break;
                    }


                }else {
                    hep[1]=hep[1]-1;
                }
            } else if (comm.equals("down")) {
                hep[0] = hep[0] + 1;
                if (boundIndexes(matrix, hep[0], hep[1])) {
                    matrix[hep[0]-1][hep[1]] = "-";
                    if (matrix[hep[0]][hep[1]].equals("X")) {
                        matrix[hep[0]][hep[1]] = "S";
                    } else if (matrix[hep[0]][hep[1]].equals("V")) {
                        matrix[hep[0]][hep[1]] = "S";
                        countPresents--;
                        happy++;
                    } else if (matrix[hep[0]][hep[1]].equals("C")) {
                        matrix[hep[0]][hep[1]] = "S";
                        int[] count = santaHappy(matrix, hep[0], hep[1],countPresents);
                        countPresents -= count[0];
                        happy += count[1];
                    } else {
                        matrix[hep[0]][hep[1]] = "S";
                    }
                    if (countPresents == 0) {
                        break;
                    }

                }else {
                    hep[0]=hep[0]-1;
                }
            }
            if (countPresents == 0) {
                break;
            }

            comm = rd.readLine();
        }
        if (countPresents == 0) {
            System.out.println("Santa ran out of presents!");
        }
        int sad = printMatrix(matrix);
        if (sad > 0) {
            System.out.printf("No presents for %d nice kid/s.", sad);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", happy);
        }

    }

    private static int printMatrix(String[][] matrix) {
        int sad = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("V")) {
                    sad++;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return sad;
    }

    private static boolean boundIndexes(String[][] matrix, int r, int c) {
        return r >= 0 && c < matrix.length && r < matrix.length && c >= 0;
    }

    private static int[] santaHappy(String[][] matrix, int ind, int mind, int countPresents) {
        int[] presAndHappy = new int[2];

            if (ind + 1 < matrix.length && matrix[ind + 1][mind].equals("V") || matrix[ind + 1][mind].equals("X")) {
                if (matrix[ind + 1][mind].equals("V")) {
                    presAndHappy[1]++;
                }
                presAndHappy[0]++;
                matrix[ind + 1][mind] = "-";
            }
            if (ind - 1 >= 0 && matrix[ind - 1][mind].equals("V") || matrix[ind - 1][mind].equals("X")) {
                if (matrix[ind - 1][mind].equals("V")) {
                    presAndHappy[1]++;
                }
                presAndHappy[0]++;
                matrix[ind - 1][mind] = "-";
            }
            if (mind + 1 < matrix.length && matrix[ind][mind + 1].equals("V") || matrix[ind][mind + 1].equals("X")) {
                if (matrix[ind][mind + 1].equals("V")) {
                    presAndHappy[1]++;
                }
                presAndHappy[0]++;
                matrix[ind][mind + 1] = "-";
            }
            if (mind - 1 >= 0 && matrix[ind][mind - 1].equals("V") || matrix[ind][mind - 1].equals("X")) {
                if (matrix[ind][mind - 1].equals("V")) {
                    presAndHappy[1]++;
                }
                presAndHappy[0]++;
                matrix[ind][mind - 1] = "-";
            }


        return presAndHappy;
    }

    private static int[] getSanta(String[][] matrix) {
        int[] arr = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("S")) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}
