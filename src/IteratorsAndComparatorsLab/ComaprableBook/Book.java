package IteratorsAndComparatorsLab.ComaprableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private  String title;
    private int year;
    private List<String>authors=new ArrayList<>();


    @Override
    public int compareTo(Book other) {
        int titlesEquality=this.title.compareTo(other.getTitle());
         if (titlesEquality!=0){
             return titlesEquality;
         }

         return Integer.compare(this.year,other.year);

    }

    @Override
    public String toString() {
        return String.format("title: %s, year %d",this.title,this.year);
    }

    public Book(String title, int year, String... authors){
        this.title=title;
        this.year=year;
        this.setAuthors(authors);

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        this.authors.addAll(Arrays.asList(authors));
    }
}
