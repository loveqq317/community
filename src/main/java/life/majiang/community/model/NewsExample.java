package life.majiang.community.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    public NewsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNull() {
            addCriterion("HEAD_URL is null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIsNotNull() {
            addCriterion("HEAD_URL is not null");
            return (Criteria) this;
        }

        public Criteria andHeadUrlEqualTo(String value) {
            addCriterion("HEAD_URL =", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotEqualTo(String value) {
            addCriterion("HEAD_URL <>", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThan(String value) {
            addCriterion("HEAD_URL >", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("HEAD_URL >=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThan(String value) {
            addCriterion("HEAD_URL <", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLessThanOrEqualTo(String value) {
            addCriterion("HEAD_URL <=", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlLike(String value) {
            addCriterion("HEAD_URL like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotLike(String value) {
            addCriterion("HEAD_URL not like", value, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlIn(List<String> values) {
            addCriterion("HEAD_URL in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotIn(List<String> values) {
            addCriterion("HEAD_URL not in", values, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlBetween(String value1, String value2) {
            addCriterion("HEAD_URL between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andHeadUrlNotBetween(String value1, String value2) {
            addCriterion("HEAD_URL not between", value1, value2, "headUrl");
            return (Criteria) this;
        }

        public Criteria andIsFocusIsNull() {
            addCriterion("IS_FOCUS is null");
            return (Criteria) this;
        }

        public Criteria andIsFocusIsNotNull() {
            addCriterion("IS_FOCUS is not null");
            return (Criteria) this;
        }

        public Criteria andIsFocusEqualTo(Boolean value) {
            addCriterion("IS_FOCUS =", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusNotEqualTo(Boolean value) {
            addCriterion("IS_FOCUS <>", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusGreaterThan(Boolean value) {
            addCriterion("IS_FOCUS >", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_FOCUS >=", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusLessThan(Boolean value) {
            addCriterion("IS_FOCUS <", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_FOCUS <=", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusIn(List<Boolean> values) {
            addCriterion("IS_FOCUS in", values, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusNotIn(List<Boolean> values) {
            addCriterion("IS_FOCUS not in", values, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_FOCUS between", value1, value2, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_FOCUS not between", value1, value2, "isFocus");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNull() {
            addCriterion("NEWS_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNotNull() {
            addCriterion("NEWS_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleEqualTo(String value) {
            addCriterion("NEWS_TITLE =", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotEqualTo(String value) {
            addCriterion("NEWS_TITLE <>", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThan(String value) {
            addCriterion("NEWS_TITLE >", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("NEWS_TITLE >=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThan(String value) {
            addCriterion("NEWS_TITLE <", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThanOrEqualTo(String value) {
            addCriterion("NEWS_TITLE <=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLike(String value) {
            addCriterion("NEWS_TITLE like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotLike(String value) {
            addCriterion("NEWS_TITLE not like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIn(List<String> values) {
            addCriterion("NEWS_TITLE in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotIn(List<String> values) {
            addCriterion("NEWS_TITLE not in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleBetween(String value1, String value2) {
            addCriterion("NEWS_TITLE between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotBetween(String value1, String value2) {
            addCriterion("NEWS_TITLE not between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andIsVideoIsNull() {
            addCriterion("IS_VIDEO is null");
            return (Criteria) this;
        }

        public Criteria andIsVideoIsNotNull() {
            addCriterion("IS_VIDEO is not null");
            return (Criteria) this;
        }

        public Criteria andIsVideoEqualTo(Boolean value) {
            addCriterion("IS_VIDEO =", value, "isVideo");
            return (Criteria) this;
        }

        public Criteria andIsVideoNotEqualTo(Boolean value) {
            addCriterion("IS_VIDEO <>", value, "isVideo");
            return (Criteria) this;
        }

        public Criteria andIsVideoGreaterThan(Boolean value) {
            addCriterion("IS_VIDEO >", value, "isVideo");
            return (Criteria) this;
        }

        public Criteria andIsVideoGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_VIDEO >=", value, "isVideo");
            return (Criteria) this;
        }

        public Criteria andIsVideoLessThan(Boolean value) {
            addCriterion("IS_VIDEO <", value, "isVideo");
            return (Criteria) this;
        }

        public Criteria andIsVideoLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_VIDEO <=", value, "isVideo");
            return (Criteria) this;
        }

        public Criteria andIsVideoIn(List<Boolean> values) {
            addCriterion("IS_VIDEO in", values, "isVideo");
            return (Criteria) this;
        }

        public Criteria andIsVideoNotIn(List<Boolean> values) {
            addCriterion("IS_VIDEO not in", values, "isVideo");
            return (Criteria) this;
        }

        public Criteria andIsVideoBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_VIDEO between", value1, value2, "isVideo");
            return (Criteria) this;
        }

        public Criteria andIsVideoNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_VIDEO not between", value1, value2, "isVideo");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNull() {
            addCriterion("VIDEO_URL is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("VIDEO_URL is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("VIDEO_URL =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("VIDEO_URL <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("VIDEO_URL >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_URL >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("VIDEO_URL <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_URL <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("VIDEO_URL like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("VIDEO_URL not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(List<String> values) {
            addCriterion("VIDEO_URL in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(List<String> values) {
            addCriterion("VIDEO_URL not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("VIDEO_URL between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("VIDEO_URL not between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackIsNull() {
            addCriterion("NEWS_ABSTRACK is null");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackIsNotNull() {
            addCriterion("NEWS_ABSTRACK is not null");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackEqualTo(String value) {
            addCriterion("NEWS_ABSTRACK =", value, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackNotEqualTo(String value) {
            addCriterion("NEWS_ABSTRACK <>", value, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackGreaterThan(String value) {
            addCriterion("NEWS_ABSTRACK >", value, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackGreaterThanOrEqualTo(String value) {
            addCriterion("NEWS_ABSTRACK >=", value, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackLessThan(String value) {
            addCriterion("NEWS_ABSTRACK <", value, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackLessThanOrEqualTo(String value) {
            addCriterion("NEWS_ABSTRACK <=", value, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackLike(String value) {
            addCriterion("NEWS_ABSTRACK like", value, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackNotLike(String value) {
            addCriterion("NEWS_ABSTRACK not like", value, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackIn(List<String> values) {
            addCriterion("NEWS_ABSTRACK in", values, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackNotIn(List<String> values) {
            addCriterion("NEWS_ABSTRACK not in", values, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackBetween(String value1, String value2) {
            addCriterion("NEWS_ABSTRACK between", value1, value2, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andNewsAbstrackNotBetween(String value1, String value2) {
            addCriterion("NEWS_ABSTRACK not between", value1, value2, "newsAbstrack");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIsNull() {
            addCriterion("IS_ORIGINAL is null");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIsNotNull() {
            addCriterion("IS_ORIGINAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsOriginalEqualTo(Boolean value) {
            addCriterion("IS_ORIGINAL =", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotEqualTo(Boolean value) {
            addCriterion("IS_ORIGINAL <>", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalGreaterThan(Boolean value) {
            addCriterion("IS_ORIGINAL >", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_ORIGINAL >=", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalLessThan(Boolean value) {
            addCriterion("IS_ORIGINAL <", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_ORIGINAL <=", value, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalIn(List<Boolean> values) {
            addCriterion("IS_ORIGINAL in", values, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotIn(List<Boolean> values) {
            addCriterion("IS_ORIGINAL not in", values, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_ORIGINAL between", value1, value2, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andIsOriginalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_ORIGINAL not between", value1, value2, "isOriginal");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWS
     *
     * @mbg.generated do_not_delete_during_merge Mon Mar 30 20:48:12 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table NEWS
     *
     * @mbg.generated Mon Mar 30 20:48:12 CST 2020
     */
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