package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the externallinks database table.
 * 
 */
@Entity
@Table(name="externallinks")
@NamedQuery(name="Externallink.findAll", query="SELECT e FROM Externallink e")
public class Externallink implements Serializable {
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

	public Externallink() {
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