package com.hackerrank.datastructure.balancedtress;

import java.util.Scanner;

import static java.lang.Math.random;

/**
 * Created by rajeshkumar on 20/05/17.
 */
public class ArrayAndSimpleQueries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        int m = in.nextInt();
        Treap treap = new Treap();

        for (int i = 1; i <= n; ++i) {
            treap.insert(in.nextInt());
        }
        while (m-- > 0) {
            int type = in.nextInt();
            if (type == 1) {
                treap.query2(in.nextInt(), in.nextInt());
            } else {
                treap.query1(in.nextInt(), in.nextInt());
            }
        }
        System.out.println(Math.abs(treap.getmax(treap.root) - treap.getmin(treap.root)));
        treap.inorder(treap.root);
    }

    static class Treap {
        Node root;

        int size(Node node) {
            return node == null ? 0 : node.siz;
        }

        public boolean search(int key) {
            return search(root, key);
        }

        private boolean search(Node root, int key) {
            while (root != null) {
                if (root.val > key) {
                    root = root.left;
                } else if (root.val < key) {
                    root = root.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        void update(Node node) {
            if (node != null) {
                node.siz = size(node.left) + 1 + size(node.right);
            }
        }

        void split(Node node, Node l, Node r, int key, int lcount) {
            if (node == null) {
                l = null;
                r = null;
            } else if (lcount + 1 + size(node.left) <= key) {
                split(node.right, node.right, r, key, lcount + 1 + size(node.left));
                l = node;
            } else {
                split(node.left, l, node.left, key, lcount);
                r = node;
            }
            update(node);
        }

        void merge(Node node, Node l, Node r) {
            if (l == null || r == null) {
                node = l != null ? l : r;
            } else if (l.pri > r.pri) {
                merge(l.right, l.right, r);
                node = l;
            } else {
                merge(r.left, l, r.left);
                node = r;
            }
            update(node);
        }

        int getmin(Node tree) {
            if (tree == null) {
                return 0;
            }
            if (tree.left != null) {
                return getmin(tree.left);
            }
            return tree.val;
        }

        int getmax(Node tree) {
            if (tree == null) {
                return 0;
            }
            if (tree.right != null) {
                return getmax(tree.right);
            }
            return tree.val;
        }

        void inorder(Node tree) {
            if (tree != null) {
                inorder(tree.left);
                System.out.println(tree.val);
                inorder(tree.right);
            }
        }

        void insert(int val) {
            final Node node = new Node();
            node.val = val;
            merge(root, root, node);
        }

        void query1(int l, int r) {
            Node temp1 = null;
            Node temp2 = null;
            Node temp3 = null;
            Node temp4 = null;
            split(root, temp1, temp2, r, 0);
            split(temp1, temp3, temp4, l - 1, 0);
            merge(root, temp3, temp2);
            merge(root, root, temp4);
        }

        void query2(int l, int r) {
            Node temp1 = null;
            Node temp2 = null;
            Node temp3 = null;
            Node temp4 = null;
            split(root, temp1, temp2, r, 0);
            split(temp1, temp3, temp4, l - 1, 0);
            merge(root, temp3, temp2);
            merge(root, temp4, root);
        }
    }

    static class Node {
        int val;
        int siz;
        int pri;
        Node left;
        Node right;

        Node() {
            val = -1;
            siz = 1;
            pri = (int) random();
            left = null;
            right = null;
        }
    }
}

/*

8
4
1
2
3
4
5
6
7
8
1
2
4
2
3
5
1
4
7
2
1
4

 */
