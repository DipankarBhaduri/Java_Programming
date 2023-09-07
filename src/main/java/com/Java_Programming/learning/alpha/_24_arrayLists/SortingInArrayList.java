package com.Java_Programming.learning.alpha._24_arrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingInArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5,4,6,3,7,2,8)) ;
        sortAList(list);
        System.out.println(list);
    }
    public static void sortAList(List<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(i) > list.get(j)) {
                    int val = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, val);
                }
            }
        }
    }
}
