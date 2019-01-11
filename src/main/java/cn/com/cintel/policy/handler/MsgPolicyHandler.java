package cn.com.cintel.policy.handler;

import cn.com.cintel.cin.auth.aop.Log;
import cn.com.cintel.policy.pojo.BaseResponse;
import cn.com.cintel.policy.pojo.MsgPolicy;
import cn.com.cintel.policy.pojo.MsgPolicyExample;
import cn.com.cintel.policy.service.MsgPolicyService;
import cn.com.cintel.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author ZiQiang
 * @date 2019/1/7 9:34
 * 描述： <p>请写明本类的作用</p>
 */
@RestController
@RequestMapping(value = "/MsgPolicy")
public class MsgPolicyHandler extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(MsgPolicyHandler.class);

    @Resource
    private MsgPolicyService policyService;


    /**
     * 短信短信流量查结果ftl
     *
     * @param request HttpServletRequest
     * @return 结果
     * @throws Exception 异常
     */
    @RequestMapping(value = "/view")
    public ModelAndView view(HttpServletRequest request) throws Exception {
        return new ModelAndView("/policy/msgpolicy");
    }

    /**
     * 分页查询
     *
     * @param startDate   开始时间
     * @param endDate     结束时间
     * @param lac         基站编号
     * @param domain      数据来源 0 电信 1 移动 2 联通
     * @param pageSize    页面大小
     * @param currentPage 当前页
     * @return 查询结果
     */
    @RequestMapping(value = "/selectByCondition")
    public BaseResponse select(@RequestParam(required = false) String startDate,
                               @RequestParam(required = false) String endDate,
                               @RequestParam(required = false) String lac,
                               @RequestParam(required = false) String domain,
                               @RequestParam(required = false) Integer pageSize,
                               @RequestParam(required = false) Integer currentPage) {
        MsgPolicyExample msgBlackExample = new MsgPolicyExample();
        msgBlackExample.setOrderByClause(" `create_time` DESC");
        MsgPolicyExample.Criteria criteria = msgBlackExample.createCriteria();
        try {
            //开始时间 结束时间   增加时间搜索功能
            if (startDate != null && !("".equals(startDate)) && endDate != null && !("".equals(endDate))) {
                String patten = "yyyy-MM-dd";
                Date date = DateUtils.stringToDate(startDate, patten);
                Date date1 = DateUtils.stringToDate(endDate, patten);
                criteria.andCreateTimeBetween(date, date1);
            }
            // 基站编号
            if (lac != null && !"".equals(lac)) {
                criteria.andLacEqualTo(lac);
            }
            // 数据来源
            if (domain != null) {
                criteria.andDomainEqualTo(domain);
            }
            List<MsgPolicy> select = new ArrayList<>();
            long count = policyService.count(msgBlackExample);
            int anInt = Integer.parseInt(count + "");
            if (anInt == 0) {
                return ajaxSucc(select, 0, "查询成功", SUCCESS_CODE);
            }
            select = policyService.select(msgBlackExample, currentPage, pageSize);
            return ajaxSucc(select, anInt, "查询成功", SUCCESS_CODE);
        } catch (Exception e) {
            logger.error("异常：" + e);
            e.printStackTrace();
            return ajaxFail("查询失败", FAIL_CODE);
        }
    }

    /**
     * 查询
     *
     * @param id 主键id
     * @return 查询结果
     */
    @GetMapping(value = "/select/{id}")
    public BaseResponse select(@PathVariable String id) {
        try {
            MsgPolicy policy = policyService.selectById(id);
            return ajaxSucc(policy, "查询成功", SUCCESS_CODE);
        } catch (Exception e) {
            logger.error("异常：" + e);
            e.printStackTrace();
            return ajaxFail("查询失败", FAIL_CODE);
        }
    }

    /**
     * 添加短信下发流量控制策略
     *
     * @return 添加结果
     */
    @PostMapping(value = "/save")
    @Log(function_id = "41", operate_type = "5", operate_content = "短信下发流量控制策略")
    public BaseResponse save(@RequestBody MsgPolicy policy, HttpServletRequest request) {
        try {
            StringBuilder content = new StringBuilder();
            if (StringUtils.isEmpty(policy.getLac())
                    || StringUtils.isEmpty(policy.getDomain())
                    || StringUtils.isEmpty(policy.getLacName())) {
                logger.warn("添加失败：基站编号、或者运营商不能为空");
                return ajaxFail("添加失败：基站编号、或者运营商不能为空", FAIL_CODE);
            }
            policy.setCreateTime(new Date());
            policy.setUpdateTime(new Date());
            policy.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            policyService.save(policy);
            content.append("运营商：" + policy.getDomain()).append(", 基站名称：")
                    .append(policy.getLacName()).append(", 基站编号：" + policy.getLac());
            logger.info("添加成功：" + policy.getLacName());
            request.getSession().setAttribute("content", content.toString());
            return ajaxSucc(null, "添加成功", SUCCESS_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            return ajaxFail("添加失败", FAIL_CODE);
        }
    }

    /**
     * 删除短信发送流量拦截策略
     *
     * @param id      id集合
     * @param request HttpServletRequest
     * @return 删除结果
     */
    @DeleteMapping(value = "/delete/{id}")
    @Log(function_id = "41", operate_type = "6", operate_content = "删除短信发送流量拦截策略")
    public BaseResponse delete(@PathVariable("id") String id, HttpServletRequest request) {
        try {
            StringBuilder content = new StringBuilder();
            if (StringUtils.isEmpty(id)) {
                return ajaxFail("请选择一条删除", FAIL_CODE);
            }
            if (policyService.deleteById(id) > 0) {
                logger.info("删除策略成功");
                content.append("id：").append(id);
                request.getSession().setAttribute("content", content.toString());
                return ajaxSucc(null, "删除成功", SUCCESS_CODE);
            }
            logger.error("删除策略失败");
            return ajaxFail("删除策略失败", FAIL_CODE);
        } catch (Exception e) {
            e.printStackTrace();
            return ajaxFail("删除策略失败", FAIL_CODE);
        }
    }

    /**
     * 修改
     *
     * @param policy  修改的数据
     * @param request HttpServletRequest
     * @return 撤销结果
     */
    @PostMapping(value = "/update")
    @Log(function_id = "41", operate_type = "8", operate_content = "修改短信发送流量拦截策略")
    public BaseResponse update(@RequestBody MsgPolicy policy, HttpServletRequest request) {
        try {
            StringBuilder content = new StringBuilder();
            if (StringUtils.isEmpty(policy.getId())) {
                return ajaxFail("请确认唯一编号不为空", FAIL_CODE);
            }
            MsgPolicyExample policyExample = new MsgPolicyExample();
            policy.setUpdateTime(new Date());
            policyExample.createCriteria().andIdEqualTo(policy.getId());
            policyService.update(policy, policyExample);
            content.append("id：").append(policy.getId());
            request.getSession().setAttribute("content", content.toString());
            return ajaxSucc(null, "修改成功", SUCCESS_CODE);
        } catch (Exception e) {
            logger.error("修改失败：" + e);
            e.printStackTrace();
            return ajaxFail("修改失败", FAIL_CODE);
        }
    }
}
