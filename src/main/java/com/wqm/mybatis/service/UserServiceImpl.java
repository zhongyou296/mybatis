package com.wqm.mybatis.service;

import com.wqm.mybatis.dao.UserDAO;
import com.wqm.mybatis.model.UserDO;
import com.wqm.mybatis.model.UserQueryDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>文件名称：UserService </p>
 * <p>文件描述：</p>
 * <p>版权所有：版权所有(C)2011-2099 </p>
 * <p>公   司：口袋购物 </p>
 * <p>内容摘要：对用户操作的服务层的具体实现</p>
 * <p>其他说明：</p>
 * <p>完成日期：2017/3/7 </p>
 *
 * @author wangqiming
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDAO userDAO;

    @Override
    public int saveUser(UserDO pojo) {
        if (null == pojo) {
            logger.error("saveUser param is invalid");
            return -1;

        }
        try {
            return userDAO.save(pojo);
        } catch (Exception e) {
            logger.error("saveData error, pojo={}, e={}", pojo, e);
            return -1;
        }
    }

    @Override
    public int removeUser(UserDO pojo) {
        if (null == pojo) {
            logger.error("removeUser param is invalid");
            return -1;
        }

        try {
            return userDAO.remove(pojo);
        } catch (Exception e) {
            logger.error("removeUser error, pojo={}, e={}", pojo, e);
            return -1;
        }
    }

    @Override
    public int updateUser(UserDO pojo) {
        if (null == pojo) {
            logger.error("updateUser param is invalid");
            return -1;
        }

        try {
            return userDAO.update(pojo);
        } catch (Exception e) {
            logger.error("updateUser error, pojo={} ,e={}", pojo, e);
            return -1;
        }
    }

    @Override
    public List<UserDO> queryUserList(UserQueryDO queryDO) {
        if (null == queryDO) {
            logger.error("queryUserList param is invalid");
            return null;
        }

        try {
            return userDAO.query(queryDO);
        } catch (Exception e) {
            logger.error("queryUserList error, queryDO={}, e={}", queryDO, e);
            return null;
        }
    }

    @Override
    public int queryUserCount(UserQueryDO queryDO) {
        if (null == queryDO) {
            logger.error("queryUserCount param is invalid");
            return -1;
        }

        try {
            return userDAO.queryCount(queryDO);
        } catch (Exception e) {
            logger.error("queryUserCount error, queryDO={}, e={}", queryDO, e);
            return -1;
        }
    }

    @Override
    public UserDO get(Integer id) {
        if (null == id) {
            logger.error("get param is invalid");
            return null;
        }

        try {
            return userDAO.get(id);
        } catch (Exception e) {
            logger.error("get error, id={}, e={}", id, e);
            return null;
        }
    }
}
