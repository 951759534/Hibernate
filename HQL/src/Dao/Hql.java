package Dao;

import Entity.House;
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
        user.setuName("hh");
        user.setuBirthday(new Timestamp(new SimpleDateFormat("yyyy-mm-dd").parse("1997-01-01").getTime()));
        user.setuGender("男");
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
    @Test
    public void getAllUser(){
        SessionFactory sf = SessionBuilder.getSessionFactory();
        Session session = null;
        int pageSize = 3;
        try{
            session = sf.openSession();
            Query query = session.createQuery("select count(*) from User");
            int count = Integer.parseInt(query.uniqueResult().toString());
            System.out.println(count);
            int pages = (count%pageSize ==0)?count/pageSize:count/pageSize+1;
            for(int i = 0 ; i < pages; i++){
                        Query queryPage = session.createQuery("from User");
                        queryPage.setFirstResult(i*pageSize);
                        queryPage.setMaxResults(pageSize);
                        List users= queryPage.list();
                        for(int j = 0; j<users.size();j++){
                            User user = (User)users.get(j);
                            System.out.println(user.getuId());
                        }
            }
        }catch (Exception e){
            if(session != null){
                session.close();
            }
            e.printStackTrace();
        }
    }
    @Test
        public void getUserByPre(){
        SessionFactory sf = SessionBuilder.getSessionFactory();
        Session session = null;
        try{
            session = sf.openSession();
           Query query = session.createQuery("from User where uId = :uId");
           query.setString("uId","1");
           User user = (User) query.uniqueResult();
           System.out.println(user.getuId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
    *
    * 关于一对多
    *
    * */
    @Test
    public void saveHouse(){
        SessionFactory sf = SessionBuilder.getSessionFactory();
        Session session = null;
        Transaction ts = null;
        try{
            session = sf.openSession();
            ts = session.beginTransaction();
            User user = new User();
            user.setuName("aa");
            user.setuPassword("11");
            user.setuGender("男");
            user.setuBirthday(new Timestamp(new SimpleDateFormat("yyyy-mm-dd").parse("1997-01-01").getTime()));
            session.save(user);
            House house = new House();
            house.sethName("of aa");
            house.sethDetail("of aa");
            house.sethAddress("abc");
            house.setUser(user);
            session.save(house);
            ts.commit();
        }catch(Exception e){
            if(session != null){
                session.close();
            }
            if(ts != null){
                ts.rollback();
            }
            e.printStackTrace();
        }
    }
}
