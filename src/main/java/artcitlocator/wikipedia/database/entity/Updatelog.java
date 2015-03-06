package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the updatelog database table.
 * 
 */
@Entity
@NamedQuery(name="Updatelog.findAll", query="SELECT u FROM Updatelog u")
public class Updatelog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ul_key")
	private String ulKey;

	@Lob
	@Column(name="ul_value")
	private byte[] ulValue;

	public Updatelog() {
	}

	public String getUlKey() {
		return this.ulKey;
	}

	public void setUlKey(String ulKey) {
		this.ulKey = ulKey;
	}

	public byte[] getUlValue() {
		return this.ulValue;
	}

	public void setUlValue(byte[] ulValue) {
		this.ulValue = ulValue;
	}

}