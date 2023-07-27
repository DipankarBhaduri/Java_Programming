package com.Java_Programming.alpha._20_recursionBasic;

import java.util.ArrayList;
import java.util.List;

public class FindAllOccurrence {
    public static void main(String[] args) {
        int [] arr = { 3,2,3,5,6,2,4,5,6,2,2} ;
        int target = 2 ;
        List<Integer> integerList = new ArrayList<>() ;
        int index = 0 ;
        getAllOccurrenceOfTarget(arr , target , integerList , index);
        System.out.println(integerList);
    }
    public static  void getAllOccurrenceOfTarget ( int[] arr , int target , List<Integer> integerList , int index ){
        if ( index == arr.length){
            return  ;
        }
        if ( arr[index] == target ) {
            integerList.add(index);
        }
        getAllOccurrenceOfTarget(arr, target, integerList, index+1);
    }
}
