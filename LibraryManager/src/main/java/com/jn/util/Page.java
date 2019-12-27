package com.jn.util;


public class Page {
    private int pageNo;//当前页
    public static int pageCount = 10;//每页多少条记录
    private int pageSize;//一共有多少页
    private int total;//记录总数

    public Page() {
        super();
    }

    public int getSkipCount() {

        return (pageNo - 1) * pageCount;

    }

    public Page(int pageNo, int total) {


        pageSize = total / pageCount;
        if (total % pageCount > 0) {
            pageSize++;
        }
        this.pageNo = pageNo;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", total=" + total +
                '}';
    }

    public static int getPageCount() {
        return pageCount;
    }

    public static void setPageCount(int pageCount) {
        Page.pageCount = pageCount;
    }

    /**
     * @return the pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

}
