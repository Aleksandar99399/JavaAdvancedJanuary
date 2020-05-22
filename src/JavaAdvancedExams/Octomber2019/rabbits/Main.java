package JavaAdvancedExams.Octomber262019.rabbits;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Initialize the repository (Cage)
        JavaAdvancedExams.Octomber262019.rabbits.Cage cage = new JavaAdvancedExams.Octomber262019.rabbits.Cage("Wildness", 20);
        //Initialize entity
        JavaAdvancedExams.Octomber262019.rabbits.Rabbit rabbit = new JavaAdvancedExams.Octomber262019.rabbits.Rabbit("Fluffy", "Blanc de Hotot");
        //Print Rabbit
        System.out.println(rabbit); // Rabbit (Blanc de Hotot): Fluffy

//Add Rabbit
        cage.add(rabbit);
        System.out.println(cage.count()); //1
//Remove Rabbit
        cage.removeRabbit("Rabbit Name"); //false

        JavaAdvancedExams.Octomber262019.rabbits.Rabbit secondRabbit = new JavaAdvancedExams.Octomber262019.rabbits.Rabbit("Bunny", "Brazilian");
        JavaAdvancedExams.Octomber262019.rabbits.Rabbit thirdRabbit = new JavaAdvancedExams.Octomber262019.rabbits.Rabbit("Jumpy", "Cashmere Lop");
        JavaAdvancedExams.Octomber262019.rabbits.Rabbit fourthRabbit = new JavaAdvancedExams.Octomber262019.rabbits.Rabbit("Puffy", "Cashmere Lop");
        JavaAdvancedExams.Octomber262019.rabbits.Rabbit fifthRabbit = new JavaAdvancedExams.Octomber262019.rabbits.Rabbit("Marlin", "Brazilian");

//Add Rabbits
        cage.add(secondRabbit);
        cage.add(thirdRabbit);
        cage.add(fourthRabbit);
        cage.add(fifthRabbit);

//Sell Rabbit by name
        System.out.println(cage.sellRabbit("Bunny")); //Rabbit (Brazilian): Bunny
//Sell Rabbit by species
        List<JavaAdvancedExams.Octomber262019.rabbits.Rabbit> soldSpecies = cage.sellRabbitBySpecies(("Cashmere Lop"));

        soldSpecies.forEach(f-> {
            System.out.println(f.getName());

        });
        //Jumpy
        //Puffy

        System.out.println(cage.report());
//Rabbits available at Wildness:
//Rabbit (Blanc de Hotot): Fluffy
//Rabbit (Brazilian): Marlin

    }
}
