package ch.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch.po.Novel;
import ch.tool.HibernateUtil;

public class SimpleBaseDao {
	Session session=null;
	Transaction transaction=null;
	public Session getSession() {
		return session;
	}

	
	SimpleBaseDao(){
		this.session = HibernateUtil.getSessionFactory().openSession();
        this.transaction=session.beginTransaction();
	}
	public Object getById(Class<?> e,int id){
        Object nv = session.get(e, id);
        transaction.commit();
        session.close();
        return nv;
    }
	public void save(Object e){
		session.save(e);
	}
	public void delect(Object e){
		session.delete(e);
	}
	public void update(Object e){
		session.update(e);
	}

	public void close(){
		transaction.commit();
        session.close();
	}
}
