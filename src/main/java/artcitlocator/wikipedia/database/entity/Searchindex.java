package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the searchindex database table.
 * 
 */
@Entity
@NamedQuery(name="Searchindex.findAll", query="SELECT s FROM Searchindex s")
public class Searchindex implements Serializable {
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

	public Searchindex() {
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