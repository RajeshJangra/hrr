package com.hackerrank.datastructure.linkedlist;

/**
 * Created by rajeshkumar on 04/05/17.
 */
public class DoublyLinkedList {
    public static void main(String[] args) {
        Node head = new DoublyLinkedList.Node();
        head.data = 1;

        head = SortedInsert(head, 2);
        head = SortedInsert(head, 3);
        head = SortedInsert(head, 4);
        Print(head);
        System.out.println("Reversed: ");
        Print(Reverse(head));
    }

    static Node Reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        while (current.next != null) {
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        }
        current.next = current.prev;
        current.prev = null;

        return current;
    }

    static Node SortedInsert(Node head, int data) {
        Node current = head;
        Node node = new Node();
        node.data = data;
        if (current == null) {
            head = node;
        }
        if (head.data > data) {
            node.next = current;
            current.prev = node;
            return node;
        } else {
            while (current.next != null) {
                if (current.data > data) {
                    node.next = current;
                    node.prev = current.prev;
                    current.prev.next = node;
                    current.prev = node;
                    return head;
                }
                current = current.next;
            }
            //Last Node
            if (current.data > data) {
                node.next = current;
                node.prev = current.prev;
                current.prev.next = node;
                current.prev = node;
            } else {
                node.prev = current;
                current.next = node;
            }
        }
        return head;
    }

    static class Node {
        int data;
        Node next;
        Node prev;
    }

    static public void Print(Node head) {
        if (head != null) {
            System.out.println(head.data);
            if (head.next != null) {
                Print(head.next);
            }
        }
    }
}
