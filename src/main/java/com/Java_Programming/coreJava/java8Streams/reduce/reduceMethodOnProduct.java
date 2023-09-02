package com.Java_Programming.coreJava.java8Streams.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class reduceMethodOnProduct {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;


        Product p1 = new Product(1,"Nokia", 4000);
        Product p2 = new Product(2,"Redmi", 3000);
        Product p3 = new Product(3,"Apple", 2000);
        Product p4 = new Product(4,"Samsung", 1000);

        int totalPrice = getTotalPrice(Arrays.asList(p1, p2, p3, p4)) ;
        System.out.println(totalPrice);

    }

    public static int getTotalPrice (List<Product> productList) {

        LongSummaryStatistics longSummaryStatistics = productList.stream().collect(Collectors.summarizingLong(product -> product.getPrice()));

        return productList.stream().map(Product::getPrice)
                .reduce(0, Integer::sum);
    }
}
