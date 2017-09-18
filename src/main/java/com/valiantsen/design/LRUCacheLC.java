package main.java.com.valiantsen.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheLC {


    private int capacity;

    private Map<Integer, Node> map;

    private Node head;

    private Node tail;

    public LRUCacheLC(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            setHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            setHead(old);
            return;
        }
        Node node = new Node(key, value);
        setHead(node);
        if (map.size() == capacity) {
            map.remove(tail.key);
            removeTail();
        }
        map.put(key, node);

    }

    private void setHead(Node node) {
        if (node == head) {
            return;
        }
        if (head == null) {
            head = node;
            tail = node;
        } else {
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node == tail) {
                tail = node.pre;
            }
            node.next = head;
            head.pre = node;
            node.pre = null;
            head = node;
        }
    }

    private void removeTail() {
        if (tail != null) {
            if (tail.pre != null) {
                tail.pre.next = null;
            } else {
                head = null;
            }
            tail = tail.pre;
        }
    }

    public class Node {
        Node pre;

        Node next;

        int value;

        int key;

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LRUCacheLC cache = new LRUCacheLC(1);
        cache.put(2, 2);
        cache.get(2);
        cache.put(3, 3);
        cache.get(2);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */

