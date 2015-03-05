package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the l10n_cache database table.
 * 
 */
@Entity
@Table(name="l10n_cache")
@NamedQuery(name="L10nCache.findAll", query="SELECT l FROM L10nCache l")
public class L10nCache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="lc_key")
	private String lcKey;

	@Column(name="lc_lang")
	private byte[] lcLang;

	@Lob
	@Column(name="lc_value")
	private byte[] lcValue;

	public L10nCache() {
	}

	public String getLcKey() {
		return this.lcKey;
	}

	public void setLcKey(String lcKey) {
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