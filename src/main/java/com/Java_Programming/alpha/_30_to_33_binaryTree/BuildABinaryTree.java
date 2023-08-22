package com.Java_Programming.alpha._30_to_33_binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildABinaryTree {
    public static void main(String[] args) {
        int [] nodes = { 4,3,-1,-1,5,-1,7,-1,8,10,-1,-1,9,-1,-1} ;
        TreeNode root = buildTree(nodes) ;
        inOderTraversal(root);
    }

    public static void levelOrderTraversal ( TreeNode root ) {
        Queue<TreeNode> queue = new LinkedList<>() ;
        if ( root != null ){
            queue.add(root) ;
            queue.add(null) ;
        } else {
            return;
        }

        while ( !queue.isEmpty()) {
            TreeNode curr = queue.poll() ;
            if ( curr == null ){
                if ( !queue.isEmpty()){
                    System.out.println();
                    queue.add(null);
                } else {
                    break;
                }
            }

            if ( curr != null ){
                System.out.print(curr.root+" ");
            }

            if ( curr != null && curr.leftChild != null ){
                queue.add(curr.leftChild) ;
            }
            if ( curr != null && curr.rightChild != null ){
                queue.add(curr.rightChild) ;
            }
        }
    }

    public static void preOrderTraversal ( TreeNode root ){
        if ( root == null ){
            return;
        }

        System.out.print(root.root +" - ");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public static void postOrderTraversal ( TreeNode root ){
        if ( root == null ){
            return;
        }

        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
        System.out.print(root.root +" - ");
    }

    public static void inOderTraversal ( TreeNode root ){
        if ( root == null ){
            return;
        }

        preOrderTraversal(root.leftChild);
        System.out.print(root.root +" - ");
        preOrderTraversal(root.rightChild);
    }


    static int index = -1 ;
    public static TreeNode buildTree ( int [] nodes ){
        index++ ;
        if ( nodes[index] == -1 ){
            return  null ;
        }

        TreeNode node = new TreeNode(nodes[index]) ;
        node.leftChild = buildTree(nodes) ;
        node.rightChild = buildTree(nodes) ;
        return node ;
    }
}

class TreeNode {
     int root ;
     TreeNode leftChild ;
     TreeNode rightChild ;

    TreeNode ( int data ){
        this.root = data ;
        this.leftChild = null ;
        this.rightChild = null ;
    }
}