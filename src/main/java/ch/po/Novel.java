package ch.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="novel")
public class Novel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
	public int id;

  public String novelIndexUrl;
  
  public String novelEncoding;
  @Column(unique=true)
  public String novelName;

  public String novelDescript;

  public String pageRule;
  public String pagePreUrl;
  public String titleRule;

  public String contentRule;

  public String dbHost;

  public String dbUserName;

  public String dbUserPassword;
  
  
  public String dbName;



}