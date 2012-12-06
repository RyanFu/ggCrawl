package ch.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ch.po.Student;
import ch.tool.HibernateUtil;

public class StudentDao {

        public static void main(String[] args) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = null;
                
                try{
                        transaction = session.beginTransaction();
                        
                        List<Student> students = session.createQuery("from Student").list();
                        for(Iterator<Student> ite = students.iterator(); ite.hasNext();){
                                Student student = ite.next();
                                System.out.println(student.toString());
                        }
                        transaction.commit();
                        
                }catch(HibernateException e){
                        transaction.rollback();
                        e.printStackTrace();
                } finally{
                        session.close();
                }

        }
}