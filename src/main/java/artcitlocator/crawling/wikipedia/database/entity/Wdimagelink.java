package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdimagelinks database table.
 * 
 */
@Entity
@Table(name="wdimagelinks")
@NamedQuery(name="Wdimagelink.findAll", query="SELECT w FROM Wdimagelink w")
public class Wdimagelink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="il_from")
	private int ilFrom;

	@Column(name="il_to")
	private byte[] ilTo;

	public Wdimagelink() {
	}

	public int getIlFrom() {
		return this.ilFrom;
	}

	public void setIlFrom(int ilFrom) {
		this.ilFrom = ilFrom;
	}

	public byte[] getIlTo() {
		return this.ilTo;
	}

	public void setIlTo(byte[] ilTo) {
		this.ilTo = ilTo;
	}

}