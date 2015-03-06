package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wdredirect database table.
 * 
 */
@Entity
@NamedQuery(name="Wdredirect.findAll", query="SELECT w FROM Wdredirect w")
public class Wdredirect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rd_from")
	private int rdFrom;

	@Column(name="rd_fragment")
	private byte[] rdFragment;

	@Column(name="rd_interwiki")
	private byte[] rdInterwiki;

	@Column(name="rd_namespace")
	private int rdNamespace;

	@Column(name="rd_title")
	private byte[] rdTitle;

	public Wdredirect() {
	}

	public int getRdFrom() {
		return this.rdFrom;
	}

	public void setRdFrom(int rdFrom) {
		this.rdFrom = rdFrom;
	}

	public byte[] getRdFragment() {
		return this.rdFragment;
	}

	public void setRdFragment(byte[] rdFragment) {
		this.rdFragment = rdFragment;
	}

	public byte[] getRdInterwiki() {
		return this.rdInterwiki;
	}

	public void setRdInterwiki(byte[] rdInterwiki) {
		this.rdInterwiki = rdInterwiki;
	}

	public int getRdNamespace() {
		return this.rdNamespace;
	}

	public void setRdNamespace(int rdNamespace) {
		this.rdNamespace = rdNamespace;
	}

	public byte[] getRdTitle() {
		return this.rdTitle;
	}

	public void setRdTitle(byte[] rdTitle) {
		this.rdTitle = rdTitle;
	}

}