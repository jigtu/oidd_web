package cn.com.cintel.policy.pojo;

import java.io.Serializable;

/**
 * 自定义response
 *
 * @author ZiQiang
 * @date 2019/01/07 09:38:00
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
    private String code;
    /**
     * 时间
     */
    private String time;
    /**
     * 描述
     */
    private Object msg;
    /**
     * 数据
     */
    private Object data;
    private Integer count;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
