package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wdexternal_user database table.
 * 
 */
@Entity
@Table(name="wdexternal_user")
@NamedQuery(name="WdexternalUser.findAll", query="SELECT w FROM WdexternalUser w")
public class WdexternalUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="eu_local_id")
	private int euLocalId;

	@Column(name="eu_external_id")
	private byte[] euExternalId;

	public WdexternalUser() {
	}

	public int getEuLocalId() {
		return this.euLocalId;
	}

	public void setEuLocalId(int euLocalId) {
		this.euLocalId = euLocalId;
	}

	public byte[] getEuExternalId() {
		return this.euExternalId;
	}

	public void setEuExternalId(byte[] euExternalId) {
		this.euExternalId = euExternalId;
	}

}