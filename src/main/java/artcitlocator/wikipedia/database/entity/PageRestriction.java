package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the page_restrictions database table.
 * 
 */
@Entity
@Table(name="page_restrictions")
@NamedQuery(name="PageRestriction.findAll", query="SELECT p FROM PageRestriction p")
public class PageRestriction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pr_id")
	private int prId;

	@Column(name="pr_cascade")
	private byte prCascade;

	@Column(name="pr_expiry")
	private byte[] prExpiry;

	@Column(name="pr_level")
	private byte[] prLevel;

	@Column(name="pr_page")
	private int prPage;

	@Column(name="pr_type")
	private byte[] prType;

	@Column(name="pr_user")
	private int prUser;

	public PageRestriction() {
	}

	public int getPrId() {
		return this.prId;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	public byte getPrCascade() {
		return this.prCascade;
	}

	public void setPrCascade(byte prCascade) {
		this.prCascade = prCascade;
	}

	public byte[] getPrExpiry() {
		return this.prExpiry;
	}

	public void setPrExpiry(byte[] prExpiry) {
		this.prExpiry = prExpiry;
	}

	public byte[] getPrLevel() {
		return this.prLevel;
	}

	public void setPrLevel(byte[] prLevel) {
		this.prLevel = prLevel;
	}

	public int getPrPage() {
		return this.prPage;
	}

	public void setPrPage(int prPage) {
		this.prPage = prPage;
	}

	public byte[] getPrType() {
		return this.prType;
	}

	public void setPrType(byte[] prType) {
		this.prType = prType;
	}

	public int getPrUser() {
		return this.prUser;
	}

	public void setPrUser(int prUser) {
		this.prUser = prUser;
	}

}