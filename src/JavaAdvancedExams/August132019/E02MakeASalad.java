package JavaAdvancedExams.August132019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E02MakeASalad {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        map.put("tomato", 80);
        map.put("carrot", 136);
        map.put("lettuce", 109);
        map.put("potato", 215);

        ArrayDeque<String> veg = new ArrayDeque<>();
        ArrayDeque<Integer> cal = new ArrayDeque<>();

        Arrays.stream(rd.readLine().split(" ")).forEach(veg::offer);
        Arrays.stream(rd.readLine().split(" ")).map(Integer::parseInt).forEach(cal::push);

        while (!veg.isEmpty() && !cal.isEmpty()) {

            int calNeeded = cal.peek();

            while (calNeeded > 0 && !veg.isEmpty()) {
                int remove;

                try {
                    remove =  map.get(veg.poll());
                } catch (Exception e) {
                    remove = 0;
                }

                calNeeded -= remove;
            }

            System.out.print(cal.pop() + " ");
        }

        System.out.println();

        if (!veg.isEmpty())
            veg.forEach(s -> System.out.print(s + " "));

        if (!cal.isEmpty())
            cal.forEach(s -> System.out.print(s + " "));
    }
}