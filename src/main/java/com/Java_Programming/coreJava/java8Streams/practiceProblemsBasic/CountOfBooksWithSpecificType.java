package com.Java_Programming.coreJava.java8Streams.practiceProblemsBasic;

import com.Java_Programming.coreJava.java8Streams.map.Author;

import java.util.Arrays;
import java.util.List;

public class CountOfBooksWithSpecificType {
    /**
     * @Question : Filtering and Counting: Given a list of Book objects with a genre field,
     *             count the number of books in the "Mystery" genre.
     * @param args
     */
    public static void main(String[] args) {
        Book b1 = new Book("Life is a game", "abc", new Author());
        Book b2 = new Book("All about money", "abc", new Author());
        Book b3 = new Book("Poor Dad rich dad", "Mr Jons", new Author());
        Book b4 = new Book("Value of Money", "abc", new Author());
        Book b5 = new Book("Health is wealth", "Dr. Kalam", new Author());
        Book b6 = new Book("Love is a Game", "def", new Author());

        int count = getBookCountByGenre (Arrays.asList(b1, b2, b3, b4, b5, b6), "abc");
        System.out.println(count);
    }

    private static int getBookCountByGenre(List<Book> bookList, String genre) {
        return (int) bookList.stream().filter(book -> book.getTotalPage().equals(genre)).count();
    }
}
