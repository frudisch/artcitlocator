package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wdvalid_tag database table.
 * 
 */
@Entity
@Table(name="wdvalid_tag")
@NamedQuery(name="WdvalidTag.findAll", query="SELECT w FROM WdvalidTag w")
public class WdvalidTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vt_tag")
	private String vtTag;

	public WdvalidTag() {
	}

	public String getVtTag() {
		return this.vtTag;
	}

	public void setVtTag(String vtTag) {
		this.vtTag = vtTag;
	}

}