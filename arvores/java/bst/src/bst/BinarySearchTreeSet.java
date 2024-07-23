package bst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BinarySearchTreeSet<K extends Comparable<K>> {

    private int size;
    private Node root;

    public BinarySearchTreeSet() {
        size = 0;
        root = new Node(null, null);
    }

    public BinarySearchTreeSet(Collection<K> c) {
        this();
        addAll(c);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean remove(K key) {    	
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    	
        Node nodeToRemove = findKeyLocation(root, key);
        
        if (nodeToRemove.isSentinel()) { // not found
            return false; 
        }

        // two children adjustment
        if (!nodeToRemove.left.isSentinel() && !nodeToRemove.right.isSentinel()) {
            Node successor = findMin(nodeToRemove.right);
            nodeToRemove.key = successor.key;
            nodeToRemove = successor; // nodeToRemove now has 0 or 1 child
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
        return true;
    }

    private Node findMin(Node node) {
        while (!node.left.isSentinel()) {
            node = node.left;
        }
        return node;
    }
    
    public void add(K key) {
    	if (key == null) {
    		throw new IllegalArgumentException("Key cannot be null");
    	}

        if (isEmpty()) {
            root = new Node(key, null);
            root.left = new Node(null, root);
            root.right = new Node(null, root);
            size++;
            return;
        }

        Node node = findKeyLocation(root, key);
        
        if (node.isSentinel()) { // key not found
            insertAtExternal(node, key);
            size++;
        }
    }

    private Node findKeyLocation(Node node, K key) {
        while (!node.isSentinel()) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                return node;
            } else if (cmp < 0) {
            	node = node.left;
            } else {
            	node = node.right;
            }
        }
        return node;
    }

    private void insertAtExternal(Node sentinel, K key) {

        Node parent = sentinel.parent;
        Node newNode = new Node(key, parent);
        
        if (sentinel == parent.left) {
            parent.left = newNode;
        } else if (sentinel == parent.right) {
            parent.right = newNode;
        }

        newNode.left = new Node(null, newNode);
        newNode.right = new Node(null, newNode);
    }
    
    public void addAll(Collection<K> c) {
        for (K item : c) {
            add(item);
        }
    }

    public boolean contains(K key) {
    	Node node = findKeyLocation(root, key);
        return !node.isSentinel();
    }

    public List<K> keys() {
        List<K> keysList = new ArrayList<>();
        collectKeys(root, keysList);
        return keysList;
    }

    private void collectKeys(Node node, List<K> keysList) {
        if (!node.isSentinel()) {
        	collectKeys(node.left, keysList);
            keysList.add(node.key);
            collectKeys(node.right, keysList);
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
    
    @Override
    public String toString() {
        return keys().toString();
    }

    private class Node {
        K key;
        Node left, right, parent;

        Node(K key, Node parent) {
            this.key = key;
            this.left = this.right = null;
            this.parent = parent;
        }
        
        boolean isSentinel() {
        	return key == null;
        }
    }
}
