package com.manager.crm.query;

import com.manager.base.BaseQuery;
@SuppressWarnings("all")
public class SaleChanceQuery extends BaseQuery {
    private String customerName;  //客户名称
    private String createMan;     //创建人
    private Integer state;        //分配状态 0 -未分配  1 已分配
    //分配人
    private String assignMan;

    public String getAssignMan() {
        return assignMan;
    }

    public void setAssignMan(String assignMan) {
        this.assignMan = assignMan;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
