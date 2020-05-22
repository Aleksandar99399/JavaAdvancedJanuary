package JavaAdvancedExams.Fubruary222020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class ReVolt {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        int rowsAndCols=Integer.parseInt(rd.readLine());

        int countCommands=Integer.parseInt(rd.readLine());

        String[][]matrix=new String[rowsAndCols][];


        for (int i = 0; i < matrix.length; i++) {
            matrix[i]=rd.readLine().split("");

        }
        int [] player=getPlayer(matrix);

        boolean win=false;
        for (int i = 0; i <countCommands ; i++) {
            String comm=rd.readLine();
            int row=player[0];
            int col=player[1];

            if (comm.equals("up")){
                matrix[row][col]="-";
                row=row-1;

                if (boundIndexes(matrix,row,col)){
                    if (matrix[row][col].equals("B")){
                        player[0]=row-1;
                        if (!boundIndexes(matrix,player[0],player[1])){
                            matrix[matrix.length-1][col]="f";
                            player[0]=matrix.length-1;
                        }else {
                            matrix[player[0]][col] = "f";
                        }

                    }else if (matrix[row][col].equals("T")){
                        player[0]=row+1;
                        matrix[player[0]][col]="f";

                    }else if (matrix[row][col].equals("-")){
                        player[0]=row;
                        matrix[row][col]="f";

                    }else if (matrix[row][col].equals("F")){
                        matrix[row][col]="f";
                        win=true;
                        break;
                    }
                }else {
                    if (matrix[matrix.length-1][col].equals("F")){
                        matrix[matrix.length-1][col]="f";
                        player[0]=matrix.length-1;
                        win=true;
                        break;
                    }else if (matrix[matrix.length-1][col].equals("T")){
                        matrix[0][col]="f";
                    }else {

                        matrix[matrix.length-1][col]="f";
                        player[0]=matrix.length-1;
                    }


                }

            }else if (comm.equals("down")){
                matrix[row][col]="-";
                row=row+1;
                if (boundIndexes(matrix,row,col)){
                    if (matrix[row][col].equals("B")){
                        player[0]=row+1;
                        if (!boundIndexes(matrix,player[0],player[1])){
                            matrix[0][col]="f";
                            player[0]=0;
                        }else {
                            matrix[player[0]][col] = "f";
                        }

                    }else if (matrix[row][col].equals("T")){
                        player[0]=row-1;
                        matrix[player[0]][col]="f";

                    }else if (matrix[row][col].equals("-")){
                        player[0]=row;
                        matrix[row][col]="f";

                    }else if (matrix[row][col].equals("F")){
                        matrix[row][col]="f";
                        win=true;
                        break;
                    }
                }else {
                    if (matrix[0][col] .equals( "F")){
                        matrix[0][col]="f";
                        player[0]=0;
                        win=true;
                        break;
                    }else if (matrix[0][col] .equals( "T")){
                        matrix[matrix.length-1][col]="f";
                    }else {
                        matrix[0][col]="f";
                        player[0]=0;

                    }


                }

            }else if (comm.equals("right")){
                matrix[row][col]="-";
                col=col+1;

                if (boundIndexes(matrix,row,col)){
                    if (matrix[row][col].equals("B")){
                        player[1]=col+1;
                        if (!boundIndexes(matrix,player[0],player[1])){
                            matrix[row][0] = "f";
                            player[1] = 0;
                        }else {
                            matrix[row][player[1]] = "f";
                        }
                    }else if (matrix[row][col].equals("T")){
                        player[1]=col-1;
                        matrix[row][player[1]]="f";

                    }else if (matrix[row][col].equals("-")){
                        player[1]=col;
                        matrix[row][col]="f";
                    }else if (matrix[row][col].equals("F")){
                        matrix[row][col]="f";
                        win=true;
                        break;
                    }
                }else {
                    if (matrix[row][0].equals("F")) {
                        matrix[row][0] = "f";
                        player[1] = 0;
                        win=true;
                        break;
                    }else if (matrix[row][0].equals("T")){
                        matrix[row][matrix.length-1]="f";
                    }else {
                        matrix[row][0] = "f";
                        player[1] = 0;

                    }
                }

            }else if (comm.equals("left")){
                matrix[row][col]="-";
                col=col-1;

                if (boundIndexes(matrix,row,col)){
                    if (matrix[row][col].equals("B")){
                        player[1]=col-1;
                        if (!boundIndexes(matrix,player[0],player[1])){
                            matrix[row][matrix.length-1]="f";
                            player[1]=matrix.length-1;
                        }else {
                            matrix[row][player[1]]="f";

                        }
                    }else if (matrix[row][col].equals("T")){
                        player[1]=col+1;
                        matrix[row][player[1]]="f";

                    }else if (matrix[row][col].equals("-")){
                        player[1]=col;
                        matrix[row][col]="f";
                    }else if (matrix[row][col].equals("F")){
                        matrix[row][col]="f";
                        win=true;
                        break;
                    }
                }else {
                    if (matrix[row][matrix.length-1].equals("F")) {
                        matrix[row][matrix.length - 1] = "f";
                        player[1] = matrix.length - 1;
                        win=true;
                        break;
                    }else if (matrix[row][matrix.length-1].equals("T")){
                        matrix[row][0]="f";
                    }else {
                        matrix[row][matrix.length - 1] = "f";
                        player[1] = matrix.length - 1;

                    }
                }

            }


        }

        if (win){
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    private static int[] getPlayer(String[][] matrix) {
        int [] play=new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("f")){
                    play[0]=i;
                    play[1]=j;
                }
            }
        }
        return play;

    }
    private static boolean boundIndexes(String[][] matrix, int r, int c) {
        return r >= 0 && c < matrix.length && r < matrix.length && c >= 0;
    }
}
