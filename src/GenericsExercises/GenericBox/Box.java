package GenericsExercises.GenericBox;


public class Box<T> {
    private T field;

    public Box(T field) {
        this.field= field;
    }


    @Override
    public String toString() {
        return this.field.getClass().getName() +": "+this.field;
    }

}
