package GenericsExercises.CustomList;

import java.util.List;

public class MyList {
    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public MyList(int[] data, int size) {
        this.data = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(int element) {
        if (this.size == this.data.length) {
            resize();
        }
        this.data[this.size++] = element;
    }

    private void resize() {
        int[] newData = new int[this.data.length * 2];

        for (int i = 0; i < this.data.length; i++) {
            newData[i]=this.data[i];
            
        }
        this.data=newData;
    }

    public int remove(int index) {
        int element=this.data[index];
        this.size--;
        return element;

    }

    //public boolean contains(T element) {
    //    if (list.contains(element)) {
    //        return true;
    //    } else {
    //        return false;
    //    }
    //}
//
    //public void swap(int first, int second) {
    //    T num1 = list.get(first);
    //    T num2 = list.get(second);
    //    list.set(first, num2);
    //    list.set(second, num1);
//
    //}
//
    //public static <T extends Comparable<T>> T getCount(List<T> list, T element) {
//
    //    for (T t : list) {
    //        if (t.compareTo(element) < 0) {
    //            count++;
    //        }
    //    }
    //    return element;
    //}
//
    //public static <T extends Comparable<T>> T getMax(List<T> list) {
    //    T max = list.get(0);
//
    //    for (int i = 0; i < list.size(); i++) {
    //        if (max.compareTo(list.get(i)) < 0) {
    //            max = list.get(i);
    //        }
    //    }
    //    return max;
//
    //}
//
    //public static <T extends Comparable<T>> T getMin(List<T> list) {
    //    T min = list.get(0);
//
    //    for (int i = 0; i < list.size(); i++) {
    //        if (min.compareTo(list.get(i)) > 0) {
    //            min = list.get(i);
    //        }
    //    }
    //    return min;
//
    //}


}
