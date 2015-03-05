package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cat_id")
	private int catId;

	@Column(name="cat_files")
	private int catFiles;

	@Column(name="cat_hidden")
	private byte catHidden;

	@Column(name="cat_pages")
	private int catPages;

	@Column(name="cat_subcats")
	private int catSubcats;

	@Column(name="cat_title")
	private String catTitle;

	public Category() {
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

	public byte getCatHidden() {
		return this.catHidden;
	}

	public void setCatHidden(byte catHidden) {
		this.catHidden = catHidden;
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

	public String getCatTitle() {
		return this.catTitle;
	}

	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}

}