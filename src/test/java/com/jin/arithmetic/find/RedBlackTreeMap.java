package com.jin.arithmetic.find;

/**
 * 红黑树的方式实现平衡二叉查找树
 *
 * @author jinpeng
 * @date 2019/7/29.
 */
public class RedBlackTreeMap<K extends Comparable<K>, V> {
    private final static boolean RED = true;
    private final static boolean BLACK = true;

    public Node root;

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) return null;
        //递归查找
        int cmp = key.compareTo(node.key);
        if (cmp > 0) return get(node.right, key);
        else if (cmp < 0) return get(node.left, key);
        else return node.value;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    public Node put(Node h, K key, V value) {
        if (h == null) return new Node(key, value, RED);
        int cmp = key.compareTo(h.key);
        if (cmp > 0) h.right = put(h.right, key, value);
        else if (cmp < 0) h.left = put(h.left, key, value);
        else h.value = value;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.right) && isRed(h.left)) flipClolors(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);

        h.size = 1 + size(h.left) + size(h.right);
        return h;
    }

    public int size() {
        return size(root);
    }

    private int size(RedBlackTreeMap.Node node) {
        return node == null ? 0 : node.size;
    }


    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipClolors(Node h) {
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }

    public boolean isRed(Node node) {
        if (node == null) return BLACK;
        return node.color == RED;
    }

    public class Node {
        public Node parent;
        public Node left;
        public Node right;

        public K key;
        public V value;
        public int size;

        public boolean color;


        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

        public Node(K key, V value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }
}
