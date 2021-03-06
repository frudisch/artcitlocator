package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the revision database table.
 * 
 */
@Entity
@NamedQuery(name="Revision.findAll", query="SELECT r FROM Revision r")
public class Revision implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rev_id")
	private int revId;

	@Lob
	@Column(name="rev_comment")
	private byte[] revComment;

	@Column(name="rev_deleted")
	private byte revDeleted;

	@Column(name="rev_len")
	private int revLen;

	@Column(name="rev_minor_edit")
	private byte revMinorEdit;

	@Column(name="rev_page")
	private int revPage;

	@Column(name="rev_parent_id")
	private int revParentId;

	@Column(name="rev_sha1")
	private byte[] revSha1;

	@Column(name="rev_text_id")
	private int revTextId;

	@Column(name="rev_timestamp")
	private byte[] revTimestamp;

	@Column(name="rev_user")
	private int revUser;

	@Column(name="rev_user_text")
	private String revUserText;

	public Revision() {
	}

	public int getRevId() {
		return this.revId;
	}

	public void setRevId(int revId) {
		this.revId = revId;
	}

	public byte[] getRevComment() {
		return this.revComment;
	}

	public void setRevComment(byte[] revComment) {
		this.revComment = revComment;
	}

	public byte getRevDeleted() {
		return this.revDeleted;
	}

	public void setRevDeleted(byte revDeleted) {
		this.revDeleted = revDeleted;
	}

	public int getRevLen() {
		return this.revLen;
	}

	public void setRevLen(int revLen) {
		this.revLen = revLen;
	}

	public byte getRevMinorEdit() {
		return this.revMinorEdit;
	}

	public void setRevMinorEdit(byte revMinorEdit) {
		this.revMinorEdit = revMinorEdit;
	}

	public int getRevPage() {
		return this.revPage;
	}

	public void setRevPage(int revPage) {
		this.revPage = revPage;
	}

	public int getRevParentId() {
		return this.revParentId;
	}

	public void setRevParentId(int revParentId) {
		this.revParentId = revParentId;
	}

	public byte[] getRevSha1() {
		return this.revSha1;
	}

	public void setRevSha1(byte[] revSha1) {
		this.revSha1 = revSha1;
	}

	public int getRevTextId() {
		return this.revTextId;
	}

	public void setRevTextId(int revTextId) {
		this.revTextId = revTextId;
	}

	public byte[] getRevTimestamp() {
		return this.revTimestamp;
	}

	public void setRevTimestamp(byte[] revTimestamp) {
		this.revTimestamp = revTimestamp;
	}

	public int getRevUser() {
		return this.revUser;
	}

	public void setRevUser(int revUser) {
		this.revUser = revUser;
	}

	public String getRevUserText() {
		return this.revUserText;
	}

	public void setRevUserText(String revUserText) {
		this.revUserText = revUserText;
	}

}