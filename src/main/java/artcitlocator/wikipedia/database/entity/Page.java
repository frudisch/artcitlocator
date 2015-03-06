package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the page database table.
 * 
 */
@Entity
@NamedQuery(name="Page.findAll", query="SELECT p FROM Page p")
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="page_id")
	private int pageId;

	@Column(name="page_counter")
	private BigInteger pageCounter;

	@Column(name="page_is_new")
	private byte pageIsNew;

	@Column(name="page_is_redirect")
	private byte pageIsRedirect;

	@Column(name="page_latest")
	private int pageLatest;

	@Column(name="page_len")
	private int pageLen;

	@Column(name="page_namespace")
	private int pageNamespace;

	@Column(name="page_random")
	private double pageRandom;

	@Lob
	@Column(name="page_restrictions")
	private byte[] pageRestrictions;

	@Column(name="page_title")
	private String pageTitle;

	@Column(name="page_touched")
	private byte[] pageTouched;

	public Page() {
	}

	public int getPageId() {
		return this.pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public BigInteger getPageCounter() {
		return this.pageCounter;
	}

	public void setPageCounter(BigInteger pageCounter) {
		this.pageCounter = pageCounter;
	}

	public byte getPageIsNew() {
		return this.pageIsNew;
	}

	public void setPageIsNew(byte pageIsNew) {
		this.pageIsNew = pageIsNew;
	}

	public byte getPageIsRedirect() {
		return this.pageIsRedirect;
	}

	public void setPageIsRedirect(byte pageIsRedirect) {
		this.pageIsRedirect = pageIsRedirect;
	}

	public int getPageLatest() {
		return this.pageLatest;
	}

	public void setPageLatest(int pageLatest) {
		this.pageLatest = pageLatest;
	}

	public int getPageLen() {
		return this.pageLen;
	}

	public void setPageLen(int pageLen) {
		this.pageLen = pageLen;
	}

	public int getPageNamespace() {
		return this.pageNamespace;
	}

	public void setPageNamespace(int pageNamespace) {
		this.pageNamespace = pageNamespace;
	}

	public double getPageRandom() {
		return this.pageRandom;
	}

	public void setPageRandom(double pageRandom) {
		this.pageRandom = pageRandom;
	}

	public byte[] getPageRestrictions() {
		return this.pageRestrictions;
	}

	public void setPageRestrictions(byte[] pageRestrictions) {
		this.pageRestrictions = pageRestrictions;
	}

	public String getPageTitle() {
		return this.pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	public byte[] getPageTouched() {
		return this.pageTouched;
	}

	public void setPageTouched(byte[] pageTouched) {
		this.pageTouched = pageTouched;
	}

}