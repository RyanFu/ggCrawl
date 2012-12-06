package ch.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="NovelPage")
public class NovelPage {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
	public int id;
	
	@Column(unique=true)
  public String url;

  public boolean isGet;
  public int novel_Id;
  public String titel;

  @Column(length = 16777216)
  public String content;

  public int position;

}