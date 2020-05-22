package JavaAdvancedExams.Octomber262019.rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<JavaAdvancedExams.Octomber262019.rabbits.Rabbit> data;


    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(JavaAdvancedExams.Octomber262019.rabbits.Rabbit rabbit) {
        if (this.data.size() < getCapacity()) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().contains(name)) {
                data.remove(data.get(i));
                return true;
            }
        }
        return false;

    }

    public void removeSpecies(String species) {
        for (int i = 0; i < this.data.size() ; i++) {
            if (data.get(i).getSpecies().equals(species)) {
                data.remove(data.get(i));
            }
        }
    }

    public JavaAdvancedExams.Octomber262019.rabbits.Rabbit sellRabbit(String name) {
        for (int i = 0; i < data.size() ; i++) {
            if (data.get(i).getName().equals(name)) {
                data.get(i).setAvailable(false);
                return data.get(i);
            }
        }

        return null;
    }

    public List<JavaAdvancedExams.Octomber262019.rabbits.Rabbit> sellRabbitBySpecies(String species) {
        ArrayList<JavaAdvancedExams.Octomber262019.rabbits.Rabbit> list = new ArrayList<>();
        for (int i = 0; i < data.size() ; i++) {
            if (data.get(i).getSpecies().equals(species)) {
                data.get(i).setAvailable(false);
                list.add(data.get(i));
            }
        }
        return list;
    }

    public int count() {
        return data.size();

    }

    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:\r\n", getName()));
        List<JavaAdvancedExams.Octomber262019.rabbits.Rabbit> sad = data.stream().filter(JavaAdvancedExams.Octomber262019.rabbits.Rabbit::isAvailable).collect(Collectors.toList());
        for (JavaAdvancedExams.Octomber262019.rabbits.Rabbit rabbit : sad) {
            sb.append(String.format("%s\r\n", rabbit.toString()));
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

}
