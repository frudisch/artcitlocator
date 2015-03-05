package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdsearchindex database table.
 * 
 */
@Entity
@NamedQuery(name="Wdsearchindex.findAll", query="SELECT w FROM Wdsearchindex w")
public class Wdsearchindex implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="si_page")
	private int siPage;

	@Lob
	@Column(name="si_text")
	private String siText;

	@Column(name="si_title")
	private String siTitle;

	public Wdsearchindex() {
	}

	public int getSiPage() {
		return this.siPage;
	}

	public void setSiPage(int siPage) {
		this.siPage = siPage;
	}

	public String getSiText() {
		return this.siText;
	}

	public void setSiText(String siText) {
		this.siText = siText;
	}

	public String getSiTitle() {
		return this.siTitle;
	}

	public void setSiTitle(String siTitle) {
		this.siTitle = siTitle;
	}

}