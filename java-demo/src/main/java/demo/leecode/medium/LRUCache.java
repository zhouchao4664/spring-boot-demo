package demo.leecode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhouchao
 * @Date 2021/1/27 18:25
 * @Description
 **/

public class LRUCache {

    private int capacity = 1;
    private int size = 0;

    private Map<Integer, Node> map = new HashMap<>();

    Node firstNode = null;
    Node lastNode = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node n = map.get(key);

        if (n == firstNode) {
            return n.value;
        } else {
            Node nextNode = n.next;
            Node prevNode = n.prev;
            if (nextNode != null) nextNode.prev = prevNode;
            if (prevNode != null) prevNode.next = nextNode;
        }

        linkFirst(n);

        return n.value;
    }

    public void put(int key, int value) {
        Node newNode = null;

        if (map.containsKey(key)) {

            Node n = map.get(key);
            n.value = value;

            Node nextNode = n.next;
            Node prevNode = n.prev;
            if (nextNode != null) nextNode.prev = prevNode;
            if (prevNode != null) prevNode.next = nextNode;

            n.prev = null;
            n.next = null;

            newNode = n;
        } else {
            newNode = new Node(null, value, null);

            linkFirst(newNode);

            size++;
        }

        map.put(key, newNode);
        checkCapacity();
    }

    private void checkCapacity(){
        // 如果到达上限，去掉尾部节点
        if (size > capacity) {
            Node lastPrev = lastNode.prev;
            Node last = lastNode;
            last.prev = null;
            lastPrev.next = null;
            lastNode = lastPrev;

            map.remove(last);
            size--;
        }
    }

    private void linkFirst(Node node) {
        Node f = firstNode;
        firstNode = node;
        if (f == null) {
            lastNode = node;
        } else {
            node.prev = null;
            node.next = f;
            f.prev = node;
        }
    }

    private static class Node {
        int value;
        Node next;
        Node prev;

        Node(Node prev, int value, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
