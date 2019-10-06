package com.shsxt.crm.query;

import com.shsxt.base.BaseQuery;

public class OrderQuery extends BaseQuery {
    private Integer cid;
    private Integer OrderNo;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(Integer orderNo) {
        OrderNo = orderNo;
    }
}
