package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the protected_titles database table.
 * 
 */
@Entity
@Table(name="protected_titles")
@NamedQuery(name="ProtectedTitle.findAll", query="SELECT p FROM ProtectedTitle p")
public class ProtectedTitle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="pt_create_perm")
	private byte[] ptCreatePerm;

	@Column(name="pt_expiry")
	private byte[] ptExpiry;

	@Column(name="pt_namespace")
	private int ptNamespace;

	@Lob
	@Column(name="pt_reason")
	private byte[] ptReason;

	@Column(name="pt_timestamp")
	private byte[] ptTimestamp;

	@Column(name="pt_title")
	private String ptTitle;

	@Column(name="pt_user")
	private int ptUser;

	public ProtectedTitle() {
	}

	public byte[] getPtCreatePerm() {
		return this.ptCreatePerm;
	}

	public void setPtCreatePerm(byte[] ptCreatePerm) {
		this.ptCreatePerm = ptCreatePerm;
	}

	public byte[] getPtExpiry() {
		return this.ptExpiry;
	}

	public void setPtExpiry(byte[] ptExpiry) {
		this.ptExpiry = ptExpiry;
	}

	public int getPtNamespace() {
		return this.ptNamespace;
	}

	public void setPtNamespace(int ptNamespace) {
		this.ptNamespace = ptNamespace;
	}

	public byte[] getPtReason() {
		return this.ptReason;
	}

	public void setPtReason(byte[] ptReason) {
		this.ptReason = ptReason;
	}

	public byte[] getPtTimestamp() {
		return this.ptTimestamp;
	}

	public void setPtTimestamp(byte[] ptTimestamp) {
		this.ptTimestamp = ptTimestamp;
	}

	public String getPtTitle() {
		return this.ptTitle;
	}

	public void setPtTitle(String ptTitle) {
		this.ptTitle = ptTitle;
	}

	public int getPtUser() {
		return this.ptUser;
	}

	public void setPtUser(int ptUser) {
		this.ptUser = ptUser;
	}

}