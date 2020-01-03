package com.fh.common;

public class CommonServeer {
    private int succecc;
    private String msg;
    private Object data;

    public CommonServeer(int succecc, String msg, Object data) {
        this.succecc = succecc;
        this.msg = msg;
        this.data = data;
    }

    public CommonServeer() {
    }

    public CommonServeer(int succecc, String msg) {
        this.succecc = succecc;
        this.msg = msg;
    }

    public static CommonServeer success() {
        return new CommonServeer(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg());
    }

    public static CommonServeer error() {
        return new CommonServeer(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMsg());
    }

    public static CommonServeer success(Object data) {
        return new CommonServeer(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), data);
    }

    public static CommonServeer error(Object data) {
        return new CommonServeer(ResponseEnum.ERROR.getCode(), ResponseEnum.ERROR.getMsg(), data);
    }

    public static CommonServeer error(ResponseEnum responseEnum) {
        return new CommonServeer(responseEnum.getCode(), responseEnum.getMsg());
    }

    public int getSuccecc() {
        return succecc;
    }

    public void setSuccecc(int succecc) {
        this.succecc = succecc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
