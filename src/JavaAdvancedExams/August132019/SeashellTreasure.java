package JavaAdvancedExams.August132019;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


import static java.lang.System.in;

public class SeashellTreasure {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        int n=Integer.parseInt(rd.readLine());

        String[][]matrix=new String[n][];
        for (int i = 0; i <matrix.length; i++) {
            matrix[i]= rd.readLine().split("\\s+");
        }

        String[] comm=rd.readLine().split("\\s+");
        List<String>seashell=new LinkedList<>();

        int count=0;
        int stolen=0;

        while (!comm[0].equals("Sunset")){

            int row=Integer.parseInt(comm[1]);
            int col=Integer.parseInt(comm[2]);

            if (comm[0].equals("Collect")){
                if (boundIndexes(matrix,row,col,n)){
                    seashell.add(matrix[row][col]);
                    matrix[row][col]="-";
                    count++;
                }
            }else if (comm[0].equals("Steal")){
                if (boundIndexes(matrix,row,col,n)) {
                   stolen+= waySteal(matrix,row,col,comm[3]);
                }
            }
            comm=rd.readLine().split("\\s+");
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        if (count>0){
            System.out.println("Collected seashells: "+count+" -> "+String.join(", ",seashell));
        }else {
            System.out.println("Collected seashells: "+count);

        }
        System.out.println("Stolen seashells: "+ stolen);
    }

    private static int waySteal(String[][] matrix, int row, int col, String s) {
        int n=0;
        int stolen=0;
        if (s.equals("up")){
            while (n++<=3&&row>=0){
                if (!matrix[row][col].equals("-")){
                    stolen++;
                }
                matrix[row][col]="-";
                row--;
            }
            n=0;
        }else if (s.equals("down")){
            while (n++<=3&&row<matrix.length){
                if (!matrix[row][col].equals("-")){
                    stolen++;
                }
                matrix[row][col]="-";
                row++;
            }
            n=0;
        }else if (s.equals("left")){
            while (n++<=3&&col>=0){
                if (!matrix[row][col].equals("-")){
                    stolen++;
                }
                matrix[row][col]="-";
                col--;
            }
            n=0;
        }else if (s.equals("right")){
            while (n++<=3&&col<matrix[row].length){
                if (!matrix[row][col].equals("-")){
                    stolen++;
                }
                matrix[row][col]="-";
                col++;
            }
            n=0;
        }
        return stolen;
    }

    private static boolean boundIndexes(String[][] matrix, int r, int c,int n) {
        return r >= 0 && c>=0 &&r<n && c <matrix[r].length;
    }

}
