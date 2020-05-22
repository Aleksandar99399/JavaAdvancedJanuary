package JavaAdvancedExams.December172019.christmas;

import java.util.LinkedList;
import java.util.List;


public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new LinkedList<>();
    }

    public Present getPresent(String name) {
        for (Present datum : data) {
            if (datum.getName().equals(name)) {
                return datum;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder words = new StringBuilder(String.format("%s bag contains:\r\n", getColor()));

        for (Present datum : data) {

            words.append(datum.toString()).append("\r\n");
        }

        return words.toString();

    }

    public Present heaviestPresent() {
        Present min = null;
        for (Present datum : data) {
            if (datum.getWeight() > Double.MIN_VALUE) {
                min = datum;
            }
        }
        return min;
    }

    public void add(Present present) {
        if (data.size() < getCapacity()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(data.get(i));
                return true;
            }
        }
        return false;

    }

    public int count() {
        return this.data.size();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }
}
