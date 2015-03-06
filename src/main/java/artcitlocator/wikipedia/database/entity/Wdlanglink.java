package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdlanglinks database table.
 * 
 */
@Entity
@Table(name="wdlanglinks")
@NamedQuery(name="Wdlanglink.findAll", query="SELECT w FROM Wdlanglink w")
public class Wdlanglink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="ll_from")
	private int llFrom;

	@Column(name="ll_lang")
	private byte[] llLang;

	@Column(name="ll_title")
	private byte[] llTitle;

	public Wdlanglink() {
	}

	public int getLlFrom() {
		return this.llFrom;
	}

	public void setLlFrom(int llFrom) {
		this.llFrom = llFrom;
	}

	public byte[] getLlLang() {
		return this.llLang;
	}

	public void setLlLang(byte[] llLang) {
		this.llLang = llLang;
	}

	public byte[] getLlTitle() {
		return this.llTitle;
	}

	public void setLlTitle(byte[] llTitle) {
		this.llTitle = llTitle;
	}

}