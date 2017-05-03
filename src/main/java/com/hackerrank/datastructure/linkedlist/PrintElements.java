package com.hackerrank.datastructure.linkedlist;

/**
 * Created by rajeshkumar on 03/05/17.
 */
public class PrintElements {
    public static void main(String[] args) {

    }
}

class Node {
    int data;
    Node next;

    public Node(final int data) {

    }

    Node Insert(Node head, int data) {
        //Node tail = new Node(data);
        Node tailNode = findTail(head);
        final Node node = new Node(data);
        tailNode.next = node;
        node.next = null;
        return node;
    }

    void Print(Node head) {
        if (head != null) {
            System.out.println(head.data);
        }
        Print(head.next);
    }

    Node findTail(Node head) {
        while (head.next != null) {
            findTail(head.next);
        }
        return head;
    }
}
