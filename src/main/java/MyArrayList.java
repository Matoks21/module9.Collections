
package main.java;

        import java.util.Arrays;

public class MyArrayList<T> {
    private int size;
    private T[] array;

    public MyArrayList(T[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    /* додає елемент в кінець */
    public void add(T value) {
        if (size == array.length) {
            resize();
        }
        if (array[size] == null) {
            array[size] = value;
        }
        size++;
    }

    private void resize() {
        T[] newArray = Arrays.copyOf(array, (array.length * 3) / 2 + 1);//Створення нового масиву newArray з більшою довжиною
        System.arraycopy(array, 0, newArray, 0, array.length);//Копіювання елементів зі старого масиву array
        array = newArray; // Присвоєння змінній array посилання на новий масив newArray
    }

    /*видаляє елемент із вказаним індексом*/
    public void remove(int index) {
        try {
            int elementInNewArray = size - index - 1;//кількість елементів , яку потрібно копіювати
            System.arraycopy(array, index + 1, array, index, elementInNewArray);   //копіювання елементів
            array[--size] = null;//зменшення розміру масива на один елемент
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }


    /*очищає колекцію*/
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    /*
    повертає розмір колекції
     */
    public int size() {
        size = 0;
        for (T arr : array) {
            if (arr != null) {
                size++;
            }
        }
        return size;
    }
    /*
    повертає елемент за індексом}
     */

    public T get(int index) {

        T element = null;
        for (int i = 0; i < array.length; i++) {
            try {
                if (i == index) {
                    element = array[i];
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                ex.printStackTrace();
            }
        }
        return element;
    }
}