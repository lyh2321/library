package com.louyh.m.model;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;

public class WebHelper {

    private static final String NAME_PREFIX = "f-";
    private static final String VALUE_PREFIX = "fo-";

    public static Search getSearch(Search search) {
        return getSearch(search, null);
    }

    // 分页查询之前调用
    public static Search getSearch(Search search, Map<String, String[]> params) {
        Integer page = 1;
        Integer limit = 10;
        if (params != null) {
            List<String[]> paramList = filterSearchParams(params);
            if (paramList != null) {
                for (String[] param : paramList) {
                    String name = param[0];
                    String value = param[1];
                    if (name.startsWith(NAME_PREFIX)) {
                        if (search == null) search = new Search();
                        int op = -1;
                        String opString = VALUE_PREFIX + name.substring(2);
                        for (String[] p2 : paramList) {
                            if (p2[0].equals(opString)) {
                                op = Integer.parseInt(p2[1]);
                                break;
                            }
                        }
                        switch (op) {
                            case 0:
                                search.addEqual(name.substring(2), value);
                                break;
                            case -1:
                                search.addLike(name.substring(2), "%" + value + "%");
                                break;
                            case 7:
                                search.addLike(name.substring(2), value + "%");
                                break;
                            default:
                                search.other(name.substring(2), value, op);
                                break;
                        }
                    }
                }
            }
            // 实现分页
            String[] spage = params.get("page");
            String[] slimit = params.get("limit");
            if (spage != null && spage.length > 0) {
                try {
                    page = Integer.valueOf(spage[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                    page = 1;
                }
            }
            if (slimit != null && slimit.length > 0) {
                try {
                    limit = Integer.valueOf(slimit[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                    limit = 10;
                }
            }
        }
        if (search.getPageNum() != -1) {
            page = search.getPageNum();
        }
        if (search.getPageSize() != -1) {
            limit = search.getPageSize();
        }
        search.setPageRequest(new PageRequest(page - 1, limit));// 分页
        search.setSpecification(createSpecification(search.getFilters(), search.getSorts()));// 条件查询和分页
        return search;
    }

    public static Search getSearchSp(Search search) {
        search.setSpecification(createSpecification(search.getFilters(), search.getSorts()));
        return search;
    }

    private static String splicingParams(Map<String, String[]> params) {
        String search = "";
        if (params.containsKey("search")) {
            search = params.get("search")[0];// 来自layui的搜索信息
        }
        for (String name_n : params.keySet()) {// 来自链接中的搜索信息
            if (name_n.indexOf(NAME_PREFIX) != -1) {
                String attr = name_n.split("-")[1];
                String name_v = params.get(name_n)[0];
                String value_n = VALUE_PREFIX + attr;
                String value_v = params.get(value_n)[0];
                search += ("&" + name_n + "=" + name_v + "&" + value_n + "=" + value_v);
            }
        }
        return search;
    }

    /**
     * 只获取f-的条件查询信息
     *
     * @param params
     * @return
     */
    private static List<String[]> filterSearchParams(Map<String, String[]> params) {
        List<String[]> results = Lists.newArrayList();
        String search = splicingParams(params);// 整合查询信息
        // Filters
        String[] filters = search.split("&");
        for (String item : filters) {
            if (item.startsWith(NAME_PREFIX) && item.length() > 2) {
                String[] spec = item.split("=");
                String name = spec[0].replace(NAME_PREFIX, "");
                if (spec.length < 2) {
                    continue;
                }
                results.add(new String[]{spec[0], spec[1]});
                for (String ite : filters) {
                    if(StringUtils.isBlank(ite))continue;
                    String[] spec_ = ite.split("=");
                    if ((VALUE_PREFIX + name).equals(spec_[0])) {
                        results.add(new String[]{spec_[0], spec_[1]});
                        break;
                    }
                }
            }
        }
        return results;
    }

    /**
     * 根据search中的 List<Filter> filters和List<Sort> sorts 创建 JPA 的 Specification 查询对象
     *
     * @param filters
     * @return
     */
    private static Specification createSpecification(List<Filter> filters, List<Sort> sorts) {
        Specification spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                List<Predicate> listPredicate = Lists.newArrayList();
                for (Filter f : filters) {
                    Predicate p = null;
                    String property = f.getProperty();
                    if (Filter.OR.equals(property) || Filter.AND.equals(property)) {
                        p = createPredicates(f, root, cb, property.equals(Filter.OR) ? 2 : 1);
                    } else {
                        p = createPredicate(f, root, cb);
                    }
                    listPredicate.add(p);
                }
                Predicate[] pre = new Predicate[listPredicate.size()];
                query.where(cb.and(listPredicate.toArray(pre)));
                // 排序
                for (Sort s : sorts) {
                    query.orderBy(createOrder(s, root, cb));
                }
//                query.orderBy(cb.desc(root.get("createDate")));
                return query.getRestriction();
            }
        };
        return spec;
    }

    /**
     * 对条件进行组合
     *
     * @param filter
     * @param root
     * @param cb
     * @param type   1-AND 2-OR
     * @return
     */
    private static Predicate createPredicates(Filter filter, Root root, CriteriaBuilder cb, Integer type) {
        List<Predicate> listPredicate = Lists.newArrayList();
        for (Filter o : (List<Filter>) filter.getValue()) {
            Predicate p = null;
            if (Filter.OR.equals(o.getProperty())) {
                p = createPredicates(o, root, cb, 2);// 若是OR，则进行递归
            } else if (Filter.AND.equals(o.getProperty())) {
                p = createPredicates(o, root, cb, 1);// 若是AND，则进行递归
            } else {
                p = createPredicate(o, root, cb);
            }
            listPredicate.add(p);
        }
        Predicate[] pre = new Predicate[listPredicate.size()];
        if (type == 1) {
            return cb.and(listPredicate.toArray(pre));
        } else if (type == 2) {
            return cb.or(listPredicate.toArray(pre));
        } else {
            return null;
        }
    }

    /**
     * 排序拼接
     */
    private static Order createOrder(Sort sort, Root root, CriteriaBuilder cb) {
        Order order = null;
        Path path = getPath(root, sort.getCname());
        switch (sort.getCorder()) {
            case Sort.ASC:
                order = cb.asc(path);
                break;
            case Sort.DESC:
                order = cb.desc(path);
                break;
        }
        return order;
    }

    /**
     * 条件拼接(AND)
     * TODO：缺少in和notin（2018-03-27）
     *
     * @param filter
     * @param root
     * @param cb
     * @return
     */
    private static Predicate createPredicate(Filter filter, Root root, CriteriaBuilder cb) {
        Predicate p = null;
        Path path = getPath(root, filter.getProperty());
        Object o = filter.getValue();
        switch (filter.getOperator()) {
            case Filter.OP_EQUAL:
                p = cb.equal(path, o);
                break;
            case Filter.OP_NOT_EQUAL:
                p = cb.notEqual(path, o);
                break;
            case Filter.OP_LESS_THAN:
                p = cb.lessThan(path, o.toString());
                break;
            case Filter.OP_GREATER_THAN:
                p = cb.greaterThan(path, o.toString());
                break;
            case Filter.OP_LESS_OR_EQUAL:
                p = cb.lessThanOrEqualTo(path, o.toString());
                break;
            case Filter.OP_GREATER_OR_EQUAL:
                p = cb.greaterThanOrEqualTo(path, o.toString());
                break;
            case Filter.OP_LIKE:
                p = cb.like(path, o.toString());
                break;
            case Filter.OP_NULL:
                p = cb.isNull(path);
                break;
            case Filter.OP_NOT_NULL:
                p = cb.isNotNull(path);
                break;
            case Filter.OP_EMPTY:
                p = cb.isEmpty(path);
                break;
            case Filter.OP_NOT_EMPTY:
                p = cb.isNotEmpty(path);
                break;
        }
        return p;
    }

    /**
     * 根据.号分隔的字段信息，获取关联对象信息
     *
     * @param root
     * @param property
     * @return
     */
    private static Path getPath(Root root, String property) {
        int flag = property.indexOf(".");
        if (flag == -1) {
            return root.get(property);
        } else {
            String[] attr = property.split("\\.");
            Join join = root.join(attr[0], JoinType.LEFT);
            for (int i = 1; i < attr.length - 1; i++) {
                join = join.join(attr[i], JoinType.LEFT);
            }
            return join.get(attr[attr.length - 1]);
        }
    }

}
