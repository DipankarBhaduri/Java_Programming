package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_03_09_2023;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class CalculateSumMinMaxUsingSummarzingLong {
    /**
     * @Question : Summarizing: Given a list of Order objects with a totalPrice field, calculate the sum, average,
     *             minimum, and maximum order prices using summarizingLong.
     * @param args
     */
    public static void main(String[] args) {
        Order order1 = new Order(1, 100);
        Order order2 = new Order(2, 200);
        Order order3 = new Order(3, 300);
        Order order4 = new Order(4, 500);
        Order order5 = new Order(5, 1000);

        LongSummaryStatistics longSummaryStatistics = getStatusOfOrders(Arrays.asList(order1, order2, order3, order4, order5));
        System.out.println(longSummaryStatistics.getMax());
        System.out.println(longSummaryStatistics.getMin());
        System.out.println(longSummaryStatistics.getAverage());
        System.out.println(longSummaryStatistics.getSum());
    }

    private static LongSummaryStatistics getStatusOfOrders(List<Order> orderList) {
        return orderList.stream().collect(Collectors.summarizingLong(Order::getTotalPrice));
    }
}
