package GenericsExercises.GenericsCountsMethods;

import java.util.List;

public class Comparable {
    private static int count;
    public static  <T extends java.lang.Comparable<T>> T getMax(List<T> items,T word) {
        if (items.size() == 0) {
            throw new IllegalArgumentException("max on empty list");

        }

        for (int i = 0; i < items.size(); i++) {
            if (word.compareTo(items.get(i))<0) {

                count++;
            }

        }
        return word;
    }

    public static int getCount() {
        return count;
    }
}
