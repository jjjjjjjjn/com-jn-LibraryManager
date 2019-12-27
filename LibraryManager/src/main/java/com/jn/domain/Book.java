package com.jn.domain;

import java.util.List;

/**
 * @ClassName: Book
 * @Package: com.jn.domain
 * @Description:
 * @author：jn
 * @date： 2019/11/28 16:13
 */
public class Book {
    private long book_id;
    private String name;
    private String category;
    private String p_date;
    private String author;
    private String press;
    private int rest;
    private int lendtime;
    private int price;

    public Book() {
        super();
    }

    public Book(String name, String category, String author, String press) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.press = press;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", p_date='" + p_date + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", rest=" + rest +
                ", lendtime=" + lendtime +
                ", price=" + price +
                '}';
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getP_date() {
        return p_date;
    }

    public void setP_date(String p_date) {
        this.p_date = p_date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    public int getLendtime() {
        return lendtime;
    }

    public void setLendtime(int lendtime) {
        this.lendtime = lendtime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
