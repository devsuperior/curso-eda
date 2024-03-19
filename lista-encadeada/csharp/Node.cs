namespace Lists.LinkedList {
    public class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T GetValue() {
            return value;
        }

        public void SetValue(T value) {
            this.value = value;
        }

        public Node<T> GetNext() {
            return next;
        }

        public void SetNext(Node<T> next) {
            this.next = next;
        }
    }
}
