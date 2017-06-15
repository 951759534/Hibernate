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
        SchemaExport se = new SchemaExport(cfg);     //这里在Hibernate 5.0版本有点修改 参考https://www.zhihu.com/question/35168658
        se.create(true,true);   // 创建表结构. 第一个true 表示在控制台打印sql语句, 第二个true 表示导入sql语句到数据库
    }
}
