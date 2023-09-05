package com.Java_Programming.coreJava.java8Streams.practiceProblemsBasic;

import com.Java_Programming.coreJava.java8Streams.reduce.Product;

import java.util.Arrays;
import java.util.List;

public class CreateStringListFromObjects {
    /**
     * @Question Mapping with Objects: Given a list of Product objects, create a new list of product names.
     * @param args
     */
    public static void main(String[] args) {
        Product p1 = new Product(1,"Nokia", 4000);
        Product p2 = new Product(2,"Redmi", 3000);
        Product p3 = new Product(3,"Apple", 2000);
        Product p5 = new Product(3,"Google", 2000);
        Product p4 = new Product(4,"Samsung", 1000);

        List<String> nameList = getNamesFromProducts(Arrays.asList(p1, p2, p3, p4, p5));
        nameList.stream().forEach(System.out::println);
    }

    private static List<String> getNamesFromProducts(List<Product> productList) {
        return productList.stream().map(Product::getName).toList();
    }
}
