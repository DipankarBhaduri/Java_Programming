package com.Java_Programming.learning.advanceJava;

public class CreateLinkedList {
    public static void main(String[] args) {
        int [] nums = {2, 3, 5, 7, 9};
        Node root = null;
        for(int data : nums) {
            root = addLast(data, root);
        }
        printLinkedList(root);
        Node reverseLinkedList = reverseLinkedList(root);
        printLinkedList(reverseLinkedList);

    }
    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printLinkedList (Node root) {
        Node head = root;
        if(head == null) {
            System.out.println("Do not have any element in LinkedList {} :");
        } else {
            while (head != null) {
                System.out.print(head.data+" -> ");
                head = head.next;
            }
        }
        System.out.println();
    }
    public static Node addLast (int data, Node head) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            return head;
        } else {
            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        return head;
    }
}

class Node {
    int data;
    Node next;
    Node (int data) {
        this.data = data;
        this.next = null;
    }
}