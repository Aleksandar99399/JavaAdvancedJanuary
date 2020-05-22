package DefiningClassExercises.OppinionPoll01;


import java.util.*;
import java.util.function.Consumer;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(in);

        int n=Integer.parseInt(scanner.nextLine());

        Set<Person> set=new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[]input=scanner.nextLine().split("\\s+");
            Person person=new Person(input[0],Integer.parseInt(input[1]));

            set.add(person);

        }
        Consumer<Person>consumer=e-> System.out.println(e.getName()+" - "+e.getAge());
        set.stream().sorted(Comparator.comparing(Person::getName)).filter(e->e.getAge()>30).forEach(consumer);

    }
}
