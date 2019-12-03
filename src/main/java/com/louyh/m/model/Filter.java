package com.louyh.m.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询条件类
 *
 * @author songJian
 * @version 2018-3-27
 */
public class Filter {

    public static final int OP_EQUAL = 0;
    public static final int OP_NOT_EQUAL = 1;
    public static final int OP_LESS_THAN = 2;
    public static final int OP_GREATER_THAN = 3;
    public static final int OP_LESS_OR_EQUAL = 4;
    public static final int OP_GREATER_OR_EQUAL = 5;
    public static final int OP_LIKE = 6;
    public static final int OP_NULL = 10;
    public static final int OP_NOT_NULL = 11;
    public static final int OP_EMPTY = 12;
    public static final int OP_NOT_EMPTY = 13;
    public static final int OP_AND = 100;
    public static final int OP_OR = 101;

    public static final String OR = "OR";
    public static final String AND = "AND";

    private String property;// 字段
    private Object value;// 值
    private int operator;// 类型

    public Filter(String property, Object value, int operator) {
        this.property = property;
        this.value = value;
        this.operator = operator;
    }

    /**
     * Create a new Filter using the == operator.
     */
    public static Filter equal(String property, Object value) {
        return new Filter(property, value, OP_EQUAL);
    }

    /**
     * Create a new Filter using the < operator.
     */
    public static Filter lessThan(String property, Object value) {
        return new Filter(property, value, OP_LESS_THAN);
    }

    /**
     * Create a new Filter using the > operator.
     */
    public static Filter greaterThan(String property, Object value) {
        return new Filter(property, value, OP_GREATER_THAN);
    }

    /**
     * Create a new Filter using the <= operator.
     */
    public static Filter lessOrEqual(String property, Object value) {
        return new Filter(property, value, OP_LESS_OR_EQUAL);
    }

    /**
     * Create a new Filter using the >= operator.
     */
    public static Filter greaterOrEqual(String property, Object value) {
        return new Filter(property, value, OP_GREATER_OR_EQUAL);
    }

    /**
     * Create a new Filter using the != operator.
     */
    public static Filter notEqual(String property, Object value) {
        return new Filter(property, value, OP_NOT_EQUAL);
    }

    /**
     * Create a new Filter using the LIKE operator.
     */
    public static Filter like(String property, String value) {
        return new Filter(property, value, OP_LIKE);
    }

    /**
     * Create a new Filter using the IS NULL operator.
     */
    public static Filter isNull(String property) {
        return new Filter(property, true, OP_NULL);
    }

    /**
     * Create a new Filter using the IS NOT NULL operator.
     */
    public static Filter isNotNull(String property) {
        return new Filter(property, true, OP_NOT_NULL);
    }

    /**
     * Create a new Filter using the IS EMPTY operator.
     */
    public static Filter isEmpty(String property) {
        return new Filter(property, true, OP_EMPTY);
    }

    /**
     * Create a new Filter using the IS NOT EMPTY operator.
     */
    public static Filter isNotEmpty(String property) {
        return new Filter(property, true, OP_NOT_EMPTY);
    }

    public void add(Filter filter) {
        if (value == null || !(value instanceof List)) {
            value = new ArrayList();
        }
        ((List) value).add(filter);
    }

    public static Filter and(Filter... filters) {
        Filter filter = new Filter(Filter.AND, null, OP_AND);
        for (Filter f : filters) {
            filter.add(f);
        }
        return filter;
    }

    public static Filter or(Filter... filters) {
        Filter filter = and(filters);
        filter.property = Filter.OR;
        filter.operator = OP_OR;
        return filter;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }
}
