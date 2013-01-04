package ch.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PostTitle {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
	public int id;
	
@Column(unique=true)
  public String post_tittle;
  

}