package com.jin.arithmetic.sort;

/**
 * @author jinpeng
 * @date 2019/7/31.
 */
public class SortAdapt {
    private SortService sortService;

    public SortAdapt(SortService sortService) {
        this.sortService = sortService;
    }

    public void exe(Comparable[] arr) {
        Long time = System.currentTimeMillis();
        sortService.sort(arr);
        Long expendTime = System.currentTimeMillis() - time;
        System.out.println("时间=" + expendTime);
        sortService.show(arr);
    }
}
