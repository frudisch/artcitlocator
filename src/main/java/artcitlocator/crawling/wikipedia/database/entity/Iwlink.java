package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the iwlinks database table.
 * 
 */
@Entity
@Table(name="iwlinks")
@NamedQuery(name="Iwlink.findAll", query="SELECT i FROM Iwlink i")
public class Iwlink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="iwl_from")
	private int iwlFrom;

	@Column(name="iwl_prefix")
	private byte[] iwlPrefix;

	@Column(name="iwl_title")
	private String iwlTitle;

	public Iwlink() {
	}

	public int getIwlFrom() {
		return this.iwlFrom;
	}

	public void setIwlFrom(int iwlFrom) {
		this.iwlFrom = iwlFrom;
	}

	public byte[] getIwlPrefix() {
		return this.iwlPrefix;
	}

	public void setIwlPrefix(byte[] iwlPrefix) {
		this.iwlPrefix = iwlPrefix;
	}

	public String getIwlTitle() {
		return this.iwlTitle;
	}

	public void setIwlTitle(String iwlTitle) {
		this.iwlTitle = iwlTitle;
	}

}