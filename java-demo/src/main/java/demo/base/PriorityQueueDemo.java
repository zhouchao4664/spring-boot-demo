package demo.base;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static PriorityQueue pq = new PriorityQueue<Integer>();

    public static void main(String[] args) {
        Integer[] num = {2,6,7,4,6,1,8,9};

        for (int i = 0; i < 10; i++) {
            pq.offer(num[i]);
        }
    }

}
