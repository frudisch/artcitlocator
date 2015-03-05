package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wduser_properties database table.
 * 
 */
@Entity
@Table(name="wduser_properties")
@NamedQuery(name="WduserProperty.findAll", query="SELECT w FROM WduserProperty w")
public class WduserProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="up_property")
	private byte[] upProperty;

	@Column(name="up_user")
	private int upUser;

	@Lob
	@Column(name="up_value")
	private byte[] upValue;

	public WduserProperty() {
	}

	public byte[] getUpProperty() {
		return this.upProperty;
	}

	public void setUpProperty(byte[] upProperty) {
		this.upProperty = upProperty;
	}

	public int getUpUser() {
		return this.upUser;
	}

	public void setUpUser(int upUser) {
		this.upUser = upUser;
	}

	public byte[] getUpValue() {
		return this.upValue;
	}

	public void setUpValue(byte[] upValue) {
		this.upValue = upValue;
	}

}