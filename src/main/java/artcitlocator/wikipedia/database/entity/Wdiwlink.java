package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdiwlinks database table.
 * 
 */
@Entity
@Table(name="wdiwlinks")
@NamedQuery(name="Wdiwlink.findAll", query="SELECT w FROM Wdiwlink w")
public class Wdiwlink implements Serializable {
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
	private byte[] iwlTitle;

	public Wdiwlink() {
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

	public byte[] getIwlTitle() {
		return this.iwlTitle;
	}

	public void setIwlTitle(byte[] iwlTitle) {
		this.iwlTitle = iwlTitle;
	}

}