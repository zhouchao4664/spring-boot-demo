package com.zhouchao.elasticsearch.domain;

import java.util.ArrayList;
import java.util.List;

public class ExampleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ExampleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNull() {
            addCriterion("background is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNotNull() {
            addCriterion("background is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundEqualTo(String value) {
            addCriterion("background =", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotEqualTo(String value) {
            addCriterion("background <>", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThan(String value) {
            addCriterion("background >", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("background >=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThan(String value) {
            addCriterion("background <", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThanOrEqualTo(String value) {
            addCriterion("background <=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLike(String value) {
            addCriterion("background like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotLike(String value) {
            addCriterion("background not like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundIn(List<String> values) {
            addCriterion("background in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotIn(List<String> values) {
            addCriterion("background not in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundBetween(String value1, String value2) {
            addCriterion("background between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotBetween(String value1, String value2) {
            addCriterion("background not between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNull() {
            addCriterion("video_url is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("video_url is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("video_url =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("video_url <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("video_url >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("video_url >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("video_url <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("video_url <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("video_url like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("video_url not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(List<String> values) {
            addCriterion("video_url in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(List<String> values) {
            addCriterion("video_url not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("video_url between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("video_url not between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andProjectSizeIsNull() {
            addCriterion("project_size is null");
            return (Criteria) this;
        }

        public Criteria andProjectSizeIsNotNull() {
            addCriterion("project_size is not null");
            return (Criteria) this;
        }

        public Criteria andProjectSizeEqualTo(String value) {
            addCriterion("project_size =", value, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeNotEqualTo(String value) {
            addCriterion("project_size <>", value, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeGreaterThan(String value) {
            addCriterion("project_size >", value, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeGreaterThanOrEqualTo(String value) {
            addCriterion("project_size >=", value, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeLessThan(String value) {
            addCriterion("project_size <", value, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeLessThanOrEqualTo(String value) {
            addCriterion("project_size <=", value, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeLike(String value) {
            addCriterion("project_size like", value, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeNotLike(String value) {
            addCriterion("project_size not like", value, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeIn(List<String> values) {
            addCriterion("project_size in", values, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeNotIn(List<String> values) {
            addCriterion("project_size not in", values, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeBetween(String value1, String value2) {
            addCriterion("project_size between", value1, value2, "projectSize");
            return (Criteria) this;
        }

        public Criteria andProjectSizeNotBetween(String value1, String value2) {
            addCriterion("project_size not between", value1, value2, "projectSize");
            return (Criteria) this;
        }

        public Criteria andTerminalIsNull() {
            addCriterion("terminal is null");
            return (Criteria) this;
        }

        public Criteria andTerminalIsNotNull() {
            addCriterion("terminal is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalEqualTo(Integer value) {
            addCriterion("terminal =", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotEqualTo(Integer value) {
            addCriterion("terminal <>", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalGreaterThan(Integer value) {
            addCriterion("terminal >", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalGreaterThanOrEqualTo(Integer value) {
            addCriterion("terminal >=", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLessThan(Integer value) {
            addCriterion("terminal <", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLessThanOrEqualTo(Integer value) {
            addCriterion("terminal <=", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalIn(List<Integer> values) {
            addCriterion("terminal in", values, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotIn(List<Integer> values) {
            addCriterion("terminal not in", values, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalBetween(Integer value1, Integer value2) {
            addCriterion("terminal between", value1, value2, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotBetween(Integer value1, Integer value2) {
            addCriterion("terminal not between", value1, value2, "terminal");
            return (Criteria) this;
        }

        public Criteria andStatusPublishIsNull() {
            addCriterion("status_publish is null");
            return (Criteria) this;
        }

        public Criteria andStatusPublishIsNotNull() {
            addCriterion("status_publish is not null");
            return (Criteria) this;
        }

        public Criteria andStatusPublishEqualTo(Integer value) {
            addCriterion("status_publish =", value, "statusPublish");
            return (Criteria) this;
        }

        public Criteria andStatusPublishNotEqualTo(Integer value) {
            addCriterion("status_publish <>", value, "statusPublish");
            return (Criteria) this;
        }

        public Criteria andStatusPublishGreaterThan(Integer value) {
            addCriterion("status_publish >", value, "statusPublish");
            return (Criteria) this;
        }

        public Criteria andStatusPublishGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_publish >=", value, "statusPublish");
            return (Criteria) this;
        }

        public Criteria andStatusPublishLessThan(Integer value) {
            addCriterion("status_publish <", value, "statusPublish");
            return (Criteria) this;
        }

        public Criteria andStatusPublishLessThanOrEqualTo(Integer value) {
            addCriterion("status_publish <=", value, "statusPublish");
            return (Criteria) this;
        }

        public Criteria andStatusPublishIn(List<Integer> values) {
            addCriterion("status_publish in", values, "statusPublish");
            return (Criteria) this;
        }

        public Criteria andStatusPublishNotIn(List<Integer> values) {
            addCriterion("status_publish not in", values, "statusPublish");
            return (Criteria) this;
        }

        public Criteria andStatusPublishBetween(Integer value1, Integer value2) {
            addCriterion("status_publish between", value1, value2, "statusPublish");
            return (Criteria) this;
        }

        public Criteria andStatusPublishNotBetween(Integer value1, Integer value2) {
            addCriterion("status_publish not between", value1, value2, "statusPublish");
            return (Criteria) this;
        }

        public Criteria andLikeNumIsNull() {
            addCriterion("like_num is null");
            return (Criteria) this;
        }

        public Criteria andLikeNumIsNotNull() {
            addCriterion("like_num is not null");
            return (Criteria) this;
        }

        public Criteria andLikeNumEqualTo(Integer value) {
            addCriterion("like_num =", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotEqualTo(Integer value) {
            addCriterion("like_num <>", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumGreaterThan(Integer value) {
            addCriterion("like_num >", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_num >=", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumLessThan(Integer value) {
            addCriterion("like_num <", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumLessThanOrEqualTo(Integer value) {
            addCriterion("like_num <=", value, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumIn(List<Integer> values) {
            addCriterion("like_num in", values, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotIn(List<Integer> values) {
            addCriterion("like_num not in", values, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumBetween(Integer value1, Integer value2) {
            addCriterion("like_num between", value1, value2, "likeNum");
            return (Criteria) this;
        }

        public Criteria andLikeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("like_num not between", value1, value2, "likeNum");
            return (Criteria) this;
        }

        public Criteria andBrowseNumIsNull() {
            addCriterion("browse_num is null");
            return (Criteria) this;
        }

        public Criteria andBrowseNumIsNotNull() {
            addCriterion("browse_num is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseNumEqualTo(Integer value) {
            addCriterion("browse_num =", value, "browseNum");
            return (Criteria) this;
        }

        public Criteria andBrowseNumNotEqualTo(Integer value) {
            addCriterion("browse_num <>", value, "browseNum");
            return (Criteria) this;
        }

        public Criteria andBrowseNumGreaterThan(Integer value) {
            addCriterion("browse_num >", value, "browseNum");
            return (Criteria) this;
        }

        public Criteria andBrowseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_num >=", value, "browseNum");
            return (Criteria) this;
        }

        public Criteria andBrowseNumLessThan(Integer value) {
            addCriterion("browse_num <", value, "browseNum");
            return (Criteria) this;
        }

        public Criteria andBrowseNumLessThanOrEqualTo(Integer value) {
            addCriterion("browse_num <=", value, "browseNum");
            return (Criteria) this;
        }

        public Criteria andBrowseNumIn(List<Integer> values) {
            addCriterion("browse_num in", values, "browseNum");
            return (Criteria) this;
        }

        public Criteria andBrowseNumNotIn(List<Integer> values) {
            addCriterion("browse_num not in", values, "browseNum");
            return (Criteria) this;
        }

        public Criteria andBrowseNumBetween(Integer value1, Integer value2) {
            addCriterion("browse_num between", value1, value2, "browseNum");
            return (Criteria) this;
        }

        public Criteria andBrowseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_num not between", value1, value2, "browseNum");
            return (Criteria) this;
        }

        public Criteria andOfficialIsNull() {
            addCriterion("official is null");
            return (Criteria) this;
        }

        public Criteria andOfficialIsNotNull() {
            addCriterion("official is not null");
            return (Criteria) this;
        }

        public Criteria andOfficialEqualTo(Integer value) {
            addCriterion("official =", value, "official");
            return (Criteria) this;
        }

        public Criteria andOfficialNotEqualTo(Integer value) {
            addCriterion("official <>", value, "official");
            return (Criteria) this;
        }

        public Criteria andOfficialGreaterThan(Integer value) {
            addCriterion("official >", value, "official");
            return (Criteria) this;
        }

        public Criteria andOfficialGreaterThanOrEqualTo(Integer value) {
            addCriterion("official >=", value, "official");
            return (Criteria) this;
        }

        public Criteria andOfficialLessThan(Integer value) {
            addCriterion("official <", value, "official");
            return (Criteria) this;
        }

        public Criteria andOfficialLessThanOrEqualTo(Integer value) {
            addCriterion("official <=", value, "official");
            return (Criteria) this;
        }

        public Criteria andOfficialIn(List<Integer> values) {
            addCriterion("official in", values, "official");
            return (Criteria) this;
        }

        public Criteria andOfficialNotIn(List<Integer> values) {
            addCriterion("official not in", values, "official");
            return (Criteria) this;
        }

        public Criteria andOfficialBetween(Integer value1, Integer value2) {
            addCriterion("official between", value1, value2, "official");
            return (Criteria) this;
        }

        public Criteria andOfficialNotBetween(Integer value1, Integer value2) {
            addCriterion("official not between", value1, value2, "official");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Long value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Long value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Long value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Long value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Long value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Long> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Long> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Long value1, Long value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Long value1, Long value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andFolderIdIsNull() {
            addCriterion("folder_id is null");
            return (Criteria) this;
        }

        public Criteria andFolderIdIsNotNull() {
            addCriterion("folder_id is not null");
            return (Criteria) this;
        }

        public Criteria andFolderIdEqualTo(Integer value) {
            addCriterion("folder_id =", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotEqualTo(Integer value) {
            addCriterion("folder_id <>", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdGreaterThan(Integer value) {
            addCriterion("folder_id >", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("folder_id >=", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdLessThan(Integer value) {
            addCriterion("folder_id <", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdLessThanOrEqualTo(Integer value) {
            addCriterion("folder_id <=", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdIn(List<Integer> values) {
            addCriterion("folder_id in", values, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotIn(List<Integer> values) {
            addCriterion("folder_id not in", values, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdBetween(Integer value1, Integer value2) {
            addCriterion("folder_id between", value1, value2, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("folder_id not between", value1, value2, "folderId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Long value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Long value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Long value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Long value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Long> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Long> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCoverTitleIsNull() {
            addCriterion("cover_title is null");
            return (Criteria) this;
        }

        public Criteria andCoverTitleIsNotNull() {
            addCriterion("cover_title is not null");
            return (Criteria) this;
        }

        public Criteria andCoverTitleEqualTo(String value) {
            addCriterion("cover_title =", value, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleNotEqualTo(String value) {
            addCriterion("cover_title <>", value, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleGreaterThan(String value) {
            addCriterion("cover_title >", value, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleGreaterThanOrEqualTo(String value) {
            addCriterion("cover_title >=", value, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleLessThan(String value) {
            addCriterion("cover_title <", value, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleLessThanOrEqualTo(String value) {
            addCriterion("cover_title <=", value, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleLike(String value) {
            addCriterion("cover_title like", value, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleNotLike(String value) {
            addCriterion("cover_title not like", value, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleIn(List<String> values) {
            addCriterion("cover_title in", values, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleNotIn(List<String> values) {
            addCriterion("cover_title not in", values, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleBetween(String value1, String value2) {
            addCriterion("cover_title between", value1, value2, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCoverTitleNotBetween(String value1, String value2) {
            addCriterion("cover_title not between", value1, value2, "coverTitle");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlIsNull() {
            addCriterion("custom_cover_url is null");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlIsNotNull() {
            addCriterion("custom_cover_url is not null");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlEqualTo(String value) {
            addCriterion("custom_cover_url =", value, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlNotEqualTo(String value) {
            addCriterion("custom_cover_url <>", value, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlGreaterThan(String value) {
            addCriterion("custom_cover_url >", value, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("custom_cover_url >=", value, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlLessThan(String value) {
            addCriterion("custom_cover_url <", value, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlLessThanOrEqualTo(String value) {
            addCriterion("custom_cover_url <=", value, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlLike(String value) {
            addCriterion("custom_cover_url like", value, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlNotLike(String value) {
            addCriterion("custom_cover_url not like", value, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlIn(List<String> values) {
            addCriterion("custom_cover_url in", values, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlNotIn(List<String> values) {
            addCriterion("custom_cover_url not in", values, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlBetween(String value1, String value2) {
            addCriterion("custom_cover_url between", value1, value2, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverUrlNotBetween(String value1, String value2) {
            addCriterion("custom_cover_url not between", value1, value2, "customCoverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionIsNull() {
            addCriterion("cover_style_position is null");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionIsNotNull() {
            addCriterion("cover_style_position is not null");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionEqualTo(Integer value) {
            addCriterion("cover_style_position =", value, "coverStylePosition");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionNotEqualTo(Integer value) {
            addCriterion("cover_style_position <>", value, "coverStylePosition");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionGreaterThan(Integer value) {
            addCriterion("cover_style_position >", value, "coverStylePosition");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("cover_style_position >=", value, "coverStylePosition");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionLessThan(Integer value) {
            addCriterion("cover_style_position <", value, "coverStylePosition");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionLessThanOrEqualTo(Integer value) {
            addCriterion("cover_style_position <=", value, "coverStylePosition");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionIn(List<Integer> values) {
            addCriterion("cover_style_position in", values, "coverStylePosition");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionNotIn(List<Integer> values) {
            addCriterion("cover_style_position not in", values, "coverStylePosition");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionBetween(Integer value1, Integer value2) {
            addCriterion("cover_style_position between", value1, value2, "coverStylePosition");
            return (Criteria) this;
        }

        public Criteria andCoverStylePositionNotBetween(Integer value1, Integer value2) {
            addCriterion("cover_style_position not between", value1, value2, "coverStylePosition");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlIsNull() {
            addCriterion("custom_cover_origin_url is null");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlIsNotNull() {
            addCriterion("custom_cover_origin_url is not null");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlEqualTo(String value) {
            addCriterion("custom_cover_origin_url =", value, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlNotEqualTo(String value) {
            addCriterion("custom_cover_origin_url <>", value, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlGreaterThan(String value) {
            addCriterion("custom_cover_origin_url >", value, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlGreaterThanOrEqualTo(String value) {
            addCriterion("custom_cover_origin_url >=", value, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlLessThan(String value) {
            addCriterion("custom_cover_origin_url <", value, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlLessThanOrEqualTo(String value) {
            addCriterion("custom_cover_origin_url <=", value, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlLike(String value) {
            addCriterion("custom_cover_origin_url like", value, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlNotLike(String value) {
            addCriterion("custom_cover_origin_url not like", value, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlIn(List<String> values) {
            addCriterion("custom_cover_origin_url in", values, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlNotIn(List<String> values) {
            addCriterion("custom_cover_origin_url not in", values, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlBetween(String value1, String value2) {
            addCriterion("custom_cover_origin_url between", value1, value2, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCustomCoverOriginUrlNotBetween(String value1, String value2) {
            addCriterion("custom_cover_origin_url not between", value1, value2, "customCoverOriginUrl");
            return (Criteria) this;
        }

        public Criteria andCollectNumIsNull() {
            addCriterion("collect_num is null");
            return (Criteria) this;
        }

        public Criteria andCollectNumIsNotNull() {
            addCriterion("collect_num is not null");
            return (Criteria) this;
        }

        public Criteria andCollectNumEqualTo(Integer value) {
            addCriterion("collect_num =", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotEqualTo(Integer value) {
            addCriterion("collect_num <>", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumGreaterThan(Integer value) {
            addCriterion("collect_num >", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_num >=", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumLessThan(Integer value) {
            addCriterion("collect_num <", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumLessThanOrEqualTo(Integer value) {
            addCriterion("collect_num <=", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumIn(List<Integer> values) {
            addCriterion("collect_num in", values, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotIn(List<Integer> values) {
            addCriterion("collect_num not in", values, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumBetween(Integer value1, Integer value2) {
            addCriterion("collect_num between", value1, value2, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_num not between", value1, value2, "collectNum");
            return (Criteria) this;
        }

        public Criteria andExaminerIsNull() {
            addCriterion("examiner is null");
            return (Criteria) this;
        }

        public Criteria andExaminerIsNotNull() {
            addCriterion("examiner is not null");
            return (Criteria) this;
        }

        public Criteria andExaminerEqualTo(String value) {
            addCriterion("examiner =", value, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerNotEqualTo(String value) {
            addCriterion("examiner <>", value, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerGreaterThan(String value) {
            addCriterion("examiner >", value, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerGreaterThanOrEqualTo(String value) {
            addCriterion("examiner >=", value, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerLessThan(String value) {
            addCriterion("examiner <", value, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerLessThanOrEqualTo(String value) {
            addCriterion("examiner <=", value, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerLike(String value) {
            addCriterion("examiner like", value, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerNotLike(String value) {
            addCriterion("examiner not like", value, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerIn(List<String> values) {
            addCriterion("examiner in", values, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerNotIn(List<String> values) {
            addCriterion("examiner not in", values, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerBetween(String value1, String value2) {
            addCriterion("examiner between", value1, value2, "examiner");
            return (Criteria) this;
        }

        public Criteria andExaminerNotBetween(String value1, String value2) {
            addCriterion("examiner not between", value1, value2, "examiner");
            return (Criteria) this;
        }

        public Criteria andExamineTimeIsNull() {
            addCriterion("examine_time is null");
            return (Criteria) this;
        }

        public Criteria andExamineTimeIsNotNull() {
            addCriterion("examine_time is not null");
            return (Criteria) this;
        }

        public Criteria andExamineTimeEqualTo(Long value) {
            addCriterion("examine_time =", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeNotEqualTo(Long value) {
            addCriterion("examine_time <>", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeGreaterThan(Long value) {
            addCriterion("examine_time >", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("examine_time >=", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeLessThan(Long value) {
            addCriterion("examine_time <", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeLessThanOrEqualTo(Long value) {
            addCriterion("examine_time <=", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeIn(List<Long> values) {
            addCriterion("examine_time in", values, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeNotIn(List<Long> values) {
            addCriterion("examine_time not in", values, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeBetween(Long value1, Long value2) {
            addCriterion("examine_time between", value1, value2, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeNotBetween(Long value1, Long value2) {
            addCriterion("examine_time not between", value1, value2, "examineTime");
            return (Criteria) this;
        }

        public Criteria andShareNumIsNull() {
            addCriterion("share_num is null");
            return (Criteria) this;
        }

        public Criteria andShareNumIsNotNull() {
            addCriterion("share_num is not null");
            return (Criteria) this;
        }

        public Criteria andShareNumEqualTo(Integer value) {
            addCriterion("share_num =", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumNotEqualTo(Integer value) {
            addCriterion("share_num <>", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumGreaterThan(Integer value) {
            addCriterion("share_num >", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_num >=", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumLessThan(Integer value) {
            addCriterion("share_num <", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumLessThanOrEqualTo(Integer value) {
            addCriterion("share_num <=", value, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumIn(List<Integer> values) {
            addCriterion("share_num in", values, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumNotIn(List<Integer> values) {
            addCriterion("share_num not in", values, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumBetween(Integer value1, Integer value2) {
            addCriterion("share_num between", value1, value2, "shareNum");
            return (Criteria) this;
        }

        public Criteria andShareNumNotBetween(Integer value1, Integer value2) {
            addCriterion("share_num not between", value1, value2, "shareNum");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("`source` is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("`source` is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("`source` =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("`source` <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("`source` >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("`source` >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("`source` <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("`source` <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("`source` in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("`source` not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("`source` between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("`source` not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andIfDownloadIsNull() {
            addCriterion("if_download is null");
            return (Criteria) this;
        }

        public Criteria andIfDownloadIsNotNull() {
            addCriterion("if_download is not null");
            return (Criteria) this;
        }

        public Criteria andIfDownloadEqualTo(Boolean value) {
            addCriterion("if_download =", value, "ifDownload");
            return (Criteria) this;
        }

        public Criteria andIfDownloadNotEqualTo(Boolean value) {
            addCriterion("if_download <>", value, "ifDownload");
            return (Criteria) this;
        }

        public Criteria andIfDownloadGreaterThan(Boolean value) {
            addCriterion("if_download >", value, "ifDownload");
            return (Criteria) this;
        }

        public Criteria andIfDownloadGreaterThanOrEqualTo(Boolean value) {
            addCriterion("if_download >=", value, "ifDownload");
            return (Criteria) this;
        }

        public Criteria andIfDownloadLessThan(Boolean value) {
            addCriterion("if_download <", value, "ifDownload");
            return (Criteria) this;
        }

        public Criteria andIfDownloadLessThanOrEqualTo(Boolean value) {
            addCriterion("if_download <=", value, "ifDownload");
            return (Criteria) this;
        }

        public Criteria andIfDownloadIn(List<Boolean> values) {
            addCriterion("if_download in", values, "ifDownload");
            return (Criteria) this;
        }

        public Criteria andIfDownloadNotIn(List<Boolean> values) {
            addCriterion("if_download not in", values, "ifDownload");
            return (Criteria) this;
        }

        public Criteria andIfDownloadBetween(Boolean value1, Boolean value2) {
            addCriterion("if_download between", value1, value2, "ifDownload");
            return (Criteria) this;
        }

        public Criteria andIfDownloadNotBetween(Boolean value1, Boolean value2) {
            addCriterion("if_download not between", value1, value2, "ifDownload");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}