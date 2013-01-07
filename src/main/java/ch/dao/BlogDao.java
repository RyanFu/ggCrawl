package ch.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import ch.po.Blog;
import ch.po.NewsSource;

import com.holdyourdream.util.dom4jHelper;

public class BlogDao {
	private List<Blog> list=null;
	public BlogDao() throws IOException, DocumentException {
		dom4jHelper djHelper=new dom4jHelper("blogs.xml");
		Element root=djHelper.getRootElement();
		list=new ArrayList();
		
		for(Object i:root.elements()){
			Element s=(Element)i;
			Blog bg=new Blog();
			//Node node=s.element("list_url");
			bg.setPassword(s.element("password").getText());
			bg.setUserName(s.element("userName").getText());
			bg.setXmlRpcUrl(s.element("xmlRpcUrl").getText());
			
			List  catsNodeElement=  s.element("cats").elements("cat");
			List<String> catsList=null;
			for(Object c:catsNodeElement){
				Element iElement=(Element)c;
				//System.out.println(iElement.getText());
				catsList.add(iElement.getText());
			}
			bg.setCats(catsList);
			
			

			list.add(bg);
		}
	}
	public Blog getOne() {
		int index = (int) (Math.random() * this.list.size());
		return this.list.get(index);
	}
	
}
