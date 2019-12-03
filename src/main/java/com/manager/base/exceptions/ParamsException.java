package com.manager.base.exceptions;

import com.manager.base.constants.CrmConstant;

/**
 * 自定义异常类
 *        构造方法
 *          new ParamsException 的时候   将code 和 msg传进来    程序结束运行
 *
 */
public class ParamsException extends RuntimeException {

    /**
     * Code  msg 是 CrmConstant 中定义的常量
     *
     */
    private Integer code = CrmConstant.FAILED_CODE;
    private String  msg =CrmConstant.FAILED_MSG;

    public ParamsException(Integer code) {
        super(CrmConstant.FAILED_MSG);
        this.code = code;
    }

    public ParamsException(String msg) {
        super(msg);
        this.msg = msg;
    }


    public ParamsException() {
        super(CrmConstant.FAILED_MSG);
    }

    public ParamsException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
