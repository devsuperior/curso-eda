using System;
using System.Collections.Generic;

namespace Bst
{
    public class BinarySearchTreeSet<K> where K : IComparable<K>
    {
        private int size;
        private Node root;

        public BinarySearchTreeSet()
        {
            size = 0;
            root = new Node(default(K), null);
        }

        public BinarySearchTreeSet(IEnumerable<K> collection) : this()
        {
            AddAll(collection);
        }

        public int Size()
        {
            return size;
        }

        public bool IsEmpty()
        {
            return size == 0;
        }

        public bool Remove(K key)
        {
            if (key == null)
            {
                throw new ArgumentException("Key cannot be null");
            }

            Node nodeToRemove = FindKeyLocation(root, key);

            if (nodeToRemove.IsSentinel)
            {
                return false;
            }

            if (nodeToRemove.Left == null || nodeToRemove.Right == null)
            {
                throw new InvalidOperationException("Left or Right null");
            }

            if (!nodeToRemove.Left.IsSentinel && !nodeToRemove.Right.IsSentinel)
            {
                Node successor = FindMin(nodeToRemove.Right);
                nodeToRemove.Key = successor.Key;
                nodeToRemove = successor;
            }

            if (nodeToRemove.Left == null || nodeToRemove.Right == null)
            {
                throw new InvalidOperationException("Left or Right null");
            }

            Node child = nodeToRemove.Left.IsSentinel ? nodeToRemove.Right : nodeToRemove.Left;
            child.Parent = nodeToRemove.Parent;

            if (nodeToRemove.Parent == null)
            {
                root = child;
            }
            else if (nodeToRemove == nodeToRemove.Parent.Left)
            {
                nodeToRemove.Parent.Left = child;
            }
            else
            {
                nodeToRemove.Parent.Right = child;
            }

            size--;
            return true;
        }

        private Node FindMin(Node node)
        {
            if (node.Left == null)
            {
                throw new InvalidOperationException("Left null");
            }
            while (node.Left != null && !node.Left.IsSentinel)
            {
                node = node.Left;
            }
            return node;
        }

        public void Add(K key)
        {
            if (key == null)
            {
                throw new ArgumentException("Key cannot be null");
            }

            if (IsEmpty())
            {
                root = new Node(key, null);
                root.Left = new Node(default(K), root);
                root.Right = new Node(default(K), root);
                size++;
                return;
            }

            Node node = FindKeyLocation(root, key);

            if (node.IsSentinel && node.Parent != null)
            {
                Node parent = node.Parent;
                Node newNode = new Node(key, parent);
                newNode.Left = new Node(default(K), newNode);
                newNode.Right = new Node(default(K), newNode);

                if (node == parent.Left)
                {
                    parent.Left = newNode;
                }
                else if (node == parent.Right)
                {
                    parent.Right = newNode;
                }

                size++;
            }
        }

        private Node FindKeyLocation(Node node, K key)
        {
            while (!node.IsSentinel)
            {
                int cmp = key.CompareTo(node.Key);
                if (cmp == 0)
                {
                    return node;
                }
                else if (cmp < 0 && node.Left != null)
                {
                    node = node.Left;
                }
                else if (cmp > 0 && node.Right != null)
                {
                    node = node.Right;
                }
            }
            return node;
        }

        public void AddAll(IEnumerable<K> collection)
        {
            foreach (var item in collection)
            {
                Add(item);
            }
        }

        public bool Contains(K key)
        {
            Node node = FindKeyLocation(root, key);
            return !node.IsSentinel;
        }

        public List<K> Keys()
        {
            List<K> keysList = new List<K>();
            CollectKeys(root, keysList);
            return keysList;
        }

        private void CollectKeys(Node? node, List<K> keysList)
        {
            if (node != null && !node.IsSentinel)
            {
                CollectKeys(node.Left, keysList);
                if (node.Key != null)
                {
                    keysList.Add(node.Key);
                }
                CollectKeys(node.Right, keysList);
            }
        }

        public BinarySearchTreeSet<K> Union(BinarySearchTreeSet<K> other)
        {
            BinarySearchTreeSet<K> result = new BinarySearchTreeSet<K>();
            foreach (K key in this.Keys())
            {
                result.Add(key);
            }
            foreach (K key in other.Keys())
            {
                if (!result.Contains(key))
                {
                    result.Add(key);
                }
            }
            return result;
        }

        public BinarySearchTreeSet<K> Intersection(BinarySearchTreeSet<K> other)
        {
            BinarySearchTreeSet<K> result = new BinarySearchTreeSet<K>();
            foreach (K key in this.Keys())
            {
                if (other.Contains(key))
                {
                    result.Add(key);
                }
            }
            return result;
        }

        public BinarySearchTreeSet<K> Difference(BinarySearchTreeSet<K> other)
        {
            BinarySearchTreeSet<K> result = new BinarySearchTreeSet<K>();
            foreach (K key in this.Keys())
            {
                if (!other.Contains(key))
                {
                    result.Add(key);
                }
            }
            return result;
        }

        public override string ToString()
        {
            var keys = Keys();
            if (keys == null || keys.Count == 0)
            {
                return "[]";
            }
            return string.Join(", ", keys.Select(k => k?.ToString() ?? "null"));  // trata chaves nulas
        }

        public string ToStringFormat()
        {
            var sb = new System.Text.StringBuilder();
            ToStringFormat(root, 0, sb);
            return sb.ToString();
        }

        private void ToStringFormat(Node node, int depth, System.Text.StringBuilder sb)
        {
            if (node != null && !node.IsSentinel)
            {
                if (node.Right != null)
                {
                    ToStringFormat(node.Right, depth + 1, sb);
                }
                string space = (depth > 0) ? new string(' ', 2 * (depth - 1)) + "--" : "";
                string parent = (depth > 0) ? (node.Parent?.Key?.ToString() ?? "") : "";
                sb.AppendLine($"{space}({node.Key}){parent}");
                if (node.Left != null)
                {
                    ToStringFormat(node.Left, depth + 1, sb);
                }
            }
        }

        private class Node
        {
            public K? Key { get; set; }
            public Node? Left, Right, Parent;

            public Node(K? key, Node? parent)
            {
                Key = key;
                Left = Right = null;
                Parent = parent;
            }

            public bool IsSentinel => Key == null || Key.Equals(default(K));
        }
    }
}
