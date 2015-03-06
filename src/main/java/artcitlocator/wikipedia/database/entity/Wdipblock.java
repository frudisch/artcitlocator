package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wdipblocks database table.
 * 
 */
@Entity
@Table(name="wdipblocks")
@NamedQuery(name="Wdipblock.findAll", query="SELECT w FROM Wdipblock w")
public class Wdipblock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ipb_id")
	private int ipbId;

	@Lob
	@Column(name="ipb_address")
	private byte[] ipbAddress;

	@Column(name="ipb_allow_usertalk")
	private byte ipbAllowUsertalk;

	@Column(name="ipb_anon_only")
	private byte ipbAnonOnly;

	@Column(name="ipb_auto")
	private byte ipbAuto;

	@Column(name="ipb_block_email")
	private byte ipbBlockEmail;

	@Column(name="ipb_by")
	private int ipbBy;

	@Column(name="ipb_by_text")
	private byte[] ipbByText;

	@Column(name="ipb_create_account")
	private byte ipbCreateAccount;

	@Column(name="ipb_deleted")
	private byte ipbDeleted;

	@Column(name="ipb_enable_autoblock")
	private byte ipbEnableAutoblock;

	@Column(name="ipb_expiry")
	private byte[] ipbExpiry;

	@Column(name="ipb_parent_block_id")
	private int ipbParentBlockId;

	@Lob
	@Column(name="ipb_range_end")
	private byte[] ipbRangeEnd;

	@Lob
	@Column(name="ipb_range_start")
	private byte[] ipbRangeStart;

	@Lob
	@Column(name="ipb_reason")
	private byte[] ipbReason;

	@Column(name="ipb_timestamp")
	private byte[] ipbTimestamp;

	@Column(name="ipb_user")
	private int ipbUser;

	public Wdipblock() {
	}

	public int getIpbId() {
		return this.ipbId;
	}

	public void setIpbId(int ipbId) {
		this.ipbId = ipbId;
	}

	public byte[] getIpbAddress() {
		return this.ipbAddress;
	}

	public void setIpbAddress(byte[] ipbAddress) {
		this.ipbAddress = ipbAddress;
	}

	public byte getIpbAllowUsertalk() {
		return this.ipbAllowUsertalk;
	}

	public void setIpbAllowUsertalk(byte ipbAllowUsertalk) {
		this.ipbAllowUsertalk = ipbAllowUsertalk;
	}

	public byte getIpbAnonOnly() {
		return this.ipbAnonOnly;
	}

	public void setIpbAnonOnly(byte ipbAnonOnly) {
		this.ipbAnonOnly = ipbAnonOnly;
	}

	public byte getIpbAuto() {
		return this.ipbAuto;
	}

	public void setIpbAuto(byte ipbAuto) {
		this.ipbAuto = ipbAuto;
	}

	public byte getIpbBlockEmail() {
		return this.ipbBlockEmail;
	}

	public void setIpbBlockEmail(byte ipbBlockEmail) {
		this.ipbBlockEmail = ipbBlockEmail;
	}

	public int getIpbBy() {
		return this.ipbBy;
	}

	public void setIpbBy(int ipbBy) {
		this.ipbBy = ipbBy;
	}

	public byte[] getIpbByText() {
		return this.ipbByText;
	}

	public void setIpbByText(byte[] ipbByText) {
		this.ipbByText = ipbByText;
	}

	public byte getIpbCreateAccount() {
		return this.ipbCreateAccount;
	}

	public void setIpbCreateAccount(byte ipbCreateAccount) {
		this.ipbCreateAccount = ipbCreateAccount;
	}

	public byte getIpbDeleted() {
		return this.ipbDeleted;
	}

	public void setIpbDeleted(byte ipbDeleted) {
		this.ipbDeleted = ipbDeleted;
	}

	public byte getIpbEnableAutoblock() {
		return this.ipbEnableAutoblock;
	}

	public void setIpbEnableAutoblock(byte ipbEnableAutoblock) {
		this.ipbEnableAutoblock = ipbEnableAutoblock;
	}

	public byte[] getIpbExpiry() {
		return this.ipbExpiry;
	}

	public void setIpbExpiry(byte[] ipbExpiry) {
		this.ipbExpiry = ipbExpiry;
	}

	public int getIpbParentBlockId() {
		return this.ipbParentBlockId;
	}

	public void setIpbParentBlockId(int ipbParentBlockId) {
		this.ipbParentBlockId = ipbParentBlockId;
	}

	public byte[] getIpbRangeEnd() {
		return this.ipbRangeEnd;
	}

	public void setIpbRangeEnd(byte[] ipbRangeEnd) {
		this.ipbRangeEnd = ipbRangeEnd;
	}

	public byte[] getIpbRangeStart() {
		return this.ipbRangeStart;
	}

	public void setIpbRangeStart(byte[] ipbRangeStart) {
		this.ipbRangeStart = ipbRangeStart;
	}

	public byte[] getIpbReason() {
		return this.ipbReason;
	}

	public void setIpbReason(byte[] ipbReason) {
		this.ipbReason = ipbReason;
	}

	public byte[] getIpbTimestamp() {
		return this.ipbTimestamp;
	}

	public void setIpbTimestamp(byte[] ipbTimestamp) {
		this.ipbTimestamp = ipbTimestamp;
	}

	public int getIpbUser() {
		return this.ipbUser;
	}

	public void setIpbUser(int ipbUser) {
		this.ipbUser = ipbUser;
	}

}