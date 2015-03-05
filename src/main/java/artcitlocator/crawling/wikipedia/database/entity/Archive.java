package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the archive database table.
 * 
 */
@Entity
@NamedQuery(name="Archive.findAll", query="SELECT a FROM Archive a")
public class Archive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Lob
	@Column(name="ar_comment")
	private byte[] arComment;

	@Column(name="ar_deleted")
	private byte arDeleted;

	@Lob
	@Column(name="ar_flags")
	private byte[] arFlags;

	@Column(name="ar_len")
	private int arLen;

	@Column(name="ar_minor_edit")
	private byte arMinorEdit;

	@Column(name="ar_namespace")
	private int arNamespace;

	@Column(name="ar_page_id")
	private int arPageId;

	@Column(name="ar_parent_id")
	private int arParentId;

	@Column(name="ar_rev_id")
	private int arRevId;

	@Column(name="ar_sha1")
	private byte[] arSha1;

	@Lob
	@Column(name="ar_text")
	private byte[] arText;

	@Column(name="ar_text_id")
	private int arTextId;

	@Column(name="ar_timestamp")
	private byte[] arTimestamp;

	@Column(name="ar_title")
	private String arTitle;

	@Column(name="ar_user")
	private int arUser;

	@Column(name="ar_user_text")
	private String arUserText;

	public Archive() {
	}

	public byte[] getArComment() {
		return this.arComment;
	}

	public void setArComment(byte[] arComment) {
		this.arComment = arComment;
	}

	public byte getArDeleted() {
		return this.arDeleted;
	}

	public void setArDeleted(byte arDeleted) {
		this.arDeleted = arDeleted;
	}

	public byte[] getArFlags() {
		return this.arFlags;
	}

	public void setArFlags(byte[] arFlags) {
		this.arFlags = arFlags;
	}

	public int getArLen() {
		return this.arLen;
	}

	public void setArLen(int arLen) {
		this.arLen = arLen;
	}

	public byte getArMinorEdit() {
		return this.arMinorEdit;
	}

	public void setArMinorEdit(byte arMinorEdit) {
		this.arMinorEdit = arMinorEdit;
	}

	public int getArNamespace() {
		return this.arNamespace;
	}

	public void setArNamespace(int arNamespace) {
		this.arNamespace = arNamespace;
	}

	public int getArPageId() {
		return this.arPageId;
	}

	public void setArPageId(int arPageId) {
		this.arPageId = arPageId;
	}

	public int getArParentId() {
		return this.arParentId;
	}

	public void setArParentId(int arParentId) {
		this.arParentId = arParentId;
	}

	public int getArRevId() {
		return this.arRevId;
	}

	public void setArRevId(int arRevId) {
		this.arRevId = arRevId;
	}

	public byte[] getArSha1() {
		return this.arSha1;
	}

	public void setArSha1(byte[] arSha1) {
		this.arSha1 = arSha1;
	}

	public byte[] getArText() {
		return this.arText;
	}

	public void setArText(byte[] arText) {
		this.arText = arText;
	}

	public int getArTextId() {
		return this.arTextId;
	}

	public void setArTextId(int arTextId) {
		this.arTextId = arTextId;
	}

	public byte[] getArTimestamp() {
		return this.arTimestamp;
	}

	public void setArTimestamp(byte[] arTimestamp) {
		this.arTimestamp = arTimestamp;
	}

	public String getArTitle() {
		return this.arTitle;
	}

	public void setArTitle(String arTitle) {
		this.arTitle = arTitle;
	}

	public int getArUser() {
		return this.arUser;
	}

	public void setArUser(int arUser) {
		this.arUser = arUser;
	}

	public String getArUserText() {
		return this.arUserText;
	}

	public void setArUserText(String arUserText) {
		this.arUserText = arUserText;
	}

}