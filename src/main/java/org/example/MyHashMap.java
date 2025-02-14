package org.example;

public class MyHashMap {
    private NodeMap[] map = new NodeMap[10];
    private int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        map = new NodeMap[10];
        size = 0;
    }

    public Object get(Object key) {
        int index = key.hashCode() % map.length;
        Object result = null;
        NodeMap current = map[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                result = current.getValue();
                break;
            }
            current = current.getNext();
        }
        return result;
    }

    public void put(Object key, Object value) {
        int index = key.hashCode() % map.length;
        NodeMap current = map[index];

        while (current != null) {
            if (current.getKey().equals(key)) {
                current.setValue(value);
                return;
            }
            current = current.getNext();
        }

        NodeMap newNode = new NodeMap(key, value);
        newNode.setNext(map[index]);
        map[index] = newNode;
    }


    public void remove(Object key) {
        int index = key.hashCode() % map.length;
        NodeMap current = map[index];
        NodeMap previous = null;

        while (current != null) {
            if (current.getKey().equals(key)) {
                if (previous == null) {
                    // Removing the first node in the linked list
                    map[index] = current.getNext();
                } else {
                    // Removing a node from the middle or end
                    previous.setNext(current.getNext());
                }
                size--;
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    class NodeMap {
        private Object value;
        private Object key;
        private NodeMap next;

        public NodeMap(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public NodeMap getNext() {
            return next;
        }

        public void setNext(NodeMap next) {
            this.next = next;
        }
    }
}
