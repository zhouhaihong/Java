/*********************************************************************************
 * Copyright (c) 2020 中电健康云科技有限公司
 * 版本      DATE                 BY             REMARKS
 * ----  -----------  ---------------  ------------------------------------------
 * 1.0    2020/4/27      zhh           init.
 ********************************************************************************/
package Queues;

/**
 * @Description:
 * @Author: zhh
 * @Date: 2020/4/27
 */
public class ArrayCircularQueue {

    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayCircularQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item){
        if((tail +1)%n == head){
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue(){
        if(head == tail){
            return null;
        }
        String item = items[head];
        head = (head + 1) % n;
        return item;
    }

}
