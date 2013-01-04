package ch.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
	public int id;
	
@Column(unique=true)
  public String keyname;
  
  @Column(length = 16777216)
  public String content=null;
  
  public String iframeUrl;
  
  public Boolean haveContent=false;
}