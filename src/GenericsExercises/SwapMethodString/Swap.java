package GenericsExercises.SwapMethodString;

import java.util.List;

public class Swap<T> {
    private T field;

    public Swap(T field) {
        this.field= field;
    }

    public static  <T> List<T> getSwap(List<T>list,int first,int second){
        T f = list.get(first);
        T s = list.get(second);
        list.set(first,s);
        list.set(second,f);

        return list;
    }

    @Override
    public String toString() {
        return this.field.getClass().getName() +": "+this.field;
    }

}

