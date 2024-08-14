namespace GenericTree
{
    public class GenericTree<T>
    {
        private Node? root;
        private int size;

        public GenericTree()
        {
            root = null;
            size = 0;
        }

        public int Size() => size;

        public bool IsEmpty() => size == 0;

        public List<T> Elements()
        {
            List<T> elements = new List<T>();
            CollectElements(elements, root);
            return elements;
        }

        private void CollectElements(List<T> list, Node? node)
        {
            if (node != null)
            {
                list.Add(node.Element());
                foreach (Node child in node.GetChildren())
                {
                    CollectElements(list, child);
                }
            }
        }

        public List<IPosition<T>> Positions()
        {
            List<IPosition<T>> positions = new List<IPosition<T>>();
            CollectPositions(positions, root);
            return positions;
        }

        private void CollectPositions(List<IPosition<T>> list, Node? node)
        {
            if (node != null)
            {
                list.Add(node);
                foreach (Node child in node.GetChildren())
                {
                    CollectPositions(list, child);
                }
            }
        }

        public void Replace(IPosition<T>? position, T element)
        {
            Node node = Validate(position);
            node.SetElement(element);
        }

        public IPosition<T>? Root()
        {
            return root;
        }

        public IPosition<T>? Parent(IPosition<T> position)
        {
            Node node = Validate(position);
            return node.GetParent();
        }

        public List<IPosition<T>> Children(IPosition<T> position)
        {
            Node node = Validate(position);
            return new List<IPosition<T>>(node.GetChildren());
        }

        public bool IsExternal(IPosition<T> position)
        {
            Node node = Validate(position);
            return node.GetChildren().Count == 0;
        }

        public bool IsRoot(IPosition<T> position)
        {
            Node node = Validate(position);
            return node == root;
        }

        private Node Validate(IPosition<T>? position)
        {
            if (!(position is Node node))
                throw new ArgumentException("Invalid position type");

            if (node.GetParent() == node) // Convention to indicate deleted
                throw new ArgumentException("Position is no longer in the tree");

            return node;
        }

        public IPosition<T> Add(T element, IPosition<T>? parent)
        {
            if (!IsEmpty() && parent == null)
            {
                throw new ArgumentException("Parent position can't be null for a non empty tree");
            }
            Node? parentNode = parent == null ? null : Validate(parent);
            Node newNode = new Node(element, parentNode);
            if (parentNode == null)
            {
                root = newNode;
            }
            else
            {
                parentNode.AddChild(newNode);
            }
            size++;
            return newNode;
        }

        public void Remove(IPosition<T> position)
        {
            Node node = Validate(position);
            if (node == root)
            {
                root = null;
            }
            else
            {
                Node? parent = node.GetParent();
                if (parent != null)
                {
                    parent.RemoveChild(node);
                }
            }
            size -= SubtreeSize(node);
            MarkAsRemoved(node);
        }

        private int SubtreeSize(Node node)
        {
            int subtreeCount = 0;
            foreach (Node child in node.GetChildren())
            {
                subtreeCount += SubtreeSize(child);
            }
            return 1 + subtreeCount;
        }

        private void MarkAsRemoved(Node node)
        {
            node.SetParent(node);
            foreach (Node child in node.GetChildren())
            {
                MarkAsRemoved(child);
            }
        }

        public IPosition<T>? Find(T element)
        {
            return FindRecursive(root, element);
        }

        private IPosition<T>? FindRecursive(Node? node, T target)
        {
            if (node == null)
            {
                return null;
            }
            if (target != null && target.Equals(node.Element()))
            {
                return node;
            }
            foreach (Node child in node.GetChildren())
            {
                IPosition<T>? found = FindRecursive(child, target);
                if (found != null)
                {
                    return found;
                }
            }
            return null;
        }

        // Inner class Node
        private class Node : IPosition<T>
        {
            private T element;
            private Node? parent;
            private List<Node> children;

            public Node(T element, Node? parent)
            {
                this.element = element;
                this.parent = parent;
                children = new List<Node>();
            }

            public T Element() => element;

            public void SetElement(T element) => this.element = element;

            public Node? GetParent() => parent;

            public void SetParent(Node? parent) => this.parent = parent;

            public List<Node> GetChildren() => children;

            public void AddChild(Node child)
            {
                children.Add(child);
                child.SetParent(this);
            }

            public void RemoveChild(Node child)
            {
                children.Remove(child);
                child.SetParent(null);
            }
        }
    }
}
