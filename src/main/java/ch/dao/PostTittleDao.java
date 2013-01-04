package ch.dao;

import java.util.List;

import org.hibernate.Query;



import ch.po.NovelPage;
import ch.po.PostTitle;


public class PostTittleDao extends SimpleBaseDao {
	
	public boolean isHave(String s) {
		Query q=this.session.createQuery("from PostTitle where post_tittle=?");
		q.setString(0, s);
		
		this.transaction.commit();
		List<PostTitle> ql=q.list();
		this.session.close();
		if (ql.size()>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		PostTittleDao ptd=new PostTittleDao();
		String s="看看id是不是慢慢增加";
		ptd.isHave(s);
	}
	private void test_add() {
		ch.po.PostTitle pt=new ch.po.PostTitle();
		pt.post_tittle="看看id是不是慢慢增加";
		ch.dao.SimpleBaseDao sbd=new ch.dao.SimpleBaseDao();
		sbd.save(pt);
		sbd.close();
	}
}
