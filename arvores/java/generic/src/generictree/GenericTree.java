package generictree;

import java.util.ArrayList;
import java.util.List;

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

	public List<T> elements() {
		List<T> elements = new ArrayList<>();
		collectElements(elements, root);
		return elements;
	}

	private void collectElements(List<T> list, Node<T> node) {
		list.add(node.element());
		for (Node<T> child : node.getChildren()) {
			collectElements(list, child);
		}
	}

	public List<Position<T>> positions() {
		List<Position<T>> positions = new ArrayList<>();
		collectPositions(positions, root);
		return positions;
	}

	private void collectPositions(List<Position<T>> list, Node<T> node) {
		list.add(node);
		for (Node<T> child : node.getChildren()) {
			collectPositions(list, child);
		}
	}

	public void replace(Position<T> position, T element) {
		Node<T> node = validate(position);
		node.setElement(element);
	}

	public Position<T> root() {
		return root;
	}

	public Position<T> parent(Position<T> position) {
		Node<T> node = validate(position);
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
		if (node.getParent() == node) { // Convention to indicate deleted
			throw new IllegalArgumentException("Position is no longer in the tree");
		}
		return node;
	}

	public Position<T> add(T element, Position<T> parent) {
		if (!isEmpty() && parent == null) {
			throw new IllegalArgumentException("Parent position can't be null for a non empty tree");
		}
		Node<T> parentNode = parent == null ? null : validate(parent);
		Node<T> newNode = new Node<>(element, parentNode);
		if (parentNode == null) {
			root = newNode;
		} else {
			parentNode.addChild(newNode);
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

	public Position<T> find(T element) {
		return findRecursive(root, element);
	}

	private Position<T> findRecursive(Node<T> node, T target) {
		if (node == null) {
			return null;
		}
		if (node.element().equals(target)) {
			return node;
		}
		for (Node<T> child : node.getChildren()) {
			Position<T> found = findRecursive(child, target);
			if (found != null) {
				return found;
			}
		}
		return null;
	}
}
