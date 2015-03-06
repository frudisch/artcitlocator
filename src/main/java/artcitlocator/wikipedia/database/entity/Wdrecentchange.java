package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wdrecentchanges database table.
 * 
 */
@Entity
@Table(name="wdrecentchanges")
@NamedQuery(name="Wdrecentchange.findAll", query="SELECT w FROM Wdrecentchange w")
public class Wdrecentchange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rc_id")
	private int rcId;

	@Column(name="rc_bot")
	private byte rcBot;

	@Column(name="rc_comment")
	private byte[] rcComment;

	@Column(name="rc_cur_id")
	private int rcCurId;

	@Column(name="rc_cur_time")
	private byte[] rcCurTime;

	@Column(name="rc_deleted")
	private byte rcDeleted;

	@Column(name="rc_ip")
	private byte[] rcIp;

	@Column(name="rc_last_oldid")
	private int rcLastOldid;

	@Column(name="rc_log_action")
	private byte[] rcLogAction;

	@Column(name="rc_log_type")
	private byte[] rcLogType;

	@Column(name="rc_logid")
	private int rcLogid;

	@Column(name="rc_minor")
	private byte rcMinor;

	@Column(name="rc_namespace")
	private int rcNamespace;

	@Column(name="rc_new")
	private byte rcNew;

	@Column(name="rc_new_len")
	private int rcNewLen;

	@Column(name="rc_old_len")
	private int rcOldLen;

	@Lob
	@Column(name="rc_params")
	private byte[] rcParams;

	@Column(name="rc_patrolled")
	private byte rcPatrolled;

	@Column(name="rc_this_oldid")
	private int rcThisOldid;

	@Column(name="rc_timestamp")
	private byte[] rcTimestamp;

	@Column(name="rc_title")
	private byte[] rcTitle;

	@Column(name="rc_type")
	private byte rcType;

	@Column(name="rc_user")
	private int rcUser;

	@Column(name="rc_user_text")
	private byte[] rcUserText;

	public Wdrecentchange() {
	}

	public int getRcId() {
		return this.rcId;
	}

	public void setRcId(int rcId) {
		this.rcId = rcId;
	}

	public byte getRcBot() {
		return this.rcBot;
	}

	public void setRcBot(byte rcBot) {
		this.rcBot = rcBot;
	}

	public byte[] getRcComment() {
		return this.rcComment;
	}

	public void setRcComment(byte[] rcComment) {
		this.rcComment = rcComment;
	}

	public int getRcCurId() {
		return this.rcCurId;
	}

	public void setRcCurId(int rcCurId) {
		this.rcCurId = rcCurId;
	}

	public byte[] getRcCurTime() {
		return this.rcCurTime;
	}

	public void setRcCurTime(byte[] rcCurTime) {
		this.rcCurTime = rcCurTime;
	}

	public byte getRcDeleted() {
		return this.rcDeleted;
	}

	public void setRcDeleted(byte rcDeleted) {
		this.rcDeleted = rcDeleted;
	}

	public byte[] getRcIp() {
		return this.rcIp;
	}

	public void setRcIp(byte[] rcIp) {
		this.rcIp = rcIp;
	}

	public int getRcLastOldid() {
		return this.rcLastOldid;
	}

	public void setRcLastOldid(int rcLastOldid) {
		this.rcLastOldid = rcLastOldid;
	}

	public byte[] getRcLogAction() {
		return this.rcLogAction;
	}

	public void setRcLogAction(byte[] rcLogAction) {
		this.rcLogAction = rcLogAction;
	}

	public byte[] getRcLogType() {
		return this.rcLogType;
	}

	public void setRcLogType(byte[] rcLogType) {
		this.rcLogType = rcLogType;
	}

	public int getRcLogid() {
		return this.rcLogid;
	}

	public void setRcLogid(int rcLogid) {
		this.rcLogid = rcLogid;
	}

	public byte getRcMinor() {
		return this.rcMinor;
	}

	public void setRcMinor(byte rcMinor) {
		this.rcMinor = rcMinor;
	}

	public int getRcNamespace() {
		return this.rcNamespace;
	}

	public void setRcNamespace(int rcNamespace) {
		this.rcNamespace = rcNamespace;
	}

	public byte getRcNew() {
		return this.rcNew;
	}

	public void setRcNew(byte rcNew) {
		this.rcNew = rcNew;
	}

	public int getRcNewLen() {
		return this.rcNewLen;
	}

	public void setRcNewLen(int rcNewLen) {
		this.rcNewLen = rcNewLen;
	}

	public int getRcOldLen() {
		return this.rcOldLen;
	}

	public void setRcOldLen(int rcOldLen) {
		this.rcOldLen = rcOldLen;
	}

	public byte[] getRcParams() {
		return this.rcParams;
	}

	public void setRcParams(byte[] rcParams) {
		this.rcParams = rcParams;
	}

	public byte getRcPatrolled() {
		return this.rcPatrolled;
	}

	public void setRcPatrolled(byte rcPatrolled) {
		this.rcPatrolled = rcPatrolled;
	}

	public int getRcThisOldid() {
		return this.rcThisOldid;
	}

	public void setRcThisOldid(int rcThisOldid) {
		this.rcThisOldid = rcThisOldid;
	}

	public byte[] getRcTimestamp() {
		return this.rcTimestamp;
	}

	public void setRcTimestamp(byte[] rcTimestamp) {
		this.rcTimestamp = rcTimestamp;
	}

	public byte[] getRcTitle() {
		return this.rcTitle;
	}

	public void setRcTitle(byte[] rcTitle) {
		this.rcTitle = rcTitle;
	}

	public byte getRcType() {
		return this.rcType;
	}

	public void setRcType(byte rcType) {
		this.rcType = rcType;
	}

	public int getRcUser() {
		return this.rcUser;
	}

	public void setRcUser(int rcUser) {
		this.rcUser = rcUser;
	}

	public byte[] getRcUserText() {
		return this.rcUserText;
	}

	public void setRcUserText(byte[] rcUserText) {
		this.rcUserText = rcUserText;
	}

}