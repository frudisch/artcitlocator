package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wdlogging database table.
 * 
 */
@Entity
@NamedQuery(name="Wdlogging.findAll", query="SELECT w FROM Wdlogging w")
public class Wdlogging implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="log_id")
	private int logId;

	@Column(name="log_action")
	private byte[] logAction;

	@Column(name="log_comment")
	private byte[] logComment;

	@Column(name="log_deleted")
	private byte logDeleted;

	@Column(name="log_namespace")
	private int logNamespace;

	@Column(name="log_page")
	private int logPage;

	@Lob
	@Column(name="log_params")
	private byte[] logParams;

	@Column(name="log_timestamp")
	private byte[] logTimestamp;

	@Column(name="log_title")
	private byte[] logTitle;

	@Column(name="log_type")
	private byte[] logType;

	@Column(name="log_user")
	private int logUser;

	@Column(name="log_user_text")
	private byte[] logUserText;

	public Wdlogging() {
	}

	public int getLogId() {
		return this.logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public byte[] getLogAction() {
		return this.logAction;
	}

	public void setLogAction(byte[] logAction) {
		this.logAction = logAction;
	}

	public byte[] getLogComment() {
		return this.logComment;
	}

	public void setLogComment(byte[] logComment) {
		this.logComment = logComment;
	}

	public byte getLogDeleted() {
		return this.logDeleted;
	}

	public void setLogDeleted(byte logDeleted) {
		this.logDeleted = logDeleted;
	}

	public int getLogNamespace() {
		return this.logNamespace;
	}

	public void setLogNamespace(int logNamespace) {
		this.logNamespace = logNamespace;
	}

	public int getLogPage() {
		return this.logPage;
	}

	public void setLogPage(int logPage) {
		this.logPage = logPage;
	}

	public byte[] getLogParams() {
		return this.logParams;
	}

	public void setLogParams(byte[] logParams) {
		this.logParams = logParams;
	}

	public byte[] getLogTimestamp() {
		return this.logTimestamp;
	}

	public void setLogTimestamp(byte[] logTimestamp) {
		this.logTimestamp = logTimestamp;
	}

	public byte[] getLogTitle() {
		return this.logTitle;
	}

	public void setLogTitle(byte[] logTitle) {
		this.logTitle = logTitle;
	}

	public byte[] getLogType() {
		return this.logType;
	}

	public void setLogType(byte[] logType) {
		this.logType = logType;
	}

	public int getLogUser() {
		return this.logUser;
	}

	public void setLogUser(int logUser) {
		this.logUser = logUser;
	}

	public byte[] getLogUserText() {
		return this.logUserText;
	}

	public void setLogUserText(byte[] logUserText) {
		this.logUserText = logUserText;
	}

}