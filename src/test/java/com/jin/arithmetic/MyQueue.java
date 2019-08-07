package com.jin.arithmetic;

/**
 * 队列 FIFO
 *
 * @author jinpeng
 * @date 2019/7/24.
 */
public class MyQueue<E> {

    private Node<E> node;
    private Node<E> lastNode;
    public Integer size = 0;


    /**
     * 每次插入新元素从头部插入
     *
     * @param item
     */
    public void add(E item) {
        Node<E> oldFirst = this.node;
        this.node = new Node<>();
        this.node.item = item;
        this.node.next = oldFirst;

        if (oldFirst != null) {
            oldFirst.last = this.node;
        }
        size++;
        if (lastNode == null) {
            if (size == 1) {
                lastNode = this.node;
            } else {
                lastNode = oldFirst;
            }
        }
    }

    /**
     * 从尾部取元素
     *
     * @return
     */
    public E pop() {
        E item = lastNode.item;
        Node<E> last2 = lastNode.last;
        if (last2 == null) {
            this.lastNode = null;
        } else {
            last2.next = null;
        }
        this.lastNode = last2;
        size--;
        return item;
    }


}
