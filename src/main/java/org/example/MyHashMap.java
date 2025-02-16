package org.example;

public class MyHashMap<K, V> {
    private NodeMap<K, V>[] map = new NodeMap[10];  // Масив для збереження елементів
    private int size = 0;

    // Повертає кількість елементів у мапі
    public int size() {
        return size;
    }

    // Очищає мапу
    public void clear() {
        map = new NodeMap[10];  // Очищаємо масив
        size = 0;
    }

    // Отримуємо значення за ключем
    public V get(K key) {
        int index = key.hashCode() % map.length;
        NodeMap<K, V> current = map[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();  // Повертаємо значення, якщо ключ знайдено
            }
            current = current.getNext();
        }
        return null;  // Якщо ключ не знайдений, повертаємо null
    }

    // Додаємо пару ключ-значення
    public void put(K key, V value) {
        int index = key.hashCode() % map.length;
        NodeMap<K, V> current = map[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                current.setValue(value);  // Якщо ключ вже існує, оновлюємо значення
                return;
            }
            current = current.getNext();
        }

        // Якщо ключа не знайдено, додаємо новий елемент в список за індексом
        NodeMap<K, V> newNode = new NodeMap<>(key, value);
        newNode.setNext(map[index]);
        map[index] = newNode;  // Новий елемент стає першим в списку
        size++;
    }

    // Видаляємо пару за ключем
    public void remove(K key) {
        int index = key.hashCode() % map.length;
        NodeMap<K, V> current = map[index];
        NodeMap<K, V> previous = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (previous == null) {
                    // Видаляємо перший елемент у списку
                    map[index] = current.getNext();
                } else {
                    // Видаляємо елемент всередині або в кінці списку
                    previous.setNext(current.getNext());
                }
                size--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    // Внутрішній клас для збереження пар ключ-значення в списку
    static class NodeMap<K, V> {
        private K key;
        private V value;
        private NodeMap<K, V> next;

        public NodeMap(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public NodeMap<K, V> getNext() {
            return next;
        }

        public void setNext(NodeMap<K, V> next) {
            this.next = next;
        }
    }
}
