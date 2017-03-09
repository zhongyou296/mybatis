package com.wqm.mybatis.dao;

import com.wqm.mybatis.model.UserDO;
import com.wqm.mybatis.model.UserQueryDO;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p>文件名称：UserDAO </p>
 * <p>文件描述：</p>
 * <p>版权所有：版权所有(C)2011-2099 </p>
 * <p>公   司：口袋购物 </p>
 * <p>内容摘要：访问数据库的mapper接口</p>
 * <p>其他说明：</p>
 * <p>完成日期：2017/3/7 </p>
 *
 * @author wangqiming
 */
@Repository
public interface UserDAO {

    /**
     * 插入方法
     *
     * @param userDO
     * @return
     */
    int save(UserDO userDO);

    /**
     * 删除方法
     *
     * @param userDO
     * @return
     */
    int remove(UserDO userDO);

    /**
     * 更新方法
     *
     * @param userDO
     * @return
     */
    int update(UserDO userDO);

    /**
     * 根据查询条件查询对象列表
     *
     * @param queryDO
     * @return
     */
    List<UserDO> query(UserQueryDO queryDO);

    /**
     * 根据查询条件查询条数
     *
     * @param queryDO
     * @return
     */
    int queryCount(UserQueryDO queryDO);

    /**
     * 根据主键获取对象
     *
     * @param id
     * @return
     */
    UserDO get(Integer id);
}
