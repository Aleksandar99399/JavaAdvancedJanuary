package IteratorsAndComparatorsLab.ComaprableBook;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book book1= new Book("Foo",1937,"Mark");
        Book book2= new Book("Bar",1054,"Minou");

        Book boo2=new Book("Foo",1542,"Mark");
        Book asda=new Book("Bar",1523,"Minou");

        List<Book> books=new ArrayList<>();
        books.add(boo2);
        books.add(asda);
        books.add(book2);

        books.sort(new BookComparator() );
        for (Book book : books) {
            System.out.println(book.getTitle()+book.getYear());
        }
    }
}
