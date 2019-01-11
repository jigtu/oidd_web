package cn.com.cintel.policy.dao;

import cn.com.cintel.policy.pojo.MsgPolicy;
import cn.com.cintel.policy.pojo.MsgPolicyExample;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public interface MsgPolicyDao {
    long countByExample(MsgPolicyExample example);

    int deleteByExample(MsgPolicyExample example);

    int deleteByPrimaryKey(String id);

    int insert(MsgPolicy record);

    int insertSelective(MsgPolicy record);

    List<MsgPolicy> selectByExample(MsgPolicyExample example);

    MsgPolicy selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MsgPolicy record, @Param("example") MsgPolicyExample example);

    int updateByExample(@Param("record") MsgPolicy record, @Param("example") MsgPolicyExample example);

    int updateByPrimaryKeySelective(MsgPolicy record);

    int updateByPrimaryKey(MsgPolicy record);
}