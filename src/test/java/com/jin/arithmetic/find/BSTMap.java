package com.jin.arithmetic.find;

/**
 * 二叉查找树
 *
 * @author jinpeng
 * @date 2019/7/26.
 */
public class BSTMap<K extends Comparable<K>, V> {

    private Node root;

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
    }

    private Node put(Node node, K key, V value) {
        if (node == null) return new Node(key, value, 1);
        //递归查找
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }


    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
    }

    public K min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    public K max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }


    public class Node {
        protected K key;
        protected V value;
        /*父节点*/
        protected Node parent;
        /*左节点*/
        protected Node left;
        /*右节点*/
        protected Node right;

        protected int size;

        public Node(K key, V value, Node parent, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

    }

    public Node getNode() {
        return root;
    }

    public void setNode(Node node) {
        this.root = node;
    }
}
