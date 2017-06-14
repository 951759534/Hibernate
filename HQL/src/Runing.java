import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Created by K550jk on 2017/6/13.
 */
public class Runing {
    public static void main(String args[]){
  /*      Configuration cfg = new Configuration();
        cfg.configure();
        StandardServiceRegistryBuilder SSRB = new StandardServiceRegistryBuilder();
        ServiceRegistry sr = SSRB.applySettings(cfg.getProperties()).build();
        SessionFactory sf = cfg.buildSessionFactory(sr);*/
        Configuration cfg = new Configuration();
        cfg.configure("HibernateCon.xml");
        SchemaExport se = new SchemaExport(cfg);
        se.create(true,true);
    }
}
