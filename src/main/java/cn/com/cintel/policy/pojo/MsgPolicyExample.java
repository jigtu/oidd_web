package cn.com.cintel.policy.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgPolicyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MsgPolicyExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("`domain` is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("`domain` is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(String value) {
            addCriterion("`domain` =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            addCriterion("`domain` <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(String value) {
            addCriterion("`domain` >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            addCriterion("`domain` >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(String value) {
            addCriterion("`domain` <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            addCriterion("`domain` <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLike(String value) {
            addCriterion("`domain` like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotLike(String value) {
            addCriterion("`domain` not like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(List<String> values) {
            addCriterion("`domain` in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(List<String> values) {
            addCriterion("`domain` not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            addCriterion("`domain` between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            addCriterion("`domain` not between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andLacIsNull() {
            addCriterion("lac is null");
            return (Criteria) this;
        }

        public Criteria andLacIsNotNull() {
            addCriterion("lac is not null");
            return (Criteria) this;
        }

        public Criteria andLacEqualTo(String value) {
            addCriterion("lac =", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacNotEqualTo(String value) {
            addCriterion("lac <>", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacGreaterThan(String value) {
            addCriterion("lac >", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacGreaterThanOrEqualTo(String value) {
            addCriterion("lac >=", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacLessThan(String value) {
            addCriterion("lac <", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacLessThanOrEqualTo(String value) {
            addCriterion("lac <=", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacLike(String value) {
            addCriterion("lac like", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacNotLike(String value) {
            addCriterion("lac not like", value, "lac");
            return (Criteria) this;
        }

        public Criteria andLacIn(List<String> values) {
            addCriterion("lac in", values, "lac");
            return (Criteria) this;
        }

        public Criteria andLacNotIn(List<String> values) {
            addCriterion("lac not in", values, "lac");
            return (Criteria) this;
        }

        public Criteria andLacBetween(String value1, String value2) {
            addCriterion("lac between", value1, value2, "lac");
            return (Criteria) this;
        }

        public Criteria andLacNotBetween(String value1, String value2) {
            addCriterion("lac not between", value1, value2, "lac");
            return (Criteria) this;
        }

        public Criteria andLacNameIsNull() {
            addCriterion("lac_name is null");
            return (Criteria) this;
        }

        public Criteria andLacNameIsNotNull() {
            addCriterion("lac_name is not null");
            return (Criteria) this;
        }

        public Criteria andLacNameEqualTo(String value) {
            addCriterion("lac_name =", value, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameNotEqualTo(String value) {
            addCriterion("lac_name <>", value, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameGreaterThan(String value) {
            addCriterion("lac_name >", value, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameGreaterThanOrEqualTo(String value) {
            addCriterion("lac_name >=", value, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameLessThan(String value) {
            addCriterion("lac_name <", value, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameLessThanOrEqualTo(String value) {
            addCriterion("lac_name <=", value, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameLike(String value) {
            addCriterion("lac_name like", value, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameNotLike(String value) {
            addCriterion("lac_name not like", value, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameIn(List<String> values) {
            addCriterion("lac_name in", values, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameNotIn(List<String> values) {
            addCriterion("lac_name not in", values, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameBetween(String value1, String value2) {
            addCriterion("lac_name between", value1, value2, "lacName");
            return (Criteria) this;
        }

        public Criteria andLacNameNotBetween(String value1, String value2) {
            addCriterion("lac_name not between", value1, value2, "lacName");
            return (Criteria) this;
        }

        public Criteria andFlowRateIsNull() {
            addCriterion("flow_rate is null");
            return (Criteria) this;
        }

        public Criteria andFlowRateIsNotNull() {
            addCriterion("flow_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFlowRateEqualTo(Integer value) {
            addCriterion("flow_rate =", value, "flowRate");
            return (Criteria) this;
        }

        public Criteria andFlowRateNotEqualTo(Integer value) {
            addCriterion("flow_rate <>", value, "flowRate");
            return (Criteria) this;
        }

        public Criteria andFlowRateGreaterThan(Integer value) {
            addCriterion("flow_rate >", value, "flowRate");
            return (Criteria) this;
        }

        public Criteria andFlowRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_rate >=", value, "flowRate");
            return (Criteria) this;
        }

        public Criteria andFlowRateLessThan(Integer value) {
            addCriterion("flow_rate <", value, "flowRate");
            return (Criteria) this;
        }

        public Criteria andFlowRateLessThanOrEqualTo(Integer value) {
            addCriterion("flow_rate <=", value, "flowRate");
            return (Criteria) this;
        }

        public Criteria andFlowRateIn(List<Integer> values) {
            addCriterion("flow_rate in", values, "flowRate");
            return (Criteria) this;
        }

        public Criteria andFlowRateNotIn(List<Integer> values) {
            addCriterion("flow_rate not in", values, "flowRate");
            return (Criteria) this;
        }

        public Criteria andFlowRateBetween(Integer value1, Integer value2) {
            addCriterion("flow_rate between", value1, value2, "flowRate");
            return (Criteria) this;
        }

        public Criteria andFlowRateNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_rate not between", value1, value2, "flowRate");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

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