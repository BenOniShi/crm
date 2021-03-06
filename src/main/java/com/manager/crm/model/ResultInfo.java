package com.manager.crm.model;

import com.manager.base.constants.CrmConstant;

public class ResultInfo {
    private Integer code = CrmConstant.SUCCESS_CODE;
    private String msg = CrmConstant.SUCCESS_MSG;

    private Object result;


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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }



}
