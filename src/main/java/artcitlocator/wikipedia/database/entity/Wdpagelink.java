package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdpagelinks database table.
 * 
 */
@Entity
@Table(name="wdpagelinks")
@NamedQuery(name="Wdpagelink.findAll", query="SELECT w FROM Wdpagelink w")
public class Wdpagelink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="pl_from")
	private int plFrom;

	@Column(name="pl_namespace")
	private int plNamespace;

	@Column(name="pl_title")
	private byte[] plTitle;

	public Wdpagelink() {
	}

	public int getPlFrom() {
		return this.plFrom;
	}

	public void setPlFrom(int plFrom) {
		this.plFrom = plFrom;
	}

	public int getPlNamespace() {
		return this.plNamespace;
	}

	public void setPlNamespace(int plNamespace) {
		this.plNamespace = plNamespace;
	}

	public byte[] getPlTitle() {
		return this.plTitle;
	}

	public void setPlTitle(byte[] plTitle) {
		this.plTitle = plTitle;
	}

}