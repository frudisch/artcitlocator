package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdsite_identifiers database table.
 * 
 */
@Entity
@Table(name="wdsite_identifiers")
@NamedQuery(name="WdsiteIdentifier.findAll", query="SELECT w FROM WdsiteIdentifier w")
public class WdsiteIdentifier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="si_key")
	private byte[] siKey;

	@Column(name="si_site")
	private int siSite;

	@Column(name="si_type")
	private byte[] siType;

	public WdsiteIdentifier() {
	}

	public byte[] getSiKey() {
		return this.siKey;
	}

	public void setSiKey(byte[] siKey) {
		this.siKey = siKey;
	}

	public int getSiSite() {
		return this.siSite;
	}

	public void setSiSite(int siSite) {
		this.siSite = siSite;
	}

	public byte[] getSiType() {
		return this.siType;
	}

	public void setSiType(byte[] siType) {
		this.siType = siType;
	}

}