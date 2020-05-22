package DefiningClassExercises.PokemonTrainer;

public class Pokemon {

    private String element;
    private int health;

    public Pokemon(String element, int health) {
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return this.element;
    }

    public int getHealth() {
        return this.health;
    }

    public void lowerHp() {
        this.health -= 10;
    }
}
