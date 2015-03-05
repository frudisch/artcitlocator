package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the config database table.
 * 
 */
@Entity
@NamedQuery(name="Config.findAll", query="SELECT c FROM Config c")
public class Config implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cf_name")
	private String cfName;

	@Lob
	@Column(name="cf_value")
	private byte[] cfValue;

	public Config() {
	}

	public String getCfName() {
		return this.cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	public byte[] getCfValue() {
		return this.cfValue;
	}

	public void setCfValue(byte[] cfValue) {
		this.cfValue = cfValue;
	}

}