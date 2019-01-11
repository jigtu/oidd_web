package cn.com.cintel.mission.model;

/**
 * @author ZiQiang
 * @date 2019/1/3 10:31
 * 描述： <p>返回请求的用户数量</p>
 */
public class ReturnModel {
    /**
     * 返回值 0 成功 1 失败
     */
    private String returnCode;
    /**
     * 返回信息 失败时填写
     */
    private String message;
    /**
     * 用户总数
     */
    private String userCount;
    /**
     * 移动用户总数
     */
    private String cmUserCount;
    /**
     * 电信用户总数
     */
    private String ctUserCount;
    /**
     * 联通用户总数
     */
    private String cuUserCount;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserCount() {
        return userCount;
    }

    public void setUserCount(String userCount) {
        this.userCount = userCount;
    }

    public String getCmUserCount() {
        return cmUserCount;
    }

    public void setCmUserCount(String cmUserCount) {
        this.cmUserCount = cmUserCount;
    }

    public String getCtUserCount() {
        return ctUserCount;
    }

    public void setCtUserCount(String ctUserCount) {
        this.ctUserCount = ctUserCount;
    }

    public String getCuUserCount() {
        return cuUserCount;
    }

    public void setCuUserCount(String cuUserCount) {
        this.cuUserCount = cuUserCount;
    }
}
