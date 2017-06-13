package org;

/**
 * Created by K550jk on 2017/4/28.
 */
import org.Enity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.sql.Date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class test {


    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Test
    public void test() throws ParseException {
        System.out.println("test....");

        //1. 创建配置对象
        Configuration config = new Configuration().configure("Hibernate.xml");
        //2. 创建服务注册对象
        //3. 创建会话工厂对象
        sessionFactory = config.buildSessionFactory();
        //4. 会话对象
        session = sessionFactory.openSession();
        //5. 开启事务
        transaction = session.beginTransaction();

        //6. 生成专业对象
        UserEntity user = new UserEntity();
        user.setuName("11");
        user.setuAge("11");
        user.setuDate(new Timestamp(new SimpleDateFormat("YYYY-MM-DD").parse("1990-01-01").getTime()));
        session.save(user);
        //7. 保存对象进入数据库
        //8. 提交事务
        transaction.commit();
        //9. 关闭会话
        session.close();
        //10. 关闭会话工厂
        sessionFactory.close();
    }
}