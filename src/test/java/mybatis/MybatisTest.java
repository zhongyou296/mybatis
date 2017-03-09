package mybatis;

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
 * <p>文件名称：MybatisTest </p>
 * <p>文件描述：</p>
 * <p>版权所有：版权所有(C)2011-2099 </p>
 * <p>公   司：口袋购物 </p>
 * <p>内容摘要：利用Mybatis的SqlSession对DB进行添删改查</p>
 * <p>其他说明：SqlSession是Mybatis中执行持久化操作的对象,类似于JDBC中的Connection</p>
 * <p>完成日期：2017/3/9 </p>
 *
 * @author wangqiming
 */
public class MybatisTest {

    private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);

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
        Integer result = sqlSession.insert("com.wqm.mybatis.dao.UserDAO.save", userDO);
        sqlSession.commit();
        Assert.assertNotNull(result);
        id = userDO.getId();
        logger.info("sqlSession.insert success, result={}, id={}", result, id);
        sqlSession.close();
    }

    @Test
    public void testQueryUserList() {
        SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
        UserQueryDO userQueryDO = new UserQueryDO();
        userQueryDO.setId(id);
        List<UserDO> list = sqlSession.selectList("com.wqm.mybatis.dao.UserDAO.query", userQueryDO);
        sqlSession.commit();
        Assert.assertTrue(!CollectionUtils.isEmpty(list));
        logger.info("sqlSession.selectList success, list={}", list.toArray());
        sqlSession.close();
    }

    @Test
    public void testQueryUserCount() {
        SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
        UserQueryDO userQueryDO = new UserQueryDO();
        userQueryDO.setId(id);
        int count = sqlSession.selectOne("com.wqm.mybatis.dao.UserDAO.queryCount", userQueryDO);
        sqlSession.commit();
        logger.info("sqlSession.selectOne success, count={}", count);
        sqlSession.close();

    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
        UserDO userDO = sqlSession.selectOne("com.wqm.mybatis.dao.UserDAO.get", id);
        userDO.setUsername("zhangsan");
        userDO.setLoginname("zhangsan");
        userDO.setPassword("123456");
        userDO.setPhone("123456");
        userDO.setAddress("zhongguo-hangzhou");
        Integer result = sqlSession.update("com.wqm.mybatis.dao.UserDAO.update", userDO);
        sqlSession.commit();
        Assert.assertNotNull(result);
        logger.info("sqlSession.update success, result={}", result);
        sqlSession.close();
    }

    @After
    public void testRemove() {
        SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
        UserDO userDO = sqlSession.selectOne("com.wqm.mybatis.dao.UserDAO.get", id);
        Integer result = sqlSession.delete("com.wqm.mybatis.dao.UserDAO.remove", userDO);
        sqlSession.commit();
        Assert.assertNotNull(result);
        sqlSession.commit();
        logger.info("sqlSession.delete success, result={}", result);
        sqlSession.close();
    }
}
