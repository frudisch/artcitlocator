package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the valid_tag database table.
 * 
 */
@Entity
@Table(name="valid_tag")
@NamedQuery(name="ValidTag.findAll", query="SELECT v FROM ValidTag v")
public class ValidTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vt_tag")
	private String vtTag;

	public ValidTag() {
	}

	public String getVtTag() {
		return this.vtTag;
	}

	public void setVtTag(String vtTag) {
		this.vtTag = vtTag;
	}

}