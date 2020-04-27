/*********************************************************************************
 * Copyright (c) 2020 中电健康云科技有限公司
 * 版本      DATE                 BY             REMARKS
 * ----  -----------  ---------------  ------------------------------------------
 * 1.0    2020/4/27      zhh           init.
 ********************************************************************************/
package Queues;

/**
 * @Description: 使用数组实现单向队列
 * @Author: zhh
 * @Date: 2020/4/27
 */
public class ArrayQueue {
    private String[] items;
    private int n;
    private int head;
    private int tail;

    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    public boolean enquque(String item){
      if(tail == n){
          if(head == 0){
              return false;
          }
          for (int i = head; i < tail; i++) {
              items[i-head] = items[i];
          }
          tail = tail - head;
          head = 0;
      }
      items[tail] = item;
      tail++;
      return true;
    }

    public String dequeue(){
        if(head == tail){
            return null;
        }
        return items[head++];
    }
}
