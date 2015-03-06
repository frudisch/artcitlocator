package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the hitcounter database table.
 * 
 */
@Entity
@NamedQuery(name="Hitcounter.findAll", query="SELECT h FROM Hitcounter h")
public class Hitcounter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="hc_id")
	private int hcId;

	public Hitcounter() {
	}

	public int getHcId() {
		return this.hcId;
	}

	public void setHcId(int hcId) {
		this.hcId = hcId;
	}

}