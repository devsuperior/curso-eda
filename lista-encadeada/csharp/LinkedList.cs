using System;
using System.Collections.Generic;

namespace Lists.LinkedList {
    public class LinkedList<T> {
        private Node<T> head;
        private int size;

        public LinkedList() {
            this.head = null;
            this.size = 0;
        }

        public Node<T> GetHead() {
            return this.head;
        }

        public bool IsEmpty() {
            return head == null;
        }

        public int GetSize() {
            return size;
        }

        public void AddAtStart(T elem) {
            Node<T> node = new Node<T>(elem);
            if (IsEmpty()) {
                head = node;
                size++;
                return;
            }
            Node<T> aux = head;
            head = node;
            node.SetNext(aux);
            size++;
        }

        public void AddAtEnd(T elem) {
            Node<T> node = new Node<T>(elem);
            if (IsEmpty()) {
                head = node;
                size++;
                return;
            }
            Node<T> current = head;
            while (current.GetNext() != null) {
                current = current.GetNext();
            }
            current.SetNext(node);
            size++;
        }

        public void AddAtPosition(int index, T elem) {
            if (index == 0) {
                AddAtStart(elem);
                return;
            }

            if (Get(index) == null) {
                AddAtEnd(elem);
                return;
            }

            Node<T> node = new Node<T>(elem);
            Node<T> aux = GetNode(index - 1);
            node.SetNext(aux.GetNext());
            aux.SetNext(node);
            size++;
        }

        public T Get(int index) {
            Node<T> current = GetNode(index);
            if (current != null)
                return current.GetValue();
            return null;
        }

        public Node<T> GetNode(int index) {
            if (index < 0 || index >= size)
                return null;
            Node<T> current = head;
            int i = 0;
            while (i != index) {
                current = current.GetNext();
                i++;
            }
            return current;
        }

        public bool Contains(T elem) {
            int indexElem = IndexOf(elem);
            if (indexElem != -1) 
                return true;
            return false;
        }

        public int IndexOf(T elem) {
            Node<T> current = head;
            int i = 0;
            while (current != null) {
                if (current.GetValue() == elem)
                    return i;
                current = current.GetNext();
                i++;
            }
            return -1;
        }

        public T RemoveAtPosition(int index) {
            if (IsEmpty() || Get(index) == null) {
                return null;
            }

            T item;
            Node<T> aux;
            
            if (index == 0) {
                item = head.GetValue();
                head = head.GetNext();
                size--;
                return item;
            }

            if (index == size - 1) {
                item = Get(index);
                aux = GetNode(index - 1);
                aux.SetNext(null);
                size--;
                return item;
            }

            aux = GetNode(index - 1);
            item = aux.GetNext().GetValue();
            aux.SetNext(aux.GetNext().GetNext());
            size--;
            return item;
        }

        public bool Remove(T elem) {
            int index = IndexOf(elem);
            if (IsEmpty() || index == -1)
                return false;
            RemoveAtPosition(index);
            return true;
        }

        public List<T> ToArray() {
            List<T> vect = new List<T>();
            Node<T> current = head;

            while (current != null)
            {
                vect.Add(current.GetValue());
                current = current.GetNext();
            }
            return vect;
        }

        public override string ToString() {
            if (IsEmpty()) {
                return "[]";
            }

            List<T> list = ToArray();
            return "[" + string.Join(",", list) + "]";
        }
    }
}
