package com.jn.domain;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: Record
 * @Package: com.jn.domain
 * @Description:
 * @author：jn
 * @date： 2019/12/2 19:49
 */
public class Record {
    private long re_id;
    private long user_id;
    private long book_id;
    private String lend_data;
    private String return_data;
    private float cost;
    private List<Book> bookList;

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


    public long getRe_id() {
        return re_id;
    }

    public void setRe_id(long re_id) {
        this.re_id = re_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getLend_data() {
        return lend_data;
    }

    public void setLend_data(String lend_data) {
        this.lend_data = lend_data;
    }

    public String getReturn_data() {
        return return_data;
    }

    public void setReturn_data(String return_data) {
        this.return_data = return_data;
    }

    @Override
    public String toString() {
        return "Record{" +
                "re_id=" + re_id +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", lend_data='" + lend_data + '\'' +
                ", return_data='" + return_data + '\'' +
                ", cost=" + cost +
                ", bookList=" + bookList +
                '}';
    }
}
