package com.xq.algorithm.basic.queue;

import java.util.Scanner;

/**
 * 队列Queue
 * FIFO-> 先进先出
 *
 * @author yangweiqiang 2019/9/24 18:01
 **/
public class QueueDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayQueue arrayQueue = new ArrayQueue(5);
        while (true) {
            String content = scanner.next();
            if (content.startsWith("add")) {
                arrayQueue.put(Integer.valueOf(content.substring(3, content.length()).trim()));

            }
            if ("list".equals(content)) {
                arrayQueue.list();
            }
            if ("pop".equals(content)) {
                System.out.println("pop=" + arrayQueue.pop() + ",popIndex=" + arrayQueue.popIndex);
                arrayQueue.list();
            }

        }

    }

    /**
     * 数组实现队列 FIFO
     */
    static class ArrayQueue {
        private int length = 10;//队列的容量
        private int count;//队列的数据大小
        private int[] item;
        private int popIndex = -1;//初始为-1
        private int putIndex = 0;//添加index

        public ArrayQueue(int length) {
            this.length = length;
            item = new int[length];
        }

        public boolean put(int val) {
            if (count >= length) {
                System.out.println("队列已满:length=" + length + ",count=" + count);
                return false;
            }

            item[putIndex] = val;
            putIndex++;
            count++;

            return true;
        }

        public int pop() {
            if (popIndex == putIndex - 1) {
                System.out.println("没有可以pop的数据了!");
                return -1;
            }

            popIndex++;
            return item[popIndex];
        }

        public void list() {
            for (int i = 0; i < count; i++) {
                System.out.println(item[i]);
            }
        }
    }
}
