package com.holdyourdrea.wp;

public class BlogInfo {
	  private String userName;
	  private String password;
	  private int blogId;
	  private String url;
	  public BlogInfo(String url, String userName,
	      String password, int blogId2) {
	    this.url = url;
	    this.userName = userName;
	    this.password = password;
	    this.blogId = blogId2;
	  }


	  public int getBlogId() {
	    return blogId;
	  }
	  public String getPassword() {
	    return password;
	  }
	  public String getUserName() {
	    return userName;
	  }


	public String getUrl() {
		return url;
	}

	}