package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the templatelinks database table.
 * 
 */
@Entity
@Table(name="templatelinks")
@NamedQuery(name="Templatelink.findAll", query="SELECT t FROM Templatelink t")
public class Templatelink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="tl_from")
	private int tlFrom;

	@Column(name="tl_namespace")
	private int tlNamespace;

	@Column(name="tl_title")
	private String tlTitle;

	public Templatelink() {
	}

	public int getTlFrom() {
		return this.tlFrom;
	}

	public void setTlFrom(int tlFrom) {
		this.tlFrom = tlFrom;
	}

	public int getTlNamespace() {
		return this.tlNamespace;
	}

	public void setTlNamespace(int tlNamespace) {
		this.tlNamespace = tlNamespace;
	}

	public String getTlTitle() {
		return this.tlTitle;
	}

	public void setTlTitle(String tlTitle) {
		this.tlTitle = tlTitle;
	}

}