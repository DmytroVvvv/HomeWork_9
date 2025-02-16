package org.example;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myList = new MyArrayList<>();

        myList.add("John");
        myList.add("Alice");
        myList.add("Bob");
        myList.add("Dima");
        myList.add("Vasya");

        System.out.println("Initial List: " + myList);

        myList.remove(2);  // Видалення елемента за індексом 2 (Bob)
        myList.add("Dave"); // Додавання нового елемента "Dave"

        System.out.println("Final List: " + myList);

        System.out.println("---------------------------");

        MyLinkedList<String> list = new MyLinkedList<>();

        System.out.println("Initial array size: " + list.elements.length);

        list.add("John");
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");
        list.add("Eve");

        System.out.println("List after adding elements: " + list);

        System.out.println("Array size after adding elements: " + list.elements.length);

        System.out.println("----------------------------");

        MyQueue<String> queue = new MyQueue<>();

        System.out.println("Initial array size: " + queue.result.length);

        queue.add("John");
        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");
        queue.add("Eve");

        System.out.println("Queue after adding elements: " + queue);

        System.out.println("First element (peek): " + queue.peek());

        System.out.println("Removed first element (pool): " + queue.pool());

        System.out.println("Queue after removing first element: " + queue);

        System.out.println("Array size after operations: " + queue.result.length);

        System.out.println("--------------------------------");

        MyStack<String> stack = new MyStack<>();

        // Перевірка початкового розміру масиву
        System.out.println("Initial array size: " + stack.result.length);

        // Додаємо елементи в стек
        stack.push("John");
        stack.push("Alice");
        stack.push("Bob");
        stack.push("Charlie");
        stack.push("Eve");

        // Виведення стеку після додавання елементів
        System.out.println("Stack after adding elements: " + stack);

        // Переглядаємо елемент на верху стеку
        System.out.println("Top element (peek): " + stack.peek());

        // Видаляємо елемент з верху стеку
        System.out.println("Popped element (pop): " + stack.pop());

        // Виведення стеку після видалення елемента
        System.out.println("Stack after popping an element: " + stack);

        // Перевірка нового розміру масиву
        System.out.println("Array size after operations: " + stack.result.length);

        System.out.println("---------------------------");

        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("John", 25);
        map.put("Alice", 30);
        map.put("Bob", 22);

        System.out.println("John's age: " + map.get("John"));
        System.out.println("Alice's age: " + map.get("Alice"));

        map.remove("Bob");

        System.out.println("Bob's age after removal: " + map.get("Bob"));

        System.out.println("Size after removal: " + map.size());

        System.out.println("-----------------------------");

    }
}

