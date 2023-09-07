package com.Java_Programming.learning.coreJava.java8Streams.practice.practiceProblem_04_09_2023;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOutProductByCategory {
    /**
     * @Questions : You have a list of Product objects with attributes name, price, and category.
     *              You want to filter out products in the "Electronics" category with a price greater than $500,
     *              and then map their names to a new list. Write a Java Stream program to achieve this.
     * @param args
     */
    public static void main(String[] args) {
        List<ProductDetails> productList = new ArrayList<>();

        // Adding 10 objects of the ProductDetails class to the list
        productList.add(new ProductDetails("Ear Phone", 100, "Electronics"));
        productList.add(new ProductDetails("T shirt", 50, "Clothing"));
        productList.add(new ProductDetails("Nokia", 200, "Electronics"));
        productList.add(new ProductDetails("Math", 30, "Books"));
        productList.add(new ProductDetails("Clip", 75, "Home Appliances"));
        productList.add(new ProductDetails("laptop", 150, "Electronics"));
        productList.add(new ProductDetails("Pant", 80, "Clothing"));
        productList.add(new ProductDetails("Romantic", 10, "Books"));
        productList.add(new ProductDetails("bluetooth", 300, "Electronics"));
        productList.add(new ProductDetails("Share", 45, "Clothing"));
        
        List<String> names = getNamesFromProductListBasedOnTheCondition (productList);
        names.stream().forEach(System.out::println);
    }

    private static List<String> getNamesFromProductListBasedOnTheCondition(List<ProductDetails> productList) {
        return productList.stream()
                .filter(productDetails -> productDetails.getCategory().equals("Electronics"))
                .filter(productDetails -> productDetails.getPrice() > 180)
                .map(ProductDetails::getName)
                .collect(Collectors.toList());
    }
}


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
class ProductDetails {
    private String name;
    private int price;
    private String category;
}