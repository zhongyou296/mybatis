package com.wqm.mybatis.service;

import com.wqm.mybatis.model.UserDO;
import com.wqm.mybatis.model.UserQueryDO;

import java.util.List;

/**
 * <p>文件名称：UserService </p>
 * <p>文件描述：</p>
 * <p>版权所有：版权所有(C)2011-2099 </p>
 * <p>公   司：口袋购物 </p>
 * <p>内容摘要：对用户操作的服务层</p>
 * <p>其他说明：</p>
 * <p>完成日期：2017/3/7 </p>
 *
 * @author wangqiming
 */
public interface UserService {

    /**
     * 插入方法
     *
     * @param pojo
     * @return
     */
    int saveUser(UserDO pojo);

    /**
     * 删除方法
     *
     * @param pojo
     * @return
     */
    int removeUser(UserDO pojo);

    /**
     * 更新方法
     *
     * @param pojo
     * @return
     */
    int updateUser(UserDO pojo);

    /**
     * 查询方法
     *
     * @param queryDO
     * @return
     */
    List<UserDO> queryUserList(UserQueryDO queryDO);

    /**
     * 查询条数
     *
     * @param queryDO
     * @return
     */
    int queryUserCount(UserQueryDO queryDO);

    /**
     * 根据主键获取对象
     *
     * @param id
     * @return
     */
    UserDO get(Integer id);
}
