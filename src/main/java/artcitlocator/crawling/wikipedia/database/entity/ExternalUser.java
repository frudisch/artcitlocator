package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the external_user database table.
 * 
 */
@Entity
@Table(name="external_user")
@NamedQuery(name="ExternalUser.findAll", query="SELECT e FROM ExternalUser e")
public class ExternalUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="eu_local_id")
	private int euLocalId;

	@Column(name="eu_external_id")
	private String euExternalId;

	public ExternalUser() {
	}

	public int getEuLocalId() {
		return this.euLocalId;
	}

	public void setEuLocalId(int euLocalId) {
		this.euLocalId = euLocalId;
	}

	public String getEuExternalId() {
		return this.euExternalId;
	}

	public void setEuExternalId(String euExternalId) {
		this.euExternalId = euExternalId;
	}

}