package JavaAdvancedExams.December172019.christmas;

public class Main {
    public static void main(String[] args) {

        Bag bag = new Bag("black", 2);

        Present present = new Present("Doll", 0.4, "girl");


        System.out.println(present); // Present Doll (0.40) for a girl


        bag.add(present);


        System.out.println( bag.remove("Doll")); // false

        Present secondPresent = new Present("Train", 2, "boy");
        Present daPresent = new Present("Main", 3, "girl");
        Present tird = new Present("Srasan", 6, "boy");

        bag.add(secondPresent);
        bag.add(tird);
        bag.add(daPresent);

        Present heaviestPresent = bag.heaviestPresent();
        System.out.println(heaviestPresent);




        System.out.println(bag.count()); // 2
        System.out.println(bag.report());

    }
}
