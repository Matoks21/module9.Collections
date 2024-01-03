package main.java;



import java.util.Arrays;
        import java.util.Objects;

public class MyQueue<T> {

    private int size;
    private T[] arrayQ = (T[]) new Object[size];

    @Override
    public String toString() {
        return "MyQueue{" +
                "size=" + size +
                ", arrayQ=" + Arrays.toString(arrayQ) +
                '}';
    }

    //додає елемент в кінець
    public void add(T value) {
        T[] newArrayQ = (T[]) new Object[arrayQ.length + 1];
        System.arraycopy(arrayQ, 0, newArrayQ, 0, arrayQ.length);
        arrayQ = newArrayQ;
        arrayQ[arrayQ.length - 1] = value;
        size++;
    }


    //видаляє елемент за індексом
    public void remove(int index) {
        Objects.checkIndex(index, size);
        int newLength = arrayQ.length - 1;
        T[] newArrayQ = (T[]) new Object[newLength];
        System.arraycopy(arrayQ, 0, newArrayQ, 0, index);
        System.arraycopy(arrayQ, index + 1, newArrayQ, index, newLength - index);
        arrayQ = newArrayQ;
        size--;
    }


    //повертає перший елемент черзі (FIFO)
    public T peek() {
        return arrayQ[0];
    }

    //очищає колекцію
    public void clear() {
        arrayQ = (T[]) new Object[0];
        size = 0;
    }

    //повертає перший елемент в черзі і видаляє його з колекції
    public T poll() {
        int newLength = arrayQ.length - 1;
        T[] newArrayQ = (T[]) new Object[newLength];
        T fistElement = arrayQ[0];
        System.arraycopy(arrayQ, 1, newArrayQ, 0, newLength);
        arrayQ = newArrayQ;
        size--;
        return fistElement;
    }

    //повертає розмір колекції
    public int size() {
        return size;
    }

}
