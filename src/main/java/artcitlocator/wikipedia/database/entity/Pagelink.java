package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the pagelinks database table.
 * 
 */
@Entity
@Table(name="pagelinks")
@NamedQuery(name="Pagelink.findAll", query="SELECT p FROM Pagelink p")
public class Pagelink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="pl_from")
	private int plFrom;

	@Column(name="pl_namespace")
	private int plNamespace;

	@Column(name="pl_title")
	private String plTitle;

	public Pagelink() {
	}

	public int getPlFrom() {
		return this.plFrom;
	}

	public void setPlFrom(int plFrom) {
		this.plFrom = plFrom;
	}

	public int getPlNamespace() {
		return this.plNamespace;
	}

	public void setPlNamespace(int plNamespace) {
		this.plNamespace = plNamespace;
	}

	public String getPlTitle() {
		return this.plTitle;
	}

	public void setPlTitle(String plTitle) {
		this.plTitle = plTitle;
	}

}