package ch.dao;

import java.io.IOException;

import org.dom4j.DocumentException;

import junit.framework.TestCase;

public class BlogDaoTest extends TestCase {
	public void name() throws IOException, DocumentException {
		BlogDao bdBlogDao=new BlogDao();
		bdBlogDao.getOne();
		
	}
}
