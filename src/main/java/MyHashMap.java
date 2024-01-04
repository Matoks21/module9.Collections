package main.java;

        import java.util.Arrays;


public class MyHashMap<K, V> {
    // Масив для зберігання бакетів (Node) hashmap
    private Node<K, V>[] hashTable = new Node[16];
    // Кількість елементів в hashmap
    private int size;




    private void resize() {
        float loadTable = (float) size / hashTable.length;
        if (loadTable >= 0.75) {
            Node<K, V>[] nodes = new Node[hashTable.length * 2];
            System.arraycopy(hashTable, 0, nodes, 0, hashTable.length);
            hashTable = nodes;
        }
    }

    // Метод для додавання елемента за ключем та значенням
    public void put( K key, V value) {
        resize();

        // Обчислення хешу ключа та визначення індексу бакета
        int hash = Math.abs(key.hashCode()) % hashTable.length;

        // Отримання посилання на перший елемент в бакеті
        Node<K, V> node = hashTable[hash];

        // Додавання нового елемента, якщо бакет порожній
        if (node == null) {

            hashTable[hash] = new Node<>(key, value);

        } else {
            // Інакше, перевірка наявності ключа у бакеті
            while (true) {
                // Перевірка наявності наступного елемента
                if (node.getKey().equals(key)) {
                    node.setValue(value);
                    return;
                }

                // Якщо досягнуто кінця бакету і ключа там немає, додається новий елемент у кінець бакету
                if (node.next == null) {
                    node.next = new Node<>(key, value);
                    return;
                }

                // Перехід до наступного елемента бакету
                node = node.next;
            }
        }
        size++;
    }

    // Метод для отримання значення за ключем
    public V get( K key) {
        // Обчислення хешу ключа та визначення індексу бакета
        int hash = Math.abs(key.hashCode()) % hashTable.length;
        // Отримання посилання на перший елемент в бакеті
        Node<K, V> node = hashTable[hash];

        // Пошук елемента за ключем у бакеті
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }

            // Перехід до наступного елемента бакету
            node = node.next;
        }

        // Якщо елемент не знайдено, повернення null
        return null;
    }

    // Метод для видалення елемента за ключем
    public Node<K, V> remove( K key) {
        // Обчислення хешу ключа та визначення індексу бакета
        int hash = Math.abs(key.hashCode()) % hashTable.length;
        // Отримання посилання на перший елемент в бакеті
        Node<K, V> node = hashTable[hash];

        // Якщо бакет порожній, повернення null
        if (node == null) {
            return null;
        }

        // Якщо елемент за ключем розташований на початку бакету
        if (node.getKey().equals(key)) {
            hashTable[hash] = node.next;
            node.next = null;
            size--;
            return node;
        }

        // Інакше, пошук елемента за ключем у бакеті
        Node<K, V> prev = node;
        node = node.next;

        while (node != null) {
            // Знайдено елемент за ключем, видалення та повернення його
            if (node.getKey().equals(key)) {
                prev.next = node.next;
                node.next = null;
                size--;
                return node;
            }

            // Перехід до наступного елемента бакету
            prev = node;
            node = node.next;
        }

        // Якщо елемент не знайдено, повернення null
        return null;
    }

    // Метод для очищення hashmap
    public void clear() {

        // Проходження по всім бакетам та їх очищення
        Arrays.fill(this.hashTable, null);
    }

    // Метод для отримання кількості елементів у hashmap
    public int size() {
        return this.size;
    }

    // Перевизначений метод toString для виведення hashmap у вигляді рядка
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Проходження по масиву бакетів
        for (int i = 0; i < hashTable.length; ++i) {

            // Додавання індексу та вмісту кожного бакета у рядок
            if (hashTable[i] != null) {
                sb.append(i).append(")").append(hashTable[i]).append(" ");
            } else {
                sb.append(i).append(")").append("null ");
            }
        }

        return sb.toString();
    }
    private static class Node<K, V> {
        // Приватні поля для зберігання ключа, значення та посилання на наступний елемент в бакеті
        private final K key;
        private V value;
        private Node<K, V> next;

        // Конструктор для створення елемента з ключем та значенням
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }


        // Метод для отримання ключа елемента
        public K getKey() {
            return this.key;
        }

        // Метод для отримання значення елемента
        public V getValue() {
            return this.value;
        }

        public void setValue(V newValue) {
            this.value = newValue;
        }

        // Перевизначений метод toString для представлення елемента у вигляді рядка
        public String toString() {
            // Початкове посилання на елемент
            Node<K, V> map = this;

            // Створення об'єкту StringBuilder для зберігання рядка
            StringBuilder sb;
            for (sb = new StringBuilder(); map != null; map = map.next) {
                // Додавання значень елементів у рядок
                sb.append(map.value).append(" ");
            }

            // Повернення отриманого рядка
            return sb.toString();
        }

    }
}