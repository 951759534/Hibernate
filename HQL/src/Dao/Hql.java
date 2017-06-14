package Dao;

import Entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by K550jk on 2017/6/13.
 */
public class Hql {
        @Test
        public void SaveUser() throws ParseException {
        SessionFactory sf= SessionBuilder.getSessionFactory();
        User user = new User();
        user.setuName("aa");
        user.setuBirthday(new Timestamp(new SimpleDateFormat("yyyy-mm-dd").parse("1997-01-01").getTime()));
        user.setuGender("女");
        user.setuPassword("11");
        Session session = null;
        Transaction ts = null;
        try{
            session = sf.openSession();
            ts = session.beginTransaction();
            session.save(user);
            ts.commit();
        }catch (Exception e){
            if(session != null){
                session.close();
            }
            if(ts != null){
                ts.rollback();
            }
            e.printStackTrace();

        }finally {
            session.close();
        }
        }


    @Test
        public void getUser() {
        SessionFactory sf = SessionBuilder.getSessionFactory();
        Session session = null;
        try{
            session = sf.openSession();
            Query query = session.createQuery("from User");
            List users = query.list();
            for(int i = 0 ; i < users.size(); i++){
                User user = (User)users.get(i);
                System.out.println(user.getuName());
            }
        }catch (Exception e){
            e.printStackTrace();
            if(session !=null){
                session.close();
            }
        }
    }
    @Test
        public void getUser_name_pass(){
            SessionFactory sf = SessionBuilder.getSessionFactory();
            Session session = null;
            try{
                session = sf.openSession();
                Query query = session.createQuery("select u.uName,u.uPassword from User u");
                List users = query.list();
                for(int i = 0; i < users.size(); i++){
                    Object[] user = (Object[])users.get(i);
                    System.out.println(user[0] + "------" + user[1]);
                }
            }catch (Exception e){
                if(session != null){
                    session.close();
                }
                e.printStackTrace();
            }
    }
    @Test
    public void getDistinct_name(){
            SessionFactory sf = SessionBuilder.getSessionFactory();
            Session session = null;
            try{
                session = sf.openSession();
                Query query = session.createQuery("select distinct u.uName,u.uGender  from User u");
                List users = query.list();
                for(int i = 0; i < users.size(); i++){
                    Object[] user = (Object[])users.get(i);
                    System.out.println(user[0] +"------------------"+user[1]);
                }
            }catch (Exception e){
                if(session != null){
                    session.close();
                }
                e.printStackTrace();
            }finally {
                session.close();
            }
    }
    @Test
    public void updateName(){
        SessionFactory sf = SessionBuilder.getSessionFactory();
        Session session = null;
        Transaction ts = null;
        try{
            session = sf.openSession();
            ts = session.beginTransaction();
            Query query = session.createQuery("update User  set uPassword = '22'  where uId = 6");
            query.executeUpdate();
            ts.commit();
        }catch (Exception e){
            e.printStackTrace();
            if(session != null){
                session.close();
            }
            if( ts != null ){
                ts.rollback();
            }
        }finally {
            session.close();
        }
    }
    @Test
    public void getCount(){
        SessionFactory sf = SessionBuilder.getSessionFactory();
        Session session = null;
        try{
            session = sf.openSession();
            Query query = session.createQuery("select count(*) from User");
            Object count = query.uniqueResult();
            System.out.println("共有"+count+"条");
        }catch (Exception e){
            if(session != null){
                session.close();
            }
            e.printStackTrace();
        }
    }
}
