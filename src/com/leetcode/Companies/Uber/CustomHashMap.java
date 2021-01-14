package com.leetcode.Companies.Uber;

import java.util.Objects;

public class CustomHashMap<K, V> {
    int n = 16;

    class Node<K, V> {
        private final K key;
        private V value;
        private int hashCode;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public int hashCode(K key) {
            return Objects.hashCode(key) & n - 1;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }

    Node<K, V>[] table = new Node[n];

    public Node<K, V> get(K key) {
        int index = Objects.hashCode(key) & n - 1;

        Node<K, V> node = table[index];
        while (node.next != null) {
            if (node.getKey().equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int index = Objects.hashCode(key) & n - 1;
        Node<K, V> head = table[index];
        Node<K, V> node = head;
        boolean found = false;
        //check if it exists
        while (node != null) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                found = true;
                break;
            }
            node = node.next;
        }

        if (!found) {
            //insert at the end of the linkedLIst
            while (head != null && head.next != null) head = head.next;
            head.next = new Node<>(key, value);
        }
    }


}
