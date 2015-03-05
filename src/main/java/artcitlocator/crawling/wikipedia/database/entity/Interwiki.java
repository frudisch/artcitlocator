package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the interwiki database table.
 * 
 */
@Entity
@NamedQuery(name="Interwiki.findAll", query="SELECT i FROM Interwiki i")
public class Interwiki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Lob
	@Column(name="iw_api")
	private byte[] iwApi;

	@Column(name="iw_local")
	private byte iwLocal;

	@Column(name="iw_prefix")
	private String iwPrefix;

	@Column(name="iw_trans")
	private byte iwTrans;

	@Lob
	@Column(name="iw_url")
	private byte[] iwUrl;

	@Column(name="iw_wikiid")
	private String iwWikiid;

	public Interwiki() {
	}

	public byte[] getIwApi() {
		return this.iwApi;
	}

	public void setIwApi(byte[] iwApi) {
		this.iwApi = iwApi;
	}

	public byte getIwLocal() {
		return this.iwLocal;
	}

	public void setIwLocal(byte iwLocal) {
		this.iwLocal = iwLocal;
	}

	public String getIwPrefix() {
		return this.iwPrefix;
	}

	public void setIwPrefix(String iwPrefix) {
		this.iwPrefix = iwPrefix;
	}

	public byte getIwTrans() {
		return this.iwTrans;
	}

	public void setIwTrans(byte iwTrans) {
		this.iwTrans = iwTrans;
	}

	public byte[] getIwUrl() {
		return this.iwUrl;
	}

	public void setIwUrl(byte[] iwUrl) {
		this.iwUrl = iwUrl;
	}

	public String getIwWikiid() {
		return this.iwWikiid;
	}

	public void setIwWikiid(String iwWikiid) {
		this.iwWikiid = iwWikiid;
	}

}