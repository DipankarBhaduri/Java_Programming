package com.Java_Programming.learning.alpha._14_arrays;

public class howMuchWaterItCanTrapAfterRaining {
    public static void main ( String[] args ){
        int [] height = {4,2,3} ;
        int maxWaterCanContent = getHowMuchWaterItCanTrapAfterRaining(height) ;
        System.out.println(maxWaterCanContent);
    }
    public static int getHowMuchWaterItCanTrapAfterRaining ( int[] height ){
        int [] LH = getLeftHeight(height) ;
        int [] RH = getRightHeight(height) ;
        int maxWaterCanContent = 0 ;
        for ( int i = 0 ; i < height.length ; i++ ){
            int minH = Math.min(LH[i] , RH[i]) ;
            if ( minH > height[i]){
                maxWaterCanContent+= minH - height[i] ;
            }
        }
        return maxWaterCanContent ;
    }

    public static int[] getLeftHeight ( int[] height ){
        int maxH = height[0] ;
        int [] LH = new int [height.length] ;
        LH[0] = 0 ;
        for ( int i = 1 ; i < LH.length ; i++ ){
            LH[i] = maxH ;
            maxH = height[i] > maxH ? height[i] : maxH ;
        }
        return LH ;
    }
    public static int[] getRightHeight ( int[] height ){
        int maxH = height[height.length-1] ;
        int [] RH = new int [height.length] ;
        RH[height.length - 1 ] = 0 ;
        for ( int i = height.length - 2 ; i >= 0 ; i-- ){
            RH[i] = maxH ;
            maxH = height[i] > maxH ? height[i] : maxH ;
        }
        return RH ;
    }
}
