package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdexternallinks database table.
 * 
 */
@Entity
@Table(name="wdexternallinks")
@NamedQuery(name="Wdexternallink.findAll", query="SELECT w FROM Wdexternallink w")
public class Wdexternallink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="el_from")
	private int elFrom;

	@Lob
	@Column(name="el_index")
	private byte[] elIndex;

	@Lob
	@Column(name="el_to")
	private byte[] elTo;

	public Wdexternallink() {
	}

	public int getElFrom() {
		return this.elFrom;
	}

	public void setElFrom(int elFrom) {
		this.elFrom = elFrom;
	}

	public byte[] getElIndex() {
		return this.elIndex;
	}

	public void setElIndex(byte[] elIndex) {
		this.elIndex = elIndex;
	}

	public byte[] getElTo() {
		return this.elTo;
	}

	public void setElTo(byte[] elTo) {
		this.elTo = elTo;
	}

}