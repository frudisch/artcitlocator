package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdl10n_cache database table.
 * 
 */
@Entity
@Table(name="wdl10n_cache")
@NamedQuery(name="Wdl10nCache.findAll", query="SELECT w FROM Wdl10nCache w")
public class Wdl10nCache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="lc_key")
	private byte[] lcKey;

	@Column(name="lc_lang")
	private byte[] lcLang;

	@Lob
	@Column(name="lc_value")
	private byte[] lcValue;

	public Wdl10nCache() {
	}

	public byte[] getLcKey() {
		return this.lcKey;
	}

	public void setLcKey(byte[] lcKey) {
		this.lcKey = lcKey;
	}

	public byte[] getLcLang() {
		return this.lcLang;
	}

	public void setLcLang(byte[] lcLang) {
		this.lcLang = lcLang;
	}

	public byte[] getLcValue() {
		return this.lcValue;
	}

	public void setLcValue(byte[] lcValue) {
		this.lcValue = lcValue;
	}

}