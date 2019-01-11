package cn.com.cintel.policy.pojo;

import java.util.Date;

public class MsgPolicy {
    private String id;

    private String domain;

    private String lac;

    private String lacName;

    private Integer flowRate;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac == null ? null : lac.trim();
    }

    public String getLacName() {
        return lacName;
    }

    public void setLacName(String lacName) {
        this.lacName = lacName == null ? null : lacName.trim();
    }

    public Integer getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(Integer flowRate) {
        this.flowRate = flowRate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}