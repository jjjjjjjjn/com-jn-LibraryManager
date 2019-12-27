package com.jn.domain;

import java.util.List;

/**
 * @ClassName: User
 * @Package: com.jn.domain
 * @Description:
 * @author：jn
 * @date： 2019/11/29 15:14
 */
public class User {

    private long user_id;
    private String user_name;
    private String user_password;
    private float  money;
    private int  lnumber;

    public User(String user_name, String user_password, float money, int lnumber) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.money = money;
        this.lnumber = lnumber;
    }

    public User(long user_id, String user_name, String user_password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public User() {
        super();
    }



    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getLnumber() {
        return lnumber;
    }

    public void setLnumber(int lnumber) {
        this.lnumber = lnumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_password='" + user_password + '\'' +
                ", money=" + money +
                ", lnumber=" + lnumber +
                '}';
    }
}
