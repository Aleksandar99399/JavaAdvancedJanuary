package guild;

public class Player {
    private String name;
    private String clazz;
    private String rank="Trial";
    private String description="n/a";

    public void setName(String name) {
        this.name = name;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return  String.format("Player %s: %s", this.getName(), this.getClazz()) + System.lineSeparator() +
                "Rank: " + this.getRank() + System.lineSeparator() +
                "Description: " + this.getDescription();
    }
}
