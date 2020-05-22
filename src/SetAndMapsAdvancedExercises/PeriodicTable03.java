package SetAndMapsAdvancedExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.in;

public class PeriodicTable03 {
    public static void main(String[] args)throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        Set<String>chemicalElements=new TreeSet<>();

        int n=Integer.parseInt(rd.readLine());

        for (int i = 0; i < n; i++) {
            String[] elements=rd.readLine().split("\\s+");
            chemicalElements.addAll(Arrays.asList(elements));
        }
        for (String s : chemicalElements) {
            System.out.print(s+ " ");
        }

    }
}
