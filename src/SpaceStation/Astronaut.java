package SpaceStation;

public class Astronaut {
    private String name;
    private int age;
    private String country;

    public Astronaut(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("Astronaut: %s, %d (%s)n",this.name,this.age,this.country).trim();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
