package com.Java_Programming.coreJava.java8Streams.map;

import com.Java_Programming.coreJava.java8Streams.practiceProblem_03_09_2023.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FirstTwoUniqueNameInUpperCase {
    /**
     * @Question : Get first two unique names and convert to uppercase
     * @param args
     */
    public static void main(String[] args) {
        Book b1 = new Book("Poor Dad Rich Dad", "220", new Author("xyz", 47, "Female"));
        Book b2 = new Book("Poor Dad Rich Dad", "220", new Author("xyz", 54, "Male"));
        Book b3 = new Book("Poor Dad Rich Dad", "220", new Author("xyz", 22, "Male"));
        Book b4 = new Book("Poor Dad Rich Dad", "220", new Author("Jons", 50, "Male"));
        Book b5 = new Book("Poor Dad Rich Dad", "220", new Author("xyz", 28, "Male"));

        List<String> names = getNameInUpperCase (Arrays.asList(b1, b2, b3, b4, b5));
        names.stream().forEach(System.out::println);
    }

    private static List<String> getNameInUpperCase(List<Book> bookList) {
        return bookList.stream()
                .map(Book::getAuthor)
                .filter(Objects::nonNull)
                .map(author -> author.getName().toUpperCase())
                .distinct()
                .limit(2)
                .toList();
    }
}
