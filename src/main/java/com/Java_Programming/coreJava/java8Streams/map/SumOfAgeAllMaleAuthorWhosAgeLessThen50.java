package com.Java_Programming.coreJava.java8Streams.map;

import com.Java_Programming.coreJava.java8Streams.practiceProblemsBasic.Book;
import java.util.Arrays;
import java.util.List;

public class SumOfAgeAllMaleAuthorWhosAgeLessThen50 {
    /**
     * @Question : Find out the sum of all male authors age
     * @param args
     */
    public static void main(String[] args) {
        Book b1 = new Book("Poor Dad Rich Dad", "220", new Author("xyz", 47, "Female"));
        Book b2 = new Book("Poor Dad Rich Dad", "220", new Author("Jons", 54, "Male"));
        Book b3 = new Book("Poor Dad Rich Dad", "220", new Author("xyz", 22, "Male"));
        Book b4 = new Book("Poor Dad Rich Dad", "220", new Author("Jons", 50, "Male"));
        Book b5 = new Book("Poor Dad Rich Dad", "220", new Author("xyz", 28, "Male"));

        int sumOfAge = getAgesSumBasedOnTheCondition (Arrays.asList(b1, b2, b3, b4, b5));
        System.out.println(sumOfAge);
    }

    private static int getAgesSumBasedOnTheCondition(List<Book> bookList) {
        return bookList.stream()
                .map(Book::getAuthor)
                .filter(author -> author.getAge() < 50)
                .filter(author -> author.getGender().equals("Male"))
                .map(Author::getAge)
                .reduce(Integer::sum).get();
    }
}
