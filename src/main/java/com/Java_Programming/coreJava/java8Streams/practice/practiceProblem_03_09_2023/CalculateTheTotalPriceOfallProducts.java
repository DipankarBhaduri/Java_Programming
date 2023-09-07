package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_03_09_2023;

import com.Java_Programming.coreJava.java8Streams.practice.reduce.Product;

import java.util.Arrays;
import java.util.List;

public class CalculateTheTotalPriceOfallProducts {
    /**
     * @Question Calculate the total price of all products in a list of Product objects.
     * @param args
     */
    public static void main(String[] args) {
        Product p1 = new Product(1,"Nokia", 4000);
        Product p2 = new Product(2,"Redmi", 3000);
        Product p3 = new Product(3,"Apple", 2000);
        Product p5 = new Product(3,"Google", 2000);
        Product p4 = new Product(4,"Samsung", 1000);

        int totalPrice = calculateTotalPriceOfProducts(Arrays.asList(p1, p2, p3, p4, p5));
        System.out.println(totalPrice);
    }

    private static int calculateTotalPriceOfProducts(List<Product> productList) {
        return productList.stream().map(Product::getPrice).reduce(0, Integer::sum);
    }
}
