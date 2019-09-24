package com.qf.common;

public class JsonResult {

    private Integer code;// 0 true, 1 false
    private Object info;// 具体信息

    public JsonResult() {
    }

    public JsonResult(Integer code, Object info) {
        this.code = code;
        this.info = info;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", info=" + info +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
