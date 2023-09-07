package com.Java_Programming.coreJava.java8Streams.practice.maxMin;

import com.Java_Programming.coreJava.java8Streams.practice.reduce.Product;
import java.util.Arrays;
import java.util.List;

public class FindMaxMinPriceObject {
    public static void main(String[] args) {
        Product p1 = new Product(1,"Nokia", 4000);
        Product p2 = new Product(2,"Redmi", 3000);
        Product p3 = new Product(3,"Apple", 2000);
        Product p4 = new Product(4,"Samsung", 1000);

        Product maxPriceProduct = getMaxPriceProduct (Arrays.asList(p1, p2, p3, p4));
        System.out.println(maxPriceProduct.getName());
    }

    private static Product getMaxPriceProduct(List<Product> productList) {
        return productList.stream()
                .min((product1, product2) -> product1.getPrice() > product2.getPrice() ? 1 : -1)
                .get();
    }
}
