package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wdcategory database table.
 * 
 */
@Entity
@NamedQuery(name="Wdcategory.findAll", query="SELECT w FROM Wdcategory w")
public class Wdcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;

	@Column(name="cat_files")
	private int catFiles;

	@Column(name="cat_pages")
	private int catPages;

	@Column(name="cat_subcats")
	private int catSubcats;

	@Column(name="cat_title")
	private byte[] catTitle;

	public Wdcategory() {
	}

	public int getCatId() {
		return this.catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getCatFiles() {
		return this.catFiles;
	}

	public void setCatFiles(int catFiles) {
		this.catFiles = catFiles;
	}

	public int getCatPages() {
		return this.catPages;
	}

	public void setCatPages(int catPages) {
		this.catPages = catPages;
	}

	public int getCatSubcats() {
		return this.catSubcats;
	}

	public void setCatSubcats(int catSubcats) {
		this.catSubcats = catSubcats;
	}

	public byte[] getCatTitle() {
		return this.catTitle;
	}

	public void setCatTitle(byte[] catTitle) {
		this.catTitle = catTitle;
	}

}