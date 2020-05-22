package IteratorsAndComparatorsLab;

public class Main {
    public static void main(String[] args) {

        printStrings("ojd");
        printStrings("sadas",": 'ldas","wdaodfv");
    }

    public static void printStrings(String mandatory,String... text){
        System.out.println(mandatory);
        for (String aString:text) {
            System.out.println(aString);

        }
    }
}
