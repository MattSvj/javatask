import java.util.Objects;

public class Tree<T extends Comparable<T>> {

    private Node root;

    private class Node {
        private T value;
        private Node left;
        private Node right;

        public Node(T value) {
            this.value = value;
        }
    }

    public void add(T value) {
        Objects.requireNonNull(value);
        root = appendNode(root, value);
    }

    private Node appendNode(Node current, T value) {
        if (current == null) {
            return new Node(value);
        }

        int compare = value.compareTo(current.value);
        if (compare < 0) {
            current.left = appendNode(current.left, value);
        } else if (compare > 0) {
            current.right = appendNode(current.right, value);
        }

        return current;
    }

    public boolean contains(T value) {
        Objects.requireNonNull(value);
        return containsNode(root, value);
    }

    private boolean containsNode(Node current, T value) {
        if (current == null) {
            return false; // Значение не найдено
        }

        int compare = value.compareTo(current.value);
        if (compare < 0) {
            return containsNode(current.left, value); // Ищем в левом поддереве
        } else if (compare > 0) {
            return containsNode(current.right, value); // Ищем в правом поддереве
        } else {
            return true; // Значение найдено
        }
    }

}