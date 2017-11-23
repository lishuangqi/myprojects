package com.lishuangqi.cache;

/**
 * Created by michael on 2017/11/13.
 */
public class ComponentParamBean {
    private String pname;
    private String pvalue;
    private String ptype;
    private String projectId;

    public ComponentParamBean() {
    }

    public ComponentParamBean(String pname, String pvalue, String ptype, String projectId) {
        this.pname = pname;
        this.pvalue = pvalue;
        this.ptype = ptype;
        this.projectId = projectId;
    }

    public String getPname() {
        return this.pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPvalue() {
        return this.pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }

    public String getPtype() {
        return this.ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
