package com.leetcode.Companies.GoldmanSachs;

import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    static class Node {
        private int key;
        private int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return this.key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getVal() {
            return this.val;
        }
    }

    static class Bucket {
        private final List<Node> bucket;

        public Bucket() {
            bucket = new ArrayList<>();
        }

        public int get(int key) {
            for (Node node : bucket) {
                if (node.getKey() == key) {
                    return node.val;
                }
            }
            return -1;
        }

        public void put(int key, int val) {
            //check if exists and update
            boolean found = false;
            for (Node n : bucket) {
                if (n.key == key) {
                    n.val = val;
                    found = true;
                }
            }

            //if it doesnt exist, then add
            if (!found) {
                bucket.add(new Node(key, val));
            }
        }

        public void remove(int key) {
            Node target = null;

            for (Node node : bucket) {
                if (node.key == key) {
                    target = node;
                    break;
                }
            }
            if (target != null) {
                bucket.remove(target);
            }
        }
    }


    private final int KEY_SPACE = 2048;
    private final List<Bucket> map;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        map = new ArrayList<>();
        for (int i = 0; i < KEY_SPACE; i++) {
            map.add(new Bucket());
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int bucketNumber = getBucketNumber(key);
        map.get(bucketNumber).put(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int bucketNumber = getBucketNumber(key);
        return map.get(bucketNumber).get(key);

    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int bucketNumber = getBucketNumber(key);
        map.get(bucketNumber).remove(key);
    }

    public int getBucketNumber(int key) {
        return Integer.hashCode(key) % KEY_SPACE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
