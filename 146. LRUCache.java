/*

Link : https://leetcode.com/problems/lru-cache/

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.

put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:
LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/




class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    Node head;
    Node tail;
    int cap;
    HashMap<Integer, Node> map = null;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        
        Node temp = map.get(key);
        
        removeNode(temp);
        addNode(temp);
        
        return temp.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            
            removeNode(temp);
            addNode(temp);
        }
        else {
            if (map.size() >= cap) {
                map.remove(head.key);
                removeNode(head);
            }
            Node temp = new Node(key, value);
            addNode(temp);
            map.put(key, temp);
        }
    }
    
    public void removeNode(Node temp) {
        if (temp.prev != null)
            temp.prev.next = temp.next;
        else
            head = temp.next;
        
        if (temp.next != null)
            temp.next.prev = temp.prev;
        else
            tail = temp.prev;
        
    }
    
    public void addNode(Node temp) {
        if (tail != null)
            tail.next = temp;
        
        temp.prev = tail;
        temp.next = null;
        tail = temp;
        
        if (head == null)
            head = tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */