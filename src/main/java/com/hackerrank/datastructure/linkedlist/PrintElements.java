package com.hackerrank.datastructure.linkedlist;

/**
 * Created by rajeshkumar on 03/05/17.
 */
public class PrintElements {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.Insert(head, 1);
        head.Insert(head, 5);
        head.Insert(head, 4);

        head.ReversePrint(head);
    }
}

class Node {
    int data;
    Node next;

    public Node() {

    }

    public Node(final int data) {
        this.data = data;
    }

    public Node Insert(Node head, int data) {
        final Node node = new Node();
        node.data = data;
        if (head == null) {
            head = node;
        } else {
            if (head.next == null) {
                head.next = node;
            } else {
                Insert(head.next, data);
            }
        }
        return head;
    }

    public void Print(Node head) {
        if (head != null) {
            System.out.println(head.data);
        }
        if (head.next != null) {
            Print(head.next);
        }
    }

    void ReversePrint(Node head) {
        Node temp = head;
        String builder = "";
        while(temp != null){
            builder = temp.data + "\n" + builder;
            temp = temp.next;
        }

        System.out.print(builder);
    }

    public Node InsertHead(Node head, int data) {
        final Node node = new Node();
        node.data = data;
        if (head == null) {
            head = node;
        } else {
            node.next = head;
        }
        return node;
    }

    public Node InsertNth(Node head, int data, int position) {
        Node temp = new Node();
        Node curr = head;
        temp.data = data;
        temp.next = null;

        if (head == null) {
            head = temp;
            return head;
        }
        if (position == 0) {
            temp.next = head;
            return temp;
        }
        for (int i = 0; i < position - 1; i++) {
            curr = curr.next;
        }
        temp.next = curr.next;
        curr.next = temp;

        return head;
    }

    public Node Delete(Node head, int position) {
        Node curr = head;
        Node previous = null;

        if (head == null) {
            return head;
        }
        if (position == 0) {
            head = head.next;
            return head;
        }
        for (int i = 0; i < position; i++) {
            previous = curr;
            curr = curr.next;
        }
        previous.next = curr.next;

        return head;

    }
}
