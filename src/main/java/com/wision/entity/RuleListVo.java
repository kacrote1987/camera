package com.wision.entity;

public class RuleListVo {
    private Long ruleId;
    private String tbl1;
    private String joinType;
    private String tbl2;
    private String key1;
    private String matchType;
    private String key2;
    private String shows;

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getTbl1() {
        return tbl1;
    }

    public void setTbl1(String tbl1) {
        this.tbl1 = tbl1;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public String getTbl2() {
        return tbl2;
    }

    public void setTbl2(String tbl2) {
        this.tbl2 = tbl2;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getShows() {
        return shows;
    }

    public void setShows(String shows) {
        this.shows = shows;
    }
}
