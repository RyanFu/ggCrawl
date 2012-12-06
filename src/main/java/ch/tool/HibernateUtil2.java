package ch.tool;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil2 {
        private static final SessionFactory sessionFactory;
        
        static{
                try{
                	String path=new File(".").getCanonicalPath();
                        sessionFactory = new AnnotationConfiguration().configure(new File(path+"/hibernate2.cfg.xml")).buildSessionFactory();
                }catch (Throwable ex) {
                        System.err.println("Initial SessionFactory creation failed." + ex);
                        throw new ExceptionInInitializerError(ex);
                }
        }
        
        public static SessionFactory getSessionFactory() {
                return sessionFactory;
        }
}