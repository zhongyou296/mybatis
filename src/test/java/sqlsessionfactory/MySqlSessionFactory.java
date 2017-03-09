package sqlsessionfactory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>文件名称：MySqlSessionFactory </p>
 * <p>文件描述：</p>
 * <p>版权所有：版权所有(C)2011-2099 </p>
 * <p>公   司：口袋购物 </p>
 * <p>内容摘要：创建SqlSession的工厂类</p>
 * <p>其他说明：SqlSessionFactory是单个数据库映射关系经过编译后的内存镜像</p>
 * <p>完成日期：2017/3/9 </p>
 *
 * @author wangqiming
 */
public class MySqlSessionFactory {

    private static final Logger logger = LoggerFactory.getLogger(MySqlSessionFactory.class);

    private static SqlSessionFactory sqlSessionFactory;

    private static String resource = "mybatis-config.xml";

    static {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            logger.error("Resources.getResourceAsStream error, resource={} ,e={}", resource, e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
