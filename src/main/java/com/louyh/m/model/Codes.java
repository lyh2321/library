package com.louyh.m.model;

/**
 * 信息集
 *
 * @author songJian
 * @version 2018-3-27
 */
public enum Codes {

    /**
     * 成功信息
     */
    OK(true, "10000", "操作成功"),
    LOGIN_OK(true, "10001", "登录成功"),
    STATUS_0(true, "10002", "已删除"),
    STATUS_1(true, "10003", "已启用"),
    STATUS_2(true, "10004", "已停用"),

    /**
     * 失败信息
     */
    FAIL(false, "20000", "操作失败"),
    LOGIN_FAIL(false, "20001", "登录失败，请检查用户名或密码是否正确"),
    USERINFO_STOP(false, "20002", "本用户已停用"),
    USERINFO_NO_ADMIN(false, "20003", "本用户非管理员");

    /**
     * 标识成功或失败
     */
    private boolean result;
    /**
     * 编码信息
     */
    private String code;
    /**
     * 编码信息描述
     */
    private String msg;

    // 构造函数
    private Codes(boolean result, String code, String msg) {
        this.result = result;
        this.code = code;
        this.msg = msg;
    }

    // 获取codes的msg
//    public static String getMsg(String code) {
//        for (Codes c : Codes.values()) {
//            if (c.getCode().equals(code)) {
//                return c.msg;
//            }
//        }
//        return null;
//    }


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
