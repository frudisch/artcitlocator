package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the langlinks database table.
 * 
 */
@Entity
@Table(name="langlinks")
@NamedQuery(name="Langlink.findAll", query="SELECT l FROM Langlink l")
public class Langlink implements Serializable {
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
	private String llTitle;

	public Langlink() {
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

	public String getLlTitle() {
		return this.llTitle;
	}

	public void setLlTitle(String llTitle) {
		this.llTitle = llTitle;
	}

}