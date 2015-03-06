package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;


/**
 * The persistent class for the wdsite_stats database table.
 * 
 */
@Entity
@Table(name="wdsite_stats")
@NamedQuery(name="WdsiteStat.findAll", query="SELECT w FROM WdsiteStat w")
public class WdsiteStat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="ss_active_users")
	private BigInteger ssActiveUsers;

	@Column(name="ss_good_articles")
	private BigInteger ssGoodArticles;

	@Column(name="ss_images")
	private int ssImages;

	@Column(name="ss_row_id")
	private int ssRowId;

	@Column(name="ss_total_edits")
	private BigInteger ssTotalEdits;

	@Column(name="ss_total_pages")
	private BigInteger ssTotalPages;

	@Column(name="ss_total_views")
	private BigInteger ssTotalViews;

	@Column(name="ss_users")
	private BigInteger ssUsers;

	public WdsiteStat() {
	}

	public BigInteger getSsActiveUsers() {
		return this.ssActiveUsers;
	}

	public void setSsActiveUsers(BigInteger ssActiveUsers) {
		this.ssActiveUsers = ssActiveUsers;
	}

	public BigInteger getSsGoodArticles() {
		return this.ssGoodArticles;
	}

	public void setSsGoodArticles(BigInteger ssGoodArticles) {
		this.ssGoodArticles = ssGoodArticles;
	}

	public int getSsImages() {
		return this.ssImages;
	}

	public void setSsImages(int ssImages) {
		this.ssImages = ssImages;
	}

	public int getSsRowId() {
		return this.ssRowId;
	}

	public void setSsRowId(int ssRowId) {
		this.ssRowId = ssRowId;
	}

	public BigInteger getSsTotalEdits() {
		return this.ssTotalEdits;
	}

	public void setSsTotalEdits(BigInteger ssTotalEdits) {
		this.ssTotalEdits = ssTotalEdits;
	}

	public BigInteger getSsTotalPages() {
		return this.ssTotalPages;
	}

	public void setSsTotalPages(BigInteger ssTotalPages) {
		this.ssTotalPages = ssTotalPages;
	}

	public BigInteger getSsTotalViews() {
		return this.ssTotalViews;
	}

	public void setSsTotalViews(BigInteger ssTotalViews) {
		this.ssTotalViews = ssTotalViews;
	}

	public BigInteger getSsUsers() {
		return this.ssUsers;
	}

	public void setSsUsers(BigInteger ssUsers) {
		this.ssUsers = ssUsers;
	}

}