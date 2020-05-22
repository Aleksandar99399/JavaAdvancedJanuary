package IteratorsAndComparatorsLab.ComaprableBook;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {


    @Override
    public int compare(Book first, Book second) {
        if (first.getAuthors().size()==second.getAuthors().size()){
            return 0;
        }else if (first.getAuthors().size()>second.getAuthors().size()){
            return 1;
        }else {
            return -1;
        }
    }
}
