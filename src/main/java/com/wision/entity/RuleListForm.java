package com.wision.entity;

public class RuleListForm {
    private Long ruleId;
    private Long relatId;
    private String styles;
    private String keyss;
    private String matches;
    private String vals;
    private String shows;

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Long getRelatId() {
        return relatId;
    }

    public void setRelatId(Long relatId) {
        this.relatId = relatId;
    }

    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }

    public String getKeyss() {
        return keyss;
    }

    public void setKeyss(String keyss) {
        this.keyss = keyss;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }

    public String getVals() {
        return vals;
    }

    public void setVals(String vals) {
        this.vals = vals;
    }

    public String getShows() {
        return shows;
    }

    public void setShows(String shows) {
        this.shows = shows;
    }
}
