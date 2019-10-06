package com.shsxt.crm.enums;

import sun.dc.pr.PRError;

/**
 * 分配状态枚举类
 */
public enum StateStatus {
    //已分配  stated  1
    STATED(1),
    //UN_STATED  未分配  0
    UN_STATED(0);

    private  Integer state;

    StateStatus(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }
}
