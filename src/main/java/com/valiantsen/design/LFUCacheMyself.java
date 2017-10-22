package main.java.com.valiantsen.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUCacheMyself {

    private Node tail;

    private Map<Integer, Node> map;

    private Map<Integer, Integer> valueMap;

    private int capacity;

    public LFUCacheMyself(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        valueMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (valueMap.containsKey(key)) {
            increaseCount(key);
            return valueMap.get(key);
        }
        return -1;
    }

    private void increaseCount(int key) {
        removeKey(key);
        Node now = map.get(key);
        int count = now.count + 1;
        if (now.pre != null && now.pre.count == count) {
            setHead(now.pre, key);
            map.put(key, now.pre);
        } else {
            Node fresh = new Node(count);
            fresh.keys.addFirst(key);
            fresh.pre = now.pre;
            if (now.pre != null) {
                now.pre.next = fresh;
            }
            now.pre = fresh;
            fresh.next = now;

            map.put(key, fresh);
        }
        if (now.keys.isEmpty()) {
            if (now == tail) {
                tail = now.pre;
            }
            now.pre.next = now.next;
        }
    }

    public void put(int key, int value) {
        if (capacity < 1)
            return;
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
        }
        if (valueMap.size() == capacity) {
            removeTail();
        }
        addTail(key, value);
    }

    private void removeTail() {
        if (tail.keys.size() > 1) {
            int key = tail.keys.removeLast();
            removeHash(key);
        } else {
            removeHash(tail.keys.getFirst());
            if (tail.pre != null)
                tail.pre.next = tail.next;
            tail = tail.pre;
        }
    }

    private void addTail(int key, int value) {
        if (tail != null && tail.count == 0) {
            tail.keys.addFirst(key);
            map.put(key, tail);
        } else {
            Node now = new Node(0);
            now.keys.addFirst(key);
            if (tail != null) {
                tail.next = now;
            }
            now.pre = tail;
            tail = now;
            map.put(key, now);
        }
        valueMap.put(key, value);
    }

    private void removeHash(int key) {
        map.remove(key);
        valueMap.remove(key);
    }

    private void removeKey(int key) {
        Node now = map.get(key);
        now.keys.remove(new Integer(key));
    }

    private void setHead(Node node, int key) {
        node.keys.addFirst(key);
    }


    class Node {
        public int count;

        public LinkedList<Integer> keys;

        Node pre, next;

        public Node(int count) {
            this.count = count;
            keys = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        LFUCacheMyself lfu = new LFUCacheMyself(1);
        lfu.put(2, 1);
        System.out.println(lfu.get(2));
        lfu.put(3, 2);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
    }
}
