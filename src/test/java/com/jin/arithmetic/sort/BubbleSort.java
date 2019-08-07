package com.jin.arithmetic.sort;

/**
 * 冒泡排序
 *
 * @author jinpeng
 * @date 2019/7/24.
 */
public class BubbleSort extends SortService {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(getArray());
    }

    @Override
    public void sort(Comparable[] array) {
        int compNum = 0, swapNum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                Comparable a = array[i];
                Comparable b = array[j];
                if (less(b, a)) {
                    exch(array, i, j);
                    swapNum++;
                }
                compNum++;
            }
        }
        //System.out.println("冒泡排序 比较次数=" + compNum + " 交换次数=" + swapNum);
        show(array);
    }


}
