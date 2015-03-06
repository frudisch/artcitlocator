package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the objectcache database table.
 * 
 */
@Entity
@NamedQuery(name="Objectcache.findAll", query="SELECT o FROM Objectcache o")
public class Objectcache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String keyname;

	@Temporal(TemporalType.TIMESTAMP)
	private Date exptime;

	@Lob
	private byte[] value;

	public Objectcache() {
	}

	public String getKeyname() {
		return this.keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public Date getExptime() {
		return this.exptime;
	}

	public void setExptime(Date exptime) {
		this.exptime = exptime;
	}

	public byte[] getValue() {
		return this.value;
	}

	public void setValue(byte[] value) {
		this.value = value;
	}

}