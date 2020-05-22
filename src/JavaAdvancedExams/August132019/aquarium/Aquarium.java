package JavaAdvancedExams.August132019.aquarium;


import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public void add(Fish fish) {
        if (!fishInPool.contains(fish) && getFishInPool() < getCapacity()) {
            fishInPool.add(fish);
        }

    }

    public Fish findFish(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return fish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Aquarium: %s ^ Size: %d%n", this.getName(), this.getSize()));

        for (Fish fish : fishInPool) {
            sb.append(fish.toString()).append("\r\n");
        }

        return sb.toString();
    }

    public boolean remove(String name) {
        return fishInPool.removeIf(fish -> fish.getName().equals(name));
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
}
