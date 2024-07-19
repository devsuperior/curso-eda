package generictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenericTree<T> {
    private Node<T> root;
    private int size;

    public GenericTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public List<T> elementsDfs() {
        List<T> elements = new ArrayList<>();
        collectElements(elements, root);
        return elements;
    }

    private void collectElements(List<T> list, Node<T> node) {
        if (node != null) {
            list.add(node.element());
            for (Node<T> child : node.getChildren()) {
            	collectElements(list, child);
            }
        }
    }

    public List<T> elementsBfs() {
        List<T> elements = new ArrayList<>();
        if (root == null) {
            return elements;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll(); 
            elements.add(current.element());

            for (Node<T> child : current.getChildren()) {
                queue.add(child);
            }
        }

        return elements;
    }
    
    public List<Position<T>> positions() {
        List<Position<T>> positions = new ArrayList<>();
        collectPositions(positions, root);
        return positions;
    }

    private void collectPositions(List<Position<T>> list, Node<T> node) {
        if (node != null) {
            list.add(node);
            for (Node<T> child : node.getChildren()) {
                collectPositions(list, child);
            }
        }
    }

    public void replace(Position<T> position, T element) {
        Node<T> node = validate(position);
        node.setElement(element);
    }

    public Position<T> root() {
        if (isEmpty()) {
            throw new IllegalStateException("The tree is empty");
        }
        return root;
    }

    public Position<T> parent(Position<T> position) {
        Node<T> node = validate(position);
        if (node == root) {
            throw new IllegalStateException("The root has no parent");
        }
        return node.getParent();
    }

    public List<Position<T>> children(Position<T> position) {
        Node<T> node = validate(position);
        return new ArrayList<>(node.getChildren());
    }

    public boolean isExternal(Position<T> position) {
        Node<T> node = validate(position);
        return node.getChildren().isEmpty();
    }

    public boolean isRoot(Position<T> position) {
        Node<T> node = validate(position);
        return node == root;
    }

    private Node<T> validate(Position<T> position) {
        if (!(position instanceof Node)) {
            throw new IllegalArgumentException("Invalid position type");
        }
        Node<T> node = (Node<T>) position;
        if (node.getParent() == node) { // Convention to indicate 'deleted' or 'not part of the tree'
            throw new IllegalArgumentException("Position is no longer in the tree");
        }
        return node;
    }
    
    public Position<T> add(T element, Position<T> parentPos) {
        if (!isEmpty() && parentPos == null) {
            throw new IllegalArgumentException("Parent position can't be null for a non empty tree");
        }
        Node<T> parent = parentPos == null ? null : validate(parentPos);
        Node<T> newNode = new Node<>(element, parent);
        if (parent == null) {
            root = newNode;
        } else {
            parent.addChild(newNode);
        }
        size++;
        return newNode;
    }

    public void remove(Position<T> position) {
        Node<T> node = validate(position);
        if (node == root) {
            root = null;
        } else {
            Node<T> parent = node.getParent();
            if (parent != null) {
                parent.removeChild(node);
            }
        }
        size -= subtreeSize(node);
        markAsRemoved(node);
    }

    private int subtreeSize(Node<T> node) {
        int subtreeCount = 1;
        for (Node<T> child : node.getChildren()) {
            subtreeCount += subtreeSize(child);
        }
        return subtreeCount;
    }

    private void markAsRemoved(Node<T> node) {
        node.setParent(node);
        for (Node<T> child : node.getChildren()) {
            markAsRemoved(child);
        }
    }
    
    // DFS (Depth-First Search) to find an element
    public Position<T> findDfs(T element) {
        return findRecursively(root, element);
    }

    private Position<T> findRecursively(Node<T> node, T target) {
        if (node == null) {
            return null;
        }
        if (node.element().equals(target)) {
            return node;
        }
        for (Node<T> child : node.getChildren()) {
            Position<T> found = findRecursively(child, target);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
    
    // BFS (Breadth-First Search) to find an element
    public Position<T> findBfs(T element) {
        if (root == null) {
            return null;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();

            if (current.element().equals(element)) {
                return current;
            }

            queue.addAll(current.getChildren());
        }

        return null;
    }
}

