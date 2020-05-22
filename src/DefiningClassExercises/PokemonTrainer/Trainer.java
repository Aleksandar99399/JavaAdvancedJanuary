package DefiningClassExercises.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Trainer {
    private int badges=0;
    private List<Pokemon>pokemonList=new ArrayList<>();


    public List<Pokemon> getPokemonList() {
        return pokemonList=pokemonList;
    }

    public int getBadges() {
        return this.badges;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
    Predicate<Pokemon>pred= pokemon -> {
        pokemon.lowerHp();
        return pokemon.getHealth()>0;
    };

    public void filterPokemons(){
        setPokemonList(this.getPokemonList().stream().filter(pred).collect(Collectors.toList()));
    }

    public void addBadges(){
        this.badges++;
    }
}
