package com.Java_Programming.alpha._24_arrayLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairSum {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10,15,20,3,4,5,6,7));
        int target = 36;
        boolean response = findPairSum (list, target);
        System.out.println(response);
    }
    public static boolean findPairSum(List<Integer>list, int target) {
        int bp = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i+1)) {
                bp = i;
            }
        }

        int lp = bp;
        int rp = bp + 1;

        while (lp != rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }

            if (list.get(lp) + list.get(rp) < target) {
                rp = (rp + 1) % list.size();
            } else {
                if (lp == 0) {
                    lp = list.size() - 1;
                } else {
                    lp -= 1;
                }
            }
        }

        return false;
    }
}
