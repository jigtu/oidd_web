package cn.com.cintel.policy.handler;

import cn.com.cintel.policy.pojo.BaseResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author pps yapeng.yang@cintel.com.cn
 * @create 2018/12/28
 */
public class BaseController {

    /**
     * 成功状态码
     */
    protected static final String SUCCESS_CODE = "0";
    /**
     * 失败状态码
     */
    protected static final String FAIL_CODE = "300";

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 成功结果集
     *
     * @param data 数据
     * @param desc 描述
     * @param code 状态码
     * @return 结果集
     */
    public BaseResponse ajaxSucc(Object data, String desc, String code) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setTime(formatter.format(LocalDateTime.now()));
        baseResponse.setMsg(desc);
        baseResponse.setData(data);
        return baseResponse;
    }

    /**
     * 成功结果集
     *
     * @param data        数据
     * @param totalRecord 总条数
     * @param desc        描述
     * @param code        结果码
     * @return 结果集
     */
    public BaseResponse ajaxSucc(Object data, Integer totalRecord, String desc, String code) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setMsg(desc);
        baseResponse.setTime(formatter.format(LocalDateTime.now()));
        baseResponse.setData(data);
        baseResponse.setCount(totalRecord);
        return baseResponse;
    }

    /**
     * 失败结果集
     *
     * @param desc 描述
     * @param code 状态码
     * @return 结果
     */
    public BaseResponse ajaxFail(Object desc, String code) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(code);
        baseResponse.setMsg(desc);
        baseResponse.setData("{}");
        baseResponse.setTime(formatter.format(LocalDateTime.now()));
        return baseResponse;
    }
}
