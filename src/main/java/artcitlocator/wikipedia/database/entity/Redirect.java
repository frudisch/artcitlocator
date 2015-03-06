package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the redirect database table.
 * 
 */
@Entity
@NamedQuery(name="Redirect.findAll", query="SELECT r FROM Redirect r")
public class Redirect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rd_from")
	private int rdFrom;

	@Column(name="rd_fragment")
	private String rdFragment;

	@Column(name="rd_interwiki")
	private String rdInterwiki;

	@Column(name="rd_namespace")
	private int rdNamespace;

	@Column(name="rd_title")
	private String rdTitle;

	public Redirect() {
	}

	public int getRdFrom() {
		return this.rdFrom;
	}

	public void setRdFrom(int rdFrom) {
		this.rdFrom = rdFrom;
	}

	public String getRdFragment() {
		return this.rdFragment;
	}

	public void setRdFragment(String rdFragment) {
		this.rdFragment = rdFragment;
	}

	public String getRdInterwiki() {
		return this.rdInterwiki;
	}

	public void setRdInterwiki(String rdInterwiki) {
		this.rdInterwiki = rdInterwiki;
	}

	public int getRdNamespace() {
		return this.rdNamespace;
	}

	public void setRdNamespace(int rdNamespace) {
		this.rdNamespace = rdNamespace;
	}

	public String getRdTitle() {
		return this.rdTitle;
	}

	public void setRdTitle(String rdTitle) {
		this.rdTitle = rdTitle;
	}

}