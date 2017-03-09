package user;

import com.wqm.mybatis.model.UserDO;
import com.wqm.mybatis.model.UserQueryDO;
import com.wqm.mybatis.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>文件名称：UserServiceTest </p>
 * <p>文件描述：</p>
 * <p>版权所有：版权所有(C)2011-2099 </p>
 * <p>公   司：口袋购物 </p>
 * <p>内容摘要：利用Spring的IOC容器来对DB进行添删改查的操作</p>
 * <p>其他说明：</p>
 * <p>完成日期：2017/3/8 </p>
 *
 * @author wangqiming
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/bean-all.xml")
public class UserServiceTest extends BaseSpringTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Resource
    private UserService userService;

    private static Integer id;

    @Before
    public void testSave() {
        UserDO userDO = new UserDO();
        userDO.setUsername("zhangsan");
        userDO.setLoginname("zhangsan");
        userDO.setPassword("123456");
        userDO.setPhone("123456");
        userDO.setAddress("zhongguo-hangzhou");
        Integer result = userService.saveUser(userDO);
        Assert.assertNotNull(result);
        id = userDO.getId();
        logger.info("userService.saveUser success, result={}, id={}", result, id);
    }

    @Test
    public void testQueryUserList() {
        UserQueryDO userQueryDO = new UserQueryDO();
        userQueryDO.setId(id);
        List<UserDO> list = userService.queryUserList(userQueryDO);
        Assert.assertTrue(!CollectionUtils.isEmpty(list));
        logger.info("userService.queryUserList success, list={}", list.toArray());
    }

    @Test
    public void testUpdateUser() {
        UserDO userDO = userService.get(id);
        userDO.setUsername("lisi");
        userDO.setLoginname("lisi");
        userDO.setPassword("123456");
        userDO.setPhone("123456");
        userDO.setAddress("zhongguo-hangzhou");
        Integer result = userService.updateUser(userDO);
        Assert.assertNotNull(result);
        logger.info("userService.updateUser success, result={}", result);
    }

    @Test
    public void testQueryUserCount() {
        UserQueryDO userQueryDO = new UserQueryDO();
        userQueryDO.setId(id);
        Integer count = userService.queryUserCount(userQueryDO);
        Assert.assertNotNull(count);
        logger.info("userService.queryUserCount success, count={}", count);
        logger.info("count={}", count);
    }

    @After
    public void testRemove() {
        UserDO userDO = userService.get(id);
        int result = userService.removeUser(userDO);
        Assert.assertNotNull(result);
        logger.info("userService.removeUser success, result={}", result);
    }
}
