package com.hackerrank.datastructure.linkedlist;

/**
 * Created by rajeshkumar on 03/05/17.
 */
public class MyLinkedList {
    public static void main(String[] args) {
        Node headA = new Node(1);
        headA.Insert(headA, 2);
        headA.Insert(headA, 3);

        Node headB = new Node(1);
        headB.next = headA.next.next;
/*        headA.Insert(headA, 2);
        headA.Insert(headA, 3);
        headA.Insert(headA, 3);
        headA.Insert(headA, 4);*/


        headA.Print(headA);
        headB.Print(headB);

        // System.out.println("GetNode:" + RemoveDuplicates(headA));
        //headA.Print(RemoveDuplicates(headA));
        //headA.Print(MergeLists(headA, headB));
        System.out.println(FindMergeNode(headA, headB));
    }

    static int FindMergeNode(Node headA, Node headB) {
        Node tempA = headA;
        Node tempB = headB;
        while (tempB != null) {
            if (tempA == tempB) {
                return tempA.data;
            }
            tempB = tempB.next;
        }
        return FindMergeNode(tempA.next, headB);
    }

    static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node currentFaster = head.next;
        Node currentSlower = head;
        while (currentFaster != null && currentFaster.next != null) {
            if (currentFaster == currentSlower) {
                return true;
            }
            currentFaster = currentFaster.next.next;
            currentSlower = currentSlower.next;
        }
        return false;
    }

    static Node RemoveDuplicates(Node head) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (previous == null) {
                previous = current;
            } else if (current.data == previous.data) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    static int GetNode(Node head, int n) {
        Node currentFaster = head;
        Node currentSlower = null;
        int counter = 0;

        while (currentFaster.next != null) {
            if (counter++ == n) {
                currentSlower = head;
            }
            currentFaster = currentFaster.next;
            currentSlower = currentSlower != null ? currentSlower.next : currentSlower;
        }

        return currentSlower.data;
    }

    static Node MergeLists(Node headA, Node headB) {
        Node mergedHead = null;
        Node currentNode = null;
        Node tempA = headA;
        Node tempB = headB;
        while (tempA != null || tempB != null) {
            if (tempA != null && tempB != null) {
                if (tempA.data <= tempB.data) {
                    if (currentNode == null) {
                        currentNode = tempA;
                        mergedHead = currentNode;
                    } else {
                        currentNode.next = tempA;
                        currentNode = currentNode.next;
                    }
                    tempA = tempA.next;
                } else {
                    if (currentNode == null) {
                        currentNode = tempB;
                        mergedHead = currentNode;
                    } else {
                        currentNode.next = tempB;
                        currentNode = currentNode.next;
                    }
                    tempB = tempB.next;
                }
            } else if (tempA == null && tempB != null) {
                if (currentNode == null) {
                    currentNode = tempB;
                    mergedHead = currentNode;
                } else {
                    currentNode.next = tempB;
                }
                break;
            } else if (tempA != null && tempB == null) {
                if (currentNode == null) {
                    currentNode = tempA;
                    mergedHead = currentNode;
                } else {
                    currentNode.next = tempA;
                }
                break;
            }
        }
        return mergedHead;
    }

    static int CompareLists(Node headA, Node headB) {
        int equality = 0;
        Node tempA = headA;
        Node tempB = headB;
        while (tempA != null && tempB != null) {
            if ((tempA.next != null && headB.next == null) || (tempA.next == null && tempB.next != null)) {
                equality = 0;
            } else {
                equality = tempA.data == tempB.data ? 1 : 0;
            }
            if (equality == 0) {
                break;
            } else {
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        return equality;
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

    Node Reverse(Node head) {
        Node current = head;
        Node previous = null;
        Node temp;
        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
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
            if (head.next != null) {
                Print(head.next);
            }
        }
    }

    void ReversePrint(Node head) {
        Node temp = head;
        String builder = "";
        while (temp != null) {
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
