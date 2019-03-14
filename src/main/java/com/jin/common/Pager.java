package com.jin.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinpeng
 * @date 2019/3/14.
 */
@SuppressWarnings("unused")
public class Pager<T> {

    private int cpage = 1;// 当前页数

    private Long totalItem = 1L;// 总共条数

    private Long totalPage = 1L;// 总页�?

    private int pageSize = 10;// 每页显示条数

    private int nextPage;// 下一�?

    private int previousPage;// 上一�?

    private boolean hasNextPage;// 是否有下�?�?

    private boolean hasPreviouPage;// 是否有上�?�?

    private boolean hasFirstPage;// 是否有最前页

    private boolean hasEndPage;// 是否有最后页

    private List<T> list;// 现实的具体内�?

    private List<Integer> pages = new ArrayList<Integer>(); // 当前�? �?4页后5 页号�?

    private Long pageStart;// 当前页开始记�?

    public Long getPageStart() {

        return pageStart;
    }

    public void setPageStart(Long pageStart) {
        this.pageStart = pageStart;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    /**
     * @return Returns the hasendpage.
     */
    public boolean isHasEndPage() {
        return hasEndPage;
    }

    /**
     * @param
     *
     */
    public void setHasEndPage(boolean hasendPage) {
        this.hasEndPage = hasendPage;
    }

    /**
     * @return Returns the hasfristpage.
     */
    public boolean isHasFristPage() {
        return hasFirstPage;
    }

    /**
     * @param
     *
     */
    public void setHasFirstPage(boolean hasFirstPage) {
        this.hasFirstPage = hasFirstPage;
    }

    public boolean getHasNextPage() {
        if (cpage < totalPage) {
            return true;
        }
        return false;
    }

    public void setHasNextPage(boolean hasnextPage) {
        this.hasNextPage = hasnextPage;
    }

    public boolean isHasPreviouPage() {
        if (cpage != 1) {
            return true;
        }
        return false;
    }

    public void setHasPreviouPage(boolean hasPreviouPage) {
        this.hasPreviouPage = hasPreviouPage;
    }

    public int getPageSize() {
        if (pageSize <= 0) {
            return 10;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCpage() {
        if (cpage < 1) {
            return 1;
        }
        return cpage;
    }

    public void setCpage(int cpage) {

        this.cpage = cpage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getNextPage() {

        if (getHasNextPage()) {
            return cpage + 1;
        }
        return cpage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPreviousPage() {
        if (isHasPreviouPage()) {
            return cpage - 1;
        }
        return cpage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public Long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Long totalitem) {
        this.totalItem = totalitem;
        if (pageSize > 0) {
            totalPage = totalItem % pageSize > 0 ? totalItem / pageSize + 1 : totalItem / pageSize;
        }
        if (this.getCpage() > totalPage && totalPage != null) {
            this.setCpage(totalPage.intValue());
        }
        if(cpage>totalPage)cpage=totalPage.intValue();
        pageStart = Long.parseLong((getCpage() - 1) * getPageSize() + "");

        int start = getCpage() - 4 < 1 ? 1 : getCpage() - 4;
        long end = this.getCpage() + 5 > this.getTotalPage() ? this.getTotalPage()
                : this.getCpage() + 5;
        for (int i = start; i <= end; i++) {
            pages.add(i);
        }

    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }
}
