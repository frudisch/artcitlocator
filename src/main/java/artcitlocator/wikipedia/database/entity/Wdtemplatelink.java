package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdtemplatelinks database table.
 * 
 */
@Entity
@Table(name="wdtemplatelinks")
@NamedQuery(name="Wdtemplatelink.findAll", query="SELECT w FROM Wdtemplatelink w")
public class Wdtemplatelink implements Serializable {
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
	private byte[] tlTitle;

	public Wdtemplatelink() {
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

	public byte[] getTlTitle() {
		return this.tlTitle;
	}

	public void setTlTitle(byte[] tlTitle) {
		this.tlTitle = tlTitle;
	}

}