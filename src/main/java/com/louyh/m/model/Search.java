package com.louyh.m.model;

import com.google.common.collect.Lists;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * 查询类
 * <p>
 * 主要用作：
 * 1.存储查询条件和排序信息（filters和Sort）
 * 2.存储翻页信息（pageRequest）
 * 3.存储JPA的Specification信息
 * 4.简单的集成Filter对象的部分功能
 *
 * @author songJian
 * @version 2018-3-27
 */
public class Search {

    private List<Filter> filters = Lists.newArrayList();// 查询条件集合
    private PageRequest pageRequest;// 分页
    private Specification specification;// JPA的 条件+排序 类
    private List<Sort> sorts = Lists.newArrayList();// 排序信息集合
    private Integer pageNum = -1;// 1开始
    private Integer pageSize = -1;

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public Specification getSpecification() {
        WebHelper.getSearchSp(this);
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public List<Sort> getSorts() {
        return sorts;
    }

    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Search addSortAsc(String name) {
        Sort sort = new Sort(name, Sort.ASC);
        this.sorts.add(sort);
        return this;
    }

    public Search addSortDesc(String name) {
        Sort sort = new Sort(name, Sort.DESC);
        this.sorts.add(sort);
        return this;
    }

    private Search addFilters(String property, Object value, Integer operator) {
        Filter filter = new Filter(property, value, operator);
        this.filters.add(filter);
        return this;
    }

    /**
     * Add a new Filter using the == operator.
     */
    public Search addEqual(String property, Object value) {
        addFilters(property, value, Filter.OP_EQUAL);
        return this;
    }

    /**
     * Add a new Filter using the != operator.
     */
    public Search addNotEqual(String property, Object value) {
        addFilters(property, value, Filter.OP_NOT_EQUAL);
        return this;
    }

    /**
     * Add a new Filter using the like operator.
     */
    public Search addLike(String property, Object value) {
        addFilters(property, value, Filter.OP_LIKE);
        return this;
    }

    /**
     * Add a new Filter using the < operator.
     */
    public Search addLessThan(String property, Object value) {
        addFilters(property, value, Filter.OP_LESS_THAN);
        return this;
    }

    /**
     * Add a new Filter using the > operator.
     */
    public Search addGreaterThan(String property, Object value) {
        addFilters(property, value, Filter.OP_GREATER_THAN);
        return this;
    }

    /**
     * Add a new Filter using the <= operator.
     */
    public Search addLessOrEqual(String property, Object value) {
        addFilters(property, value, Filter.OP_LESS_OR_EQUAL);
        return this;
    }

    /**
     * Add a new Filter using the >= operator.
     */
    public Search addGreaterOrEqual(String property, Object value) {
        addFilters(property, value, Filter.OP_GREATER_OR_EQUAL);
        return this;
    }

    /**
     * Create a new Filter using the IS NULL operator.
     */
    public Search addIsNull(String property) {
        addFilters(property, true, Filter.OP_NULL);
        return this;
    }

    /**
     * Create a new Filter using the IS NOT NULL operator.
     */
    public Search addIsNotNull(String property) {
        addFilters(property, true, Filter.OP_NOT_NULL);
        return this;
    }

    /**
     * Create a new Filter using the IS EMPTY operator.
     */
    public Search addIsEmpty(String property) {
        addFilters(property, true, Filter.OP_EMPTY);
        return this;
    }

    /**
     * Create a new Filter using the IS NOT EMPTY operator.
     */
    public Search addIsNotEmpty(String property) {
        addFilters(property, true, Filter.OP_NOT_EMPTY);
        return this;
    }

    /**
     * @param property
     * @param value
     * @param type     本type对应于Filter中 OP_* 的信息
     */
    public Search other(String property, Object value, Integer type) {
        addFilters(property, value, type);
        return this;
    }

    public void and(Filter... filters) {
        Filter filter = new Filter(Filter.AND, null, Filter.OP_AND);
        for (Filter f : filters) {
            filter.add(f);
        }
        this.filters.add(filter);
    }

    public void or(Filter... filters) {
        Filter filter = new Filter(Filter.OR, null, Filter.OP_AND);
        for (Filter f : filters) {
            filter.add(f);
        }
        this.filters.add(filter);
    }
}
