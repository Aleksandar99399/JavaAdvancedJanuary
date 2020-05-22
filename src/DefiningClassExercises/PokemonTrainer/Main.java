package DefiningClassExercises.PokemonTrainer;



import java.util.*;
import java.util.function.Consumer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        String[]input=scanner.nextLine().split("\\s+");

        LinkedHashMap<String,Trainer>map=new LinkedHashMap<>();


        while (!"Tournament".equals(input[0])){
            map.putIfAbsent(input[0],new Trainer());
            String name=input[0];
            Pokemon pokemons=(new Pokemon(input[2],Integer.parseInt(input[3])));
            map.get(name).getPokemonList().add(pokemons);

            input=scanner.nextLine().split("\\s+");
        }

        String word=scanner.nextLine();

        while (!"End".equals(word)){

            String finalWord = word;
            Consumer<Trainer>checkElement= trainer -> {
                if (trainer.getPokemonList().stream().anyMatch(s->s.getElement().equals(finalWord)))
                    trainer.addBadges();
                else {
                    trainer.filterPokemons();
                }
            };
            map.forEach((k,trainer)->checkElement.accept(trainer));



            word=scanner.nextLine();
        }
        map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().getBadges() - e1.getValue().getBadges())
                .forEach(trainer -> System.out.printf("%s %d %d%n", trainer.getKey(), trainer.getValue().getBadges(), trainer.getValue().getPokemonList().size()));



    }
}
