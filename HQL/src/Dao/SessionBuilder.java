package Dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Created by K550jk on 2017/6/13.
 */
public class SessionBuilder {
    private static SessionFactory sf = null;
    static {
        try{
            Configuration cfg = new Configuration();
            cfg.configure("HibernateCon.xml");
            StandardServiceRegistryBuilder SSRB = new StandardServiceRegistryBuilder();
            ServiceRegistry sr = (ServiceRegistry) SSRB.applySettings(cfg.getProperties()).build();
            sf = cfg.buildSessionFactory(sr);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static SessionFactory getSessionFactory(){
        return sf;
    }
}
