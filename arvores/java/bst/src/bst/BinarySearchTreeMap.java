package bst;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeMap<K extends Comparable<K>, V> {

    private int size;
    private Node root;

    public BinarySearchTreeMap() {
        size = 0;
        root = new Node(null, null, null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        Node node = findKeyLocation(root, key);
        return node.isSentinel() ? null : node.value;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        Node nodeToRemove = findKeyLocation(root, key);
        
        if (nodeToRemove.isSentinel()) {
            return null; 
        }

        V removedValue = nodeToRemove.value;
        
        if (!nodeToRemove.left.isSentinel() && !nodeToRemove.right.isSentinel()) {
            Node successor = findMin(nodeToRemove.right);
            nodeToRemove.key = successor.key;
            nodeToRemove.value = successor.value;
            nodeToRemove = successor;
        }

        Node child = nodeToRemove.left.isSentinel() ? nodeToRemove.right : nodeToRemove.left;
        child.parent = nodeToRemove.parent;
        
        if (nodeToRemove.parent == null) {
            root = child;
        } else if (nodeToRemove == nodeToRemove.parent.left) {
            nodeToRemove.parent.left = child;
        } else {
            nodeToRemove.parent.right = child;
        }
        
        size--;
        return removedValue;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (isEmpty()) {
            root = new Node(key, value, null);
            root.left = new Node(null, null, root);
            root.right = new Node(null, null, root);
            size++;
            return;
        }

        Node node = findKeyLocation(root, key);
        
        if (node.isSentinel()) {
        	
        	Node parent = node.parent;
        	Node newNode = new Node(key, value, parent);
            newNode.left = new Node(null, null, newNode);
            newNode.right = new Node(null, null, newNode);

        	if (node == parent.left) {
                parent.left = newNode;
            } else if (node == parent.right) {
                parent.right = newNode;
            }
        	
            size++;
        }
        else {
            node.value = value; // Update value if key already exists
        }
    }

    public boolean containsKey(K key) {
    	Node node = findKeyLocation(root, key);
        return !node.isSentinel();
    }

    public List<K> keys() {
        List<K> keysList = new ArrayList<>();
        collectKeys(root, keysList);
        return keysList;
    }

    public List<V> values() {
        List<V> valuesList = new ArrayList<>();
        collectValues(root, valuesList);
        return valuesList;
    }

    private Node findKeyLocation(Node node, K key) {
        while (!node.isSentinel()) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) { // key found
                return node;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    private void collectKeys(Node node, List<K> keysList) {
        if (!node.isSentinel()) {
            collectKeys(node.left, keysList);
            keysList.add(node.key);
            collectKeys(node.right, keysList);
        }
    }

    private void collectValues(Node node, List<V> valuesList) {
        if (!node.isSentinel()) {
            collectValues(node.left, valuesList);
            valuesList.add(node.value);
            collectValues(node.right, valuesList);
        }
    }

    private Node findMin(Node node) {
        while (!node.left.isSentinel()) {
            node = node.left;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        toStringHelper(root, sb);
        sb.append("}");
        return sb.toString();
    }

    private void toStringHelper(Node node, StringBuilder sb) {
        if (!node.isSentinel()) {
            toStringHelper(node.right, sb);
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append("\"").append(node.key).append("\": \"").append(node.value).append("\"");
            toStringHelper(node.left, sb);
        }
    }

    private class Node {
        K key;
        V value;
        Node left, right, parent;

        Node(K key, V value, Node parent) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
            this.parent = parent;
        }
        
        boolean isSentinel() {
            return key == null;
        }
    }
}
