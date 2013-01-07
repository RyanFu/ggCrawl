package ch.po;

import java.util.List;

public class Blog {
	private String xmlRpcUrl;
	private String userName;
	private String password;
	private List<String> cats;
	public List<String> getCats() {
		return cats;
	}
	public void setCats(List<String> cats) {
		this.cats = cats;
	}
	public String getXmlRpcUrl() {
		return xmlRpcUrl;
	}
	public void setXmlRpcUrl(String xmlRpcUrl) {
		this.xmlRpcUrl = xmlRpcUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
