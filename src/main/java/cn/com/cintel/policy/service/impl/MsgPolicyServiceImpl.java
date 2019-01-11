package cn.com.cintel.policy.service.impl;

import cn.com.cintel.policy.dao.MsgPolicyDao;
import cn.com.cintel.policy.pojo.MsgPolicy;
import cn.com.cintel.policy.pojo.MsgPolicyExample;
import cn.com.cintel.policy.service.MsgPolicyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZiQiang
 * @date 2019/1/7 9:24
 * 描述： <p>请写明本类的作用</p>
 */
@Service
public class MsgPolicyServiceImpl implements MsgPolicyService {

    @Resource
    private MsgPolicyDao policyDao;

    @Override
    public List<MsgPolicy> select(MsgPolicyExample example, Integer currentPage, Integer pageSize) {
        List<MsgPolicy> msgBlackList = policyDao.selectByExample(example);
        List<MsgPolicy> list = new ArrayList<>();
        if (msgBlackList.size() == 0) {
            return list;
        } else {
            for (int i = (currentPage - 1) * pageSize; i < (((currentPage - 1) * pageSize) + pageSize >
                    msgBlackList.size() ? msgBlackList.size() : ((currentPage - 1) * pageSize) + pageSize);
                 i++) {
                list.add(msgBlackList.get(i));
            }
            return list;
        }
    }

    @Override
    public List<MsgPolicy> selectAll(MsgPolicyExample example) {
        return policyDao.selectByExample(example);
    }

    @Override
    public MsgPolicy selectById(Integer id) {
        return null;
    }

    @Override
    public MsgPolicy selectById(String id) {
        return policyDao.selectByPrimaryKey(id);
    }

    @Override
    public int save(MsgPolicy entity) {
        return policyDao.insertSelective(entity);
    }

    @Override
    public int update(MsgPolicy entity, MsgPolicyExample example) {
        return policyDao.updateByExampleSelective(entity, example);
    }

    @Override
    public int updateById(MsgPolicy entity) {
        return policyDao.updateByPrimaryKeySelective(entity);
    }


    @Override
    public int count(MsgPolicyExample example) {
        return Integer.valueOf(policyDao.countByExample(example) + "");
    }

    @Override
    public int delete(MsgPolicyExample example) {
        return policyDao.deleteByExample(example);
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return policyDao.deleteByPrimaryKey(id);
    }
}
