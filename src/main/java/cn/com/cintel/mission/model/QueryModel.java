package cn.com.cintel.mission.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author ZiQiang
 * @date 2019/1/3 15:54
 * 描述： <p>请写明本类的作用</p>
 */
public class QueryModel {
    /**
     * 任务编号
     */
    @JSONField(name = "taskID")
    private String taskID;
    /**
     * 地区编号
     */
    @JSONField(name = "homeID")
    private String homeID;
    /**
     * 运营商基站结构
     */
    @JSONField(name = "domainLacList")
    private String domainLacList;

    /**
     * 预留字段
     */
    @JSONField(name = "reserved")
    private String reserved;

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getHomeID() {
        return homeID;
    }

    public void setHomeID(String homeID) {
        this.homeID = homeID;
    }

    public String getDomainLacList() {
        return domainLacList;
    }

    public void setDomainLacList(String domainLacList) {
        this.domainLacList = domainLacList;
    }
    
    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "QueryModel{" +
                "taskID='" + taskID + '\'' +
                ", homeID='" + homeID + '\'' +
                ", domainLacList='" + domainLacList + '\'' +
                ", reserved='" + reserved + '\'' +
                '}';
    }
}
