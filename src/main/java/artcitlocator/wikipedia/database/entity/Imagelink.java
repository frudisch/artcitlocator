package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the imagelinks database table.
 * 
 */
@Entity
@Table(name="imagelinks")
@NamedQuery(name="Imagelink.findAll", query="SELECT i FROM Imagelink i")
public class Imagelink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="il_from")
	private int ilFrom;

	@Column(name="il_to")
	private String ilTo;

	public Imagelink() {
	}

	public int getIlFrom() {
		return this.ilFrom;
	}

	public void setIlFrom(int ilFrom) {
		this.ilFrom = ilFrom;
	}

	public String getIlTo() {
		return this.ilTo;
	}

	public void setIlTo(String ilTo) {
		this.ilTo = ilTo;
	}

}