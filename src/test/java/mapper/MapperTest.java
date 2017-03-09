package mapper;

import com.wqm.mybatis.dao.UserDAO;
import com.wqm.mybatis.model.UserDO;
import com.wqm.mybatis.model.UserQueryDO;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import sqlsessionfactory.MySqlSessionFactory;

import java.util.List;

/**
 * <p>文件名称：MapperTest </p>
 * <p>文件描述：</p>
 * <p>版权所有：版权所有(C)2011-2099 </p>
 * <p>公   司：口袋购物 </p>
 * <p>内容摘要：利用接口来对DB进行添删改查</p>
 * <p>其他说明：mapper接口的实现类其实是SqlSessionFactory提供的SqlSession</p>
 * <p>完成日期：2017/3/9 </p>
 *
 * @author wangqiming
 */
public class MapperTest {

    private static final Logger logger = LoggerFactory.getLogger(MapperTest.class);

    private static Integer id;

    @Before
    public void testSave() {
        SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
        Assert.assertNotNull(sqlSession);
        UserDO userDO = new UserDO();
        userDO.setUsername("zhangsan");
        userDO.setLoginname("zhangsan");
        userDO.setPassword("123456");
        userDO.setPhone("123456");
        userDO.setAddress("zhongguo-hangzhou");
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        int result = userDAO.save(userDO);
        sqlSession.commit();
        Assert.assertNotNull(result);
        id = userDO.getId();
        logger.info("userDAO.save success, result={}, id={}", result, id);
        sqlSession.close();
    }

    @Test
    public void testQueryUserList() {
        SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
        UserQueryDO userQueryDO = new UserQueryDO();
        userQueryDO.setId(id);
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        List<UserDO> list = userDAO.query(userQueryDO);
        sqlSession.commit();
        Assert.assertTrue(!CollectionUtils.isEmpty(list));
        logger.info("userDAO.query success, list={}", list.toArray());
        sqlSession.close();
    }

    @Test
    public void testQueryUserCount() {
        SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        UserQueryDO userQueryDO = new UserQueryDO();
        userQueryDO.setId(id);
        int count = userDAO.queryCount(userQueryDO);
        sqlSession.commit();
        logger.info("userDAO.queryCount success, count={}", count);
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        // 获取SqlSession
        SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
        // 获取mapper接口的实现类
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        UserDO userDO = userDAO.get(id);
        // 更新操作
        userDO.setUsername("zhangsan");
        userDO.setLoginname("zhangsan");
        userDO.setPassword("123456");
        userDO.setPhone("123456");
        userDO.setAddress("zhongguo-hangzhou");
        Integer result = userDAO.update(userDO);
        // 提交事务
        sqlSession.commit();
        Assert.assertNotNull(result);
        logger.info("sqlSession.update success, result={}", result);
        sqlSession.close();
    }

    @After
    public void testRemove() {
        SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        UserDO userDO = userDAO.get(id);
        Integer result = userDAO.remove(userDO);
        sqlSession.commit();
        Assert.assertNotNull(result);
        sqlSession.close();
    }
}
