package cn.com.cintel.commons;

import java.util.List;

/**
 * <p>Title: BaseService.java</p>
 * <p>Description: BaseService</p>
 * <p>批量添加，批量修改多表关联查询需要手动实现</p>
 * <p>泛型参数 : T为pojo类,V为范例example类</p>
 * <p>注意：在service中，不要在一个方法中调用service本类中的另一个方法。严格来说service层中，方法不要相互调用</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: cintel</p>
 *
 * @author ZiQiang
 * @date 2019年01月07日
 */
public interface BaseService<T, V> {
    /**
     * <p>Title: selectByExample</p>
     * <p>Description:动态查询(selectByExample) </p>
     *
     * @param example Example 查询条件
     * @return 查询结果
     */
    List<T> selectAll(V example);

    /**
     * <p>Title: selectByExample</p>
     * <p>Description:按主键查询 (selectByPrimaryKey)</p>
     *
     * @param id 主键id
     * @return 查询结果
     */
    T selectById(Integer id);

    /**
     * <p>Title: save</p>
     * <p>Description:添加(insertSelective) </p>
     *
     * @param entity 数据实体
     * @return 添加结果
     */
    int save(T entity);

    /**
     * <p>Title: update</p>
     * <p>Description: 动态修改(updateByExampleSelective)</p>
     *
     * @param entity  封装数据实体
     * @param example Example
     * @return 更新结果
     */
    int update(T entity, V example);

    /**
     * <p>Title: updateById</p>
     * <p>Description:按主键修改(updateByPrimaryKeySelective) </p>
     *
     * @param entity 封装数据实体
     * @return 结果
     */
    int updateById(T entity);

    /**
     * <p>Title: count</p>
     * <p>Description: 动态查询总条数(countByExample)</p>
     *
     * @param example Example
     * @return 统计结果
     */
    int count(V example);

    /**
     * <p>Title: deleteByExample</p>
     * <p>Description:动态删除(deleteByExample) </p>
     *
     * @param example Example
     * @return 删除结果
     */
    int delete(V example);

    /**
     * <p>Title: deleteByPrimaryKey</p>
     * <p>Description:按主键删除(deleteByPrimaryKey) </p>
     *
     * @param id 主键
     * @return 结果
     */
    int deleteById(Integer id);
}