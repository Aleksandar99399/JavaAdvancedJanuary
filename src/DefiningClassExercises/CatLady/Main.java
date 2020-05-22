package DefiningClassExercises.CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Cat> map = new HashMap<>();
        String[] in;

        while (!Arrays.equals(in = rd.readLine().split(" "), new String[]{"End"})) map.put(in[1], new Cat(in[0], Double.parseDouble(in[2])));

        String cat = rd.readLine();
        if (map.containsKey(cat)) System.out.printf("%s %s %.2f", map.get(cat).getType(), cat, map.get(cat).getNum());

    }
}
