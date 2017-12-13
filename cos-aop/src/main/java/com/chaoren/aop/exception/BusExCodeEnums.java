package com.chaoren.aop.exception;

/**
 * @author yuedongfang
 * 使用枚举类型来封装异常码和异常信息
 */
public enum BusExCodeEnums {
    COS_EX_PD_ERROR(10001, "账号密码错误！"),
    COS_EX_VD_ERROR(10002, "验证码错误！"),
    COS_EX_UNF_ERROR(10003, "账号不存在！");

    private String msg;
    private int code;

    private BusExCodeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getCode() {
        return this.code;
    }

}