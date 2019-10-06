package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

public class UserQuery extends BaseQuery {
    private String userName;
    private String phone;
    private String mail;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
