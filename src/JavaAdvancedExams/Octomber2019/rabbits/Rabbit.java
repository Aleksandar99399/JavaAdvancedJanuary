package JavaAdvancedExams.Octomber262019.rabbits;

public class Rabbit {
    private String name;
    private String species;
    private boolean available=true;


    @Override
    public String toString() {
        return String.format("Rabbit (%s): %s",this.species,this.name);
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return this.species;
    }

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}
