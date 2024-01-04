package main.java;

import java.util.Objects;


public class MyLinkedList<T> {

    // Розмір зв'язаного списку.
    private int size = 0;

    // Перший вузол у зв'язаному списку.
    private Node<T> head;

    //  Клас Node<T> представляє окремі вузли у зв'язаному списку.
    private static class Node<T> {
        T element;
        Node<T> next;

        // Рядкове представлення вузла.
        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next + '}';
        }

        // Ініціалізація вузла заданим елементом.
        Node(T element) {
            this.element = element;
        }
    }


    // Повертає розмір зв'язаного списку.
    public int size() {
        return size;
    }

    // Додає елемент в кінець зв'язаного списку.
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
    }

    // Видаляє елемент за вказаним індексом із зв'язаного списку.
    public void remove(int index) {
        Objects.checkIndex(index, size);

        if (index == 0) {
            head = head.next;


        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }

        size--;
    }

    // Повертає вузол за вказаним індексом у зв'язаному списку.
    private Node<T> getNodeByIndex(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    // Повертає останній вузол списку.
    public Node<T> getLastNode() {
        return getNodeByIndex(size - 1);
    }

    // Повертає елемент за вказаним індексом у зв'язаному списку.
    public T get(int index) {
        validateIndex(index);
        return getNodeByIndex(index).element;
    }

    // Перевіряє допустимість індексу у зв'язаному списку.
    private void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index can't be found! "
                    + ". Total size of list = " + size);
        }
    }


    // Очищає зв'язаний список, встановлюючи head в null і розмір у 0.
    public void clear() {
        head = head.next = null;
        size = 0;
    }

    @Override
    public String toString() {
        return "MyLinkedList {" + "head = " + head + "}";
    }

}
