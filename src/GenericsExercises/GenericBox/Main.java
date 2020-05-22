package GenericsExercises.GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(rd.readLine());


        while (n-- > 0) {
            int text = Integer.parseInt(rd.readLine());
            Box<Integer> box = new Box<>(text);
            System.out.println(box.toString());
        }

    }
}
