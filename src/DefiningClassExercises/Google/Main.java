package DefiningClassExercises.Google;

import java.util.*;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        String[]input=scanner.nextLine().split("\\s+");
        Map<String,Person>map=new LinkedHashMap<>();


        Person person=new Person();
        while (!"End".equals(input[0])){
            map.putIfAbsent(input[0],new Person());

            if (input[1].equals("company")){

                Company company=new Company(input[2],input[3],Double.parseDouble(input[4]));
                map.get(input[0]).setCompany(company);

            }else if (input[1].equals("pokemon")){

                Pokemon pokemon=new Pokemon(input[2],input[3]);
                map.get(input[0]).getPokemonList().add(pokemon);

            }else if (input[1].equals("parents")){

                map.get(input[0]).getParents().add(new Parents(input[2],input[3]));

            }else if (input[1].equals("children")){

                map.get(input[0]).getChildren().add(new Children(input[2],input[3]));
            }else if (input[1].equals("car")){

                map.get(input[0]).setCar(new Car(input[2],input[3]));

            }

            input=scanner.nextLine().split("\\s+");
        }

        String name=scanner.nextLine();

        if (map.containsKey(name)){
            System.out.println(name);
            Person person1 = map.get(name);
            System.out.println("Company: ");
            if (person1.getCompany()!=null){
                System.out.println(person1.getCompany().toString());
            }

            System.out.println("Car: ");
            if (person1.getCar()!=null) {
                System.out.println(person1.getCar().toString());
            }

            System.out.println("Pokemon: ");
            if (!person1.getPokemonList().isEmpty()) {
                for (Pokemon pokemon : person1.getPokemonList()) {
                    System.out.println(pokemon.toString());
                }
            }

            System.out.println("Parents: ");
            if (!person1.getParents().isEmpty()) {
                for (Parents parent : person1.getParents()) {
                    System.out.println(parent.toString());
                }
            }

            System.out.println("Children: ");
            if (!person1.getChildren().isEmpty()) {
                for (Children child : map.get(name).getChildren()) {
                    System.out.println(child);
                }
            }


        }

    }
}