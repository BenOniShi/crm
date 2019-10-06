package com.shsxt.crm.enums;

/**
 * 开发状态枚举类
 */
public enum DevResultStatus {

    //未开发
    UN_DEV(0),
    //已开发
    DEVING(1),
    //开发中
    DEVSUCCESS(2),
    //开发失败
    DEV_FAILED(3);
    private Integer davStatus;

    DevResultStatus(Integer dev) {
        this.davStatus = dev;
    }

    public Integer getDev() {
        return davStatus;
    }
}
