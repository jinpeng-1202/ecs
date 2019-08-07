package com.jin.arithmetic;

/**
 * @author jinpeng
 * @date 2019/7/24.
 */
public class MyStack<E> {

    private Node<E> node;
    public Integer size=0;


    public void add(E item) {
        Node<E> oldFirst = this.node;
        this.node = new Node<>();
        this.node.item = item;
        this.node.next = oldFirst;
        size++;
    }

    public E pop() {
        Node<E> newFirst = this.node.next;
        E item = this.node.item;
        //this.node.next=this.node;
        this.node = newFirst;
        size--;
        return item;
    }

}
