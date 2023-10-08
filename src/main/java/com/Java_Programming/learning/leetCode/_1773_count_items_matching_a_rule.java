package com.Java_Programming.learning.leetCode;

import java.util.ArrayList;
import java.util.List;

public class _1773_count_items_matching_a_rule {
    public static void main(String[] args) {
        List<List<String>> data = new ArrayList<>();

        data.add(new ArrayList<>(List.of("phone", "blue", "pixel")));
        data.add(new ArrayList<>(List.of("computer", "silver", "lenovo")));
        data.add(new ArrayList<>(List.of("phone", "gold", "iphone")));
        String ruleKey = "color";
        String ruleValue = "silver";
        int count = Solution1.countMatches(data, ruleKey, ruleValue);
        System.out.println(count);
    }
}


class Solution1 {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(List<String> str : items) {
            if(ruleKey.equals("color")) {
                count = (str.get(1).equals(ruleValue)) ? count + 1 : count ;
            } else if (ruleKey.equals("type")) {
                count = (str.get(0).equals(ruleValue)) ? count + 1 : count ;
            } else if (ruleKey.equals("name")) {
                count = (str.get(2).equals(ruleValue)) ? count + 1 : count ;
            }
        }
        return count;
    }
}