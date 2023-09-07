package com.Java_Programming.coreJava.java8Streams.concept.map;

import com.Java_Programming.coreJava.java8Streams.concept.reduce.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapConvertion {
    public static void main(String[] args) {
        Product p1 = new Product(1,"Nokia", 4000);
        Product p2 = new Product(2,"Redmi", 3000);
        Product p3 = new Product(3,"Apple", 2000);
        Product p5 = new Product(5,"Google", 2000);
        Product p4 = new Product(5,"Samsung", 1000);

        Map<Integer, Product> productMap = listToMap(Arrays.asList(p1, p2, p3, p4, p5));
        productMap.entrySet().forEach(integerProductEntry -> System.out.println(integerProductEntry.getKey()+"-"+integerProductEntry.getValue().getPrice()));
    }

    private static Map listToMap(List<Product> productList) {
        return productList.stream().collect(Collectors.toMap(Product::getId, product -> product, (existing, newValue) -> existing));
    }
}
