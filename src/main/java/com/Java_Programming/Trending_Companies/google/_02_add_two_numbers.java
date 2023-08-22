package com.Java_Programming.Trending_Companies.google;

public class _02_add_two_numbers {
    /**
     * @Link : https://leetcode.com/problems/add-two-numbers/
     */
    public static void main(String[] args) {
        /**
         * @ListNode1 : Preparing the first node for add two number ;
         */
        int [] l1 = {9,9,9};
        ListNode node1 = null;
        for (int i = 0; i < l1.length; i++){
            node1 = preparedLinkedList (l1[i], node1);
        }

        /**
         * @ListNode2 : Preparing the second node for add two number ;
         */
        int [] l2 = {9,9,9};
        ListNode node2 = null;
        for (int i = 0; i < l2.length; i++){
            node2 = preparedLinkedList (l2[i], node2);
        }

        ListNode rootNode = addTwoNumbers(node1, node2);
        printLinkedList(rootNode);
    }

    private static ListNode preparedLinkedList(int val, ListNode node1) {
        if (node1 == null){
            ListNode listNode = new ListNode(val) ;
            return listNode ;
        } else {
            ListNode curr = node1;
            ListNode listNode = new ListNode(val);
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = listNode;
            return node1;
        }
    }

    public static void printLinkedList (ListNode root){
        while (root != null){
            System.out.print(root.data+"->");
            root = root.next;
        }
        return;
    }

    /**
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode dummy = node;
        int carry = 0;

        while (l1 != null && l2 != null){
            int val = l1.data + l2.data + carry;
            ListNode node1 = new ListNode(val%10);
            node.next = node1;
            node = node.next;
            carry = val / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int val = l1.data + carry;
            ListNode node1 = new ListNode(val%10);
            node.next = node1;
            node = node.next;
            carry = val / 10;

            l1 = l1.next;
        }

        while (l2 != null){
            int val = l2.data + carry;
            ListNode node1 = new ListNode(val%10);
            node.next = node1;
            node = node.next;
            carry = val / 10;

            l2 = l2.next;
        }

        if ( carry != 0 ){
            ListNode node1 = new ListNode(carry);
            node.next = node1;
        }

        return dummy.next;
    }
}

class ListNode {
    int data ;
    ListNode next;
    ListNode (int data){
        this.data = data;
        this.next = null;
    }
}