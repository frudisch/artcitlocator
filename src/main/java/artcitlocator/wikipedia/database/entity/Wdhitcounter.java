package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdhitcounter database table.
 * 
 */
@Entity
@NamedQuery(name="Wdhitcounter.findAll", query="SELECT w FROM Wdhitcounter w")
public class Wdhitcounter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="hc_id")
	private int hcId;

	public Wdhitcounter() {
	}

	public int getHcId() {
		return this.hcId;
	}

	public void setHcId(int hcId) {
		this.hcId = hcId;
	}

}