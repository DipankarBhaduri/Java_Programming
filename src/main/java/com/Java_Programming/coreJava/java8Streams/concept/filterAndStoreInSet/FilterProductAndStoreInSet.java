package com.Java_Programming.coreJava.java8Streams.concept.filterAndStoreInSet;

import com.Java_Programming.coreJava.java8Streams.concept.reduce.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterProductAndStoreInSet {
    public static void main(String[] args) {
        Product p1 = new Product(1,"Nokia", 4000);
        Product p2 = new Product(2,"Redmi", 3000);
        Product p3 = new Product(3,"Apple", 2000);
        Product p5 = new Product(3,"Apple2", 2000);
        Product p4 = new Product(4,"Samsung", 1000);

        Set<Integer> prices = getAllPriceFromProduct(Arrays.asList(p1, p2, p3, p4, p5), 1500);
        prices.stream().forEach(System.out::println);
    }

    public static Set<Integer> getAllPriceFromProduct (List<Product> productList, int priceRange) {
        return productList.stream()
                .map(Product::getPrice)
                .filter(price -> price > priceRange)
                .collect(Collectors.toSet());
    }
}
