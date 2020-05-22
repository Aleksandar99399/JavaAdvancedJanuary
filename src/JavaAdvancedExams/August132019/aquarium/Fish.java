package JavaAdvancedExams.August132019.aquarium;

public class Fish {
    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    @Override
    public String toString() {
        return String.format("Fish: %s", this.getName()) + System.lineSeparator() +
                String.format("Color: %s", this.getColor()) + System.lineSeparator() +
                String.format("Number of fins: %d", this.getFins()) + System.lineSeparator().trim();
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getFins() {
        return fins;
    }
}
