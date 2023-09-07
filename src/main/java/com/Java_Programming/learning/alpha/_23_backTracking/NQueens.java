package com.Java_Programming.learning.alpha._23_backTracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        char chess[][] = new char [n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        nQueen(chess,0);
    }

    public static void nQueen(char[][] chess, int row) {
        if(row == chess.length) {
            printChess(chess);
            return;
        }

        for(int j = 0; j < chess.length; j++) {
            chess[row][j] = 'Q';
            nQueen(chess ,row+1);
            chess[row][j] = '.';
        }
    }

    public static void printChess(char[][] chess) {
        System.out.println("--- CHESS BOARD ---");
        for(int i = 0; i < chess.length; i++) {
            for(int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
    }
}
