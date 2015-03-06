package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wdtext database table.
 * 
 */
@Entity
@NamedQuery(name="Wdtext.findAll", query="SELECT w FROM Wdtext w")
public class Wdtext implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="old_id")
	private int oldId;

	@Lob
	@Column(name="old_flags")
	private byte[] oldFlags;

	@Lob
	@Column(name="old_text")
	private byte[] oldText;

	public Wdtext() {
	}

	public int getOldId() {
		return this.oldId;
	}

	public void setOldId(int oldId) {
		this.oldId = oldId;
	}

	public byte[] getOldFlags() {
		return this.oldFlags;
	}

	public void setOldFlags(byte[] oldFlags) {
		this.oldFlags = oldFlags;
	}

	public byte[] getOldText() {
		return this.oldText;
	}

	public void setOldText(byte[] oldText) {
		this.oldText = oldText;
	}

}