package cn.com.cintel.policy.service;

import cn.com.cintel.commons.BaseService;
import cn.com.cintel.policy.pojo.MsgPolicy;
import cn.com.cintel.policy.pojo.MsgPolicyExample;

import java.util.List;
import java.util.Map;

/**
 * @author ZiQiang
 * @date 2019/1/7 9:21
 * 描述： <p>请写明本类的作用</p>
 */
public interface MsgPolicyService extends BaseService<MsgPolicy, MsgPolicyExample> {
    /**
     * 分页查询
     *
     * @param example     查询条件
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 返回结果
     */
    List<MsgPolicy> select(MsgPolicyExample example, Integer currentPage, Integer pageSize);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 结果
     */
    MsgPolicy selectById(String id);

    /**
     * 根据主键删除
     *
     * @param id 主键id
     * @return 删除结果
     */
    int deleteById(String id);
}
