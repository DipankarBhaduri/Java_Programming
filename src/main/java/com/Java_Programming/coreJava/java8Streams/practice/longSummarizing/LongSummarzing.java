package com.Java_Programming.coreJava.java8Streams.practice.longSummarizing;

import com.Java_Programming.coreJava.java8Streams.practice.reduce.Product;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class LongSummarzing {
    public static void main(String[] args) {
        Product p1 = new Product(1,"Nokia", 4000);
        Product p2 = new Product(2,"Redmi", 3000);
        Product p3 = new Product(3,"Apple", 2000);
        Product p4 = new Product(4,"Samsung", 1000);

        LongSummaryStatistics longSummaryStatistics = getLongSummarzingObject (Arrays.asList(p1, p2, p3, p4));
        System.out.println("Max-"+longSummaryStatistics.getMax());
        System.out.println("Min-"+longSummaryStatistics.getMin());
    }

    private static LongSummaryStatistics getLongSummarzingObject(List<Product> productList) {
        return productList.stream().collect(Collectors.summarizingLong(Product::getPrice));
    }
}
