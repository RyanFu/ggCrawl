package ch.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ch.po.Novel;
import ch.po.Student;
import ch.tool.HibernateUtil;

public class NovelDao{

        @SuppressWarnings("unchecked")
		public List<Novel> getAll(){
        	List<Novel> novels = null;
        	Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            
          
                    transaction = session.beginTransaction();
                    
                    novels = session.createQuery("from Novel").list();
//                    for(Iterator<Novel> ite = novels.iterator(); ite.hasNext();){
//                    	Novel novel = ite.next();
//                            System.out.println(novel.novelName);
//                    }
                   
                    transaction.commit();
            
                    System.out.println("get all novels");
                
                    session.close();
           
			return novels;

        }
        public Novel getById(int id){
        	Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            transaction = session.beginTransaction();
            Novel nv = (Novel)session.get(Novel.class, id);
            transaction.commit();
            session.close();
            return nv;
        }
        
}