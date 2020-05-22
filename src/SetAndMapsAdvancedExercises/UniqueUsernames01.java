package SetAndMapsAdvancedExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.lang.System.in;

public class UniqueUsernames01 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(in));

        int n=Integer.parseInt(rd.readLine());

        Set<String>unique=new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String username=rd.readLine();
            unique.add(username);

        }
        for (String s : unique) {
            System.out.println(s);
        }

    }
}
