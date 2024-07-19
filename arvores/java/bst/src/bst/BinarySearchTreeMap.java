package bst;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeMap<K extends Comparable<K>, V> {
    
	private final Node SENTINEL = new Node(null, null);
    
	private Node root = SENTINEL;
    private int size;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == SENTINEL) {
            size++;
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public V remove(K key) {
        V value = get(key);
        if (value != null) {
            root = remove(root, key);
        }
        return value;
    }

    private Node remove(Node node, K key) {
        if (node == SENTINEL) return SENTINEL;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            size--;
            if (node.right == SENTINEL) return node.left;
            if (node.left == SENTINEL) return node.right;

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    private Node min(Node node) {
        while (node.left != SENTINEL) node = node.left;
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == SENTINEL) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == SENTINEL) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        inorder(root, keys, true);
        return keys;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        inorder(root, values, false);
        return values;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void inorder(Node node, List list, boolean keys) {
        if (node != SENTINEL) {
            inorder(node.left, list, keys);
            list.add(keys ? node.key : node.value);
            inorder(node.right, list, keys);
        }
    }
    
    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = this.right = SENTINEL;
        }
    }
}
