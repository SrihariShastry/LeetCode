package com.leetcode.Companies.Uber;

import java.util.HashMap;

class LRUCache {

    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }

    public void add(Node node) {

        Node headNext = head.next;

        node.prev = head;
        node.next = headNext;

        head.next = node;
        headNext.prev = node;

        cache.put(node.key, node);

    }

    public void remove(Node node) {

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        //remove from hashmap
        cache.remove(node.key);

    }

    public int get(int key) {
        int result = -1;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            result = node.value;
            remove(node);
            add(node);
        }
        return result;

    }

    public void put(int key, int value) {
        //check if already existing. if yes then overwrite the value and move the node to head;
        // if not present, then check the capacity
        //if the size of the cache is equal to capacity,
        //then remove tail node and add the new node to head

        Node node;
        if (cache.containsKey(key)) {
            node = cache.get(key);
            remove(node);
            node.value = value;
        } else {
            node = new Node();
            node.key = key;
            node.value = value;

            if (cache.size() == capacity) {
                remove(tail.prev);
            }
        }
        add(node);

    }

    class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node() {
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
