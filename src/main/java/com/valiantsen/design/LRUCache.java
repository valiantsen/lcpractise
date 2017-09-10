package main.java.com.valiantsen.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {

    private Node head = null;

    private Node tail = null;

    private int capacity;

    private Map<Integer, Node> nodeMap = new HashMap<>(capacity);


    public T get(int key) {
        if (nodeMap.containsKey(key)) {
            Node now = nodeMap.get(key);
            // set to head
            if (head != now) {
                remove(now);
                setHead(now);
            }
            return now.object;
        }
        return null;
    }

    public void add(int key, T obj) {
        Node now = new Node(key, obj, null, null);
        if (nodeMap.size() < capacity) {
            setHead(now);
        } else {
            nodeMap.remove(tail.key);
            remove(tail);
            setHead(now);
        }
        nodeMap.put(key, now);
    }


    private void remove(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    private void setHead(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            head.pre = node;
            node.next = head;
            node.pre = null;
            head = node;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }



    public class Node {
        Integer key;

        T object;

        Node pre;

        Node next;

        public Node() {

        }

        public Node(Integer key, T obj, Node pre, Node next) {
            this.key = key;
            this.object = obj;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer> cache = new LRUCache<>(3);
        cache.add(1, 1);
        cache.add(2, 2);
        cache.add(3, 3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(1));
        cache.add(4, 4);

    }
}
