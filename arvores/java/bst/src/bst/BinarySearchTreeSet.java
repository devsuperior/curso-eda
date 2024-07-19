package bst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinarySearchTreeSet<K extends Comparable<K>> {
	
    private final Node SENTINEL = new Node(null);
    private int size = 0;
    private Node root = SENTINEL;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K key) {
        root = add(root, key);
    }

    private Node add(Node node, K key) {
        if (node == SENTINEL) {
            size++;
            return new Node(key);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = add(node.left, key);
        } else if (cmp > 0) {
            node.right = add(node.right, key);
        }
        return node;
    }

    public void addAll(Collection<K> c) {
    	for (K item : c) {
    		add(item);
    	}
    }
    
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node node, K key) {
        if (node == SENTINEL) {
            return false;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
    }

    public boolean remove(K key) {
        if (contains(key)) {
            root = remove(root, key);
            size--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, K key) {
        if (node == SENTINEL) {
            return SENTINEL;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == SENTINEL) {
                return node.right;
            } else if (node.right == SENTINEL) {
                return node.left;
            }
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    private Node min(Node node) {
        while (node.left != SENTINEL) {
            node = node.left;
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == SENTINEL) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public List<K> keys() {
        List<K> keysList = new ArrayList<>();
        inOrderTraversal(root, keysList);
        return keysList;
    }

    private void inOrderTraversal(Node node, List<K> keysList) {
        if (node != SENTINEL) {
            inOrderTraversal(node.left, keysList);
            keysList.add(node.key);
            inOrderTraversal(node.right, keysList);
        }
    }

    public BinarySearchTreeSet<K> union(BinarySearchTreeSet<K> other) {
        BinarySearchTreeSet<K> result = new BinarySearchTreeSet<>();
        for (K key : this.keys()) {
            result.add(key);
        }
        for (K key : other.keys()) {
            result.add(key);
        }
        return result;
    }

    public BinarySearchTreeSet<K> intersection(BinarySearchTreeSet<K> other) {
        BinarySearchTreeSet<K> result = new BinarySearchTreeSet<>();
        for (K key : this.keys()) {
            if (other.contains(key)) {
                result.add(key);
            }
        }
        return result;
    }

    public BinarySearchTreeSet<K> difference(BinarySearchTreeSet<K> other) {
        BinarySearchTreeSet<K> result = new BinarySearchTreeSet<>();
        for (K key : this.keys()) {
            if (!other.contains(key)) {
                result.add(key);
            }
        }
        return result;
    }
    
    private class Node {
        K key;
        Node left, right;

        Node(K key) {
            this.key = key;
            this.left = this.right = SENTINEL;
        }
    }
}
