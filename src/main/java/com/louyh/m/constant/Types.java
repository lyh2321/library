package com.louyh.m.constant;

/**
 * 搜索和收藏的业务类型
 *
 * @author songJian
 * @version 2018-6-5
 */
public enum Types {
    T0(0, "课程"),
    T1(1, "公告"),
    T2(2, "新闻"),
    T3(3, "动态"),
    T4(4, "banner外链"),
    T5(5, "帮助"),
    T6(6, "教学计划"),
    T7(7, "专题班"),
    T8(8, "考试信息"),
    T9(9, "分中心信息"),
    T10(10, "专栏"),
    T11(11, "专栏文章"),
    T66(66, "帖子信息");// T66是帖子被加入搜索里面的类型
    /**
     * 类型
     */
    private Integer code;
    /**
     * 编码信息描述
     */
    private String msg;

    // 构造函数
    Types(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 获取codes的msg
    public static Types getTypes(Integer code) {
        for (Types c : Types.values()) {
            if (c.getCode() == code) {
                return c;
            }
        }
        return null;
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
