package com.manager.crm.query;

import com.manager.base.BaseQuery;

public class OrderDetailsQuery extends BaseQuery {
    private  String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
