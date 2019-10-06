package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

public class CustomerQuery extends BaseQuery {

    private String khno;

    private String name;

    private String level;


    public String getKhno() {
        return khno;
    }

    public void setKhno(String khno) {
        this.khno = khno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}



