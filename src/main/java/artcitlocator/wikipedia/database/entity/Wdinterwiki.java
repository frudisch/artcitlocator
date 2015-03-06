package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdinterwiki database table.
 * 
 */
@Entity
@NamedQuery(name="Wdinterwiki.findAll", query="SELECT w FROM Wdinterwiki w")
public class Wdinterwiki implements Serializable {
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
	private byte[] iwPrefix;

	@Column(name="iw_trans")
	private byte iwTrans;

	@Lob
	@Column(name="iw_url")
	private byte[] iwUrl;

	@Column(name="iw_wikiid")
	private byte[] iwWikiid;

	public Wdinterwiki() {
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

	public byte[] getIwPrefix() {
		return this.iwPrefix;
	}

	public void setIwPrefix(byte[] iwPrefix) {
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

	public byte[] getIwWikiid() {
		return this.iwWikiid;
	}

	public void setIwWikiid(byte[] iwWikiid) {
		this.iwWikiid = iwWikiid;
	}

}