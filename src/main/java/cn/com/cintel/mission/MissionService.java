package cn.com.cintel.mission;

import cn.com.cintel.commons.RedisService;
import cn.com.cintel.mission.model.QueryModel;
import cn.com.cintel.mission.model.ReturnModel;
import cn.com.cintel.policy.pojo.MsgPolicy;
import cn.com.cintel.policy.service.MsgPolicyService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author ZiQiang
 * @date 2019/1/3 15:29
 * 描述： <p>请写明本类的作用</p>
 */
@RestController
@RequestMapping(value = "/MissionService")
public class MissionService {
    private static Logger logger = LoggerFactory.getLogger(MissionService.class);

    @Resource
    private RedisService redisService;

    @Resource
    private MsgPolicyService policyService;

    /**
     * 用户数查询接口
     *
     * @return 查询结果
     */
    @PostMapping(value = "/QueryPhoneTotalNumber", produces = "application/json")
    public ReturnModel queryPhoneTotalNumber(@RequestBody QueryModel model) {
        ReturnModel returnModel = new ReturnModel();
        try {
            logger.info("接收到的json数据：" + model);
            if (StringUtils.isEmpty(model.getDomainLacList())) {
                returnModel.setMessage("请求参数 domainLacList 为空");
                returnModel.setReturnCode("1");
                return returnModel;
            }
            List<String> cmList = new ArrayList<>();
            List<String> cuList = new ArrayList<>();
            List<String> ctList = new ArrayList<>();
            String[] split = model.getDomainLacList().split(",");
            for (String s : split) {
                // 电信
                if (s.startsWith("0_")) {
                    ctList.add(s);
                }
                // 移动
                if (s.startsWith("1_")) {
                    cmList.add(s);
                }
                if (s.startsWith("2_")) {
                    cuList.add(s);
                }
            }
            int ctLen = redisService.hlen(ctList);
            int cmLen = redisService.hlen(cmList);
            int cuLen = redisService.hlen(cuList);
            returnModel.setReturnCode("0");
            returnModel.setMessage("");
            returnModel.setUserCount(ctLen + cmLen + cuLen + "");
            returnModel.setCtUserCount(ctLen + "");
            returnModel.setCmUserCount(cmLen + "");
            returnModel.setCuUserCount(cuLen + "");
            logger.info("响应JSON数据：" + JSON.toJSONString(returnModel));
            return returnModel;
        } catch (Exception e) {
            returnModel.setReturnCode("1");
            returnModel.setMessage("异常：" + e.getMessage());
            e.printStackTrace();
            return returnModel;
        }
    }

    /**
     * 创建任务接口
     *
     * @return 任务发布结果
     */
    @PostMapping(value = "/CreateMissionInfo", consumes = "application/json")
    public ReturnModel createMissionInfo(@RequestBody QueryModel model) {
        ReturnModel returnModel = new ReturnModel();
        try {
            logger.info("接收到的json数据：" + model);
            String lacList = model.getDomainLacList();
            String[] split = lacList.split(",");
            String taskID = model.getTaskID();
            List<String> hKeys = redisService.hKeys(new ArrayList<>(Arrays.asList(split)));
            redisService.sadd(taskID, hKeys);
            returnModel.setUserCount(hKeys.size() + "");
            returnModel.setMessage("");
            returnModel.setReturnCode("0");
            logger.info("响应JSON数据：" + JSON.toJSONString(returnModel));
            return returnModel;
        } catch (Exception e) {
            returnModel.setReturnCode("1");
            returnModel.setMessage("异常：" + e.getMessage());
            e.printStackTrace();
            logger.info("响应JSON数据：" + JSON.toJSONString(returnModel));
            return returnModel;
        }
    }
}
