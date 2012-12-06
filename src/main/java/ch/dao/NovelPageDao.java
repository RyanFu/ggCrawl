package ch.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ch.po.Novel;
import ch.po.NovelPage;
import ch.po.Student;
import ch.tool.HibernateUtil;

public class NovelPageDao {
	private Session session =null;
	private Transaction transaction = null;

        public NovelPageDao(){
        	this.session = HibernateUtil.getSessionFactory().openSession();

        }
        public void insert(NovelPage nv){
        	try{
                //transaction = session.beginTransaction();
                session.save(nv);
                //transaction.commit();
                }catch(HibernateException e){
                    //transaction.rollback();
                    e.printStackTrace();
            }
        	//session.save(nv);
        	//session应该都是外面传入的
        	
        }
        public void updata(NovelPage nv){
        	try{
                transaction = session.beginTransaction();
                session.update(nv);
                transaction.commit();
                }catch(HibernateException e){
                    //transaction.rollback();
                    e.printStackTrace();
            }
        }
        public void close(){
        	this.session.close();
        }
        public List<NovelPage> getAll_noFinished(int novelID){
        	List<NovelPage> nps=null;
        	//Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            
            try{
                    transaction = session.beginTransaction();
                    
                    nps = session.createQuery("from NovelPage where isGet='false' and novel_Id='"+novelID+"'").list();
//                    for(Iterator<NovelPage> ite = nps.iterator(); ite.hasNext();){
//                    	NovelPage novel = ite.next();
//                    	
//                            System.out.println(novel.url);
//                    }
                    transaction.commit();
            }catch(HibernateException e){
                    transaction.rollback();
                    e.printStackTrace();
            } 
			return nps;

        }
}