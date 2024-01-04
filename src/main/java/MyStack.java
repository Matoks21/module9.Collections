package main.java;



import java.util.Objects;

public class MyStack<T> {
    private Node<T> head;
    private int size;

    /*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            sb.append(node.element).append(" ");
            node = node.next;
        }
        return sb.toString();
    }
     */



    // додає елемент в кінець
    public void push(Object value) {
        Node<T> node = new Node<>((T) value);
        node.next = head;
        head = node;
        size++;
    }

    // видалення елемента за індексом
    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) head = head.next;
        else {
            Node<T> prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }
        size--;

    }

    //повертає елемент за індексом
    private Node<T> getNodeByIndex(int index) throws IndexOutOfBoundsException {
        if (index >= size||index<0) {
            throw new IndexOutOfBoundsException("Index can't be found! "
                    + ". Total size of list = " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    //очищення стеку
    public void clear() {
        head = null;
        size = 0;
    }

    //повернення розмір колекції
    public int size() {
        return size;
    }

    //повернення першого елементу стеку (LIFO)
    public T peek() {
        return head.element;
    }

    // повернення першого елемента стеку, і видалення його
    public T pop() {
        T element = head.element;
        head = head.next;
        size--;
        return element;

    }

    @Override
    public String toString() {
        return "MyStack{" +
                "head :" + head +
                ", size=" + size +
                '}';
    }

    private static class Node<T> {
        T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return
                    "element=" + element +"{  next "+
                            next+" }";
        }
    }
}