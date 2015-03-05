package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the filearchive database table.
 * 
 */
@Entity
@NamedQuery(name="Filearchive.findAll", query="SELECT f FROM Filearchive f")
public class Filearchive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fa_id")
	private int faId;

	@Column(name="fa_archive_name")
	private String faArchiveName;

	@Column(name="fa_bits")
	private int faBits;

	@Column(name="fa_deleted")
	private byte faDeleted;

	@Lob
	@Column(name="fa_deleted_reason")
	private String faDeletedReason;

	@Column(name="fa_deleted_timestamp")
	private byte[] faDeletedTimestamp;

	@Column(name="fa_deleted_user")
	private int faDeletedUser;

	@Lob
	@Column(name="fa_description")
	private byte[] faDescription;

	@Column(name="fa_height")
	private int faHeight;

	@Column(name="fa_major_mime")
	private String faMajorMime;

	@Column(name="fa_media_type")
	private String faMediaType;

	@Lob
	@Column(name="fa_metadata")
	private byte[] faMetadata;

	@Column(name="fa_minor_mime")
	private byte[] faMinorMime;

	@Column(name="fa_name")
	private String faName;

	@Column(name="fa_size")
	private int faSize;

	@Column(name="fa_storage_group")
	private byte[] faStorageGroup;

	@Column(name="fa_storage_key")
	private byte[] faStorageKey;

	@Column(name="fa_timestamp")
	private byte[] faTimestamp;

	@Column(name="fa_user")
	private int faUser;

	@Column(name="fa_user_text")
	private String faUserText;

	@Column(name="fa_width")
	private int faWidth;

	public Filearchive() {
	}

	public int getFaId() {
		return this.faId;
	}

	public void setFaId(int faId) {
		this.faId = faId;
	}

	public String getFaArchiveName() {
		return this.faArchiveName;
	}

	public void setFaArchiveName(String faArchiveName) {
		this.faArchiveName = faArchiveName;
	}

	public int getFaBits() {
		return this.faBits;
	}

	public void setFaBits(int faBits) {
		this.faBits = faBits;
	}

	public byte getFaDeleted() {
		return this.faDeleted;
	}

	public void setFaDeleted(byte faDeleted) {
		this.faDeleted = faDeleted;
	}

	public String getFaDeletedReason() {
		return this.faDeletedReason;
	}

	public void setFaDeletedReason(String faDeletedReason) {
		this.faDeletedReason = faDeletedReason;
	}

	public byte[] getFaDeletedTimestamp() {
		return this.faDeletedTimestamp;
	}

	public void setFaDeletedTimestamp(byte[] faDeletedTimestamp) {
		this.faDeletedTimestamp = faDeletedTimestamp;
	}

	public int getFaDeletedUser() {
		return this.faDeletedUser;
	}

	public void setFaDeletedUser(int faDeletedUser) {
		this.faDeletedUser = faDeletedUser;
	}

	public byte[] getFaDescription() {
		return this.faDescription;
	}

	public void setFaDescription(byte[] faDescription) {
		this.faDescription = faDescription;
	}

	public int getFaHeight() {
		return this.faHeight;
	}

	public void setFaHeight(int faHeight) {
		this.faHeight = faHeight;
	}

	public String getFaMajorMime() {
		return this.faMajorMime;
	}

	public void setFaMajorMime(String faMajorMime) {
		this.faMajorMime = faMajorMime;
	}

	public String getFaMediaType() {
		return this.faMediaType;
	}

	public void setFaMediaType(String faMediaType) {
		this.faMediaType = faMediaType;
	}

	public byte[] getFaMetadata() {
		return this.faMetadata;
	}

	public void setFaMetadata(byte[] faMetadata) {
		this.faMetadata = faMetadata;
	}

	public byte[] getFaMinorMime() {
		return this.faMinorMime;
	}

	public void setFaMinorMime(byte[] faMinorMime) {
		this.faMinorMime = faMinorMime;
	}

	public String getFaName() {
		return this.faName;
	}

	public void setFaName(String faName) {
		this.faName = faName;
	}

	public int getFaSize() {
		return this.faSize;
	}

	public void setFaSize(int faSize) {
		this.faSize = faSize;
	}

	public byte[] getFaStorageGroup() {
		return this.faStorageGroup;
	}

	public void setFaStorageGroup(byte[] faStorageGroup) {
		this.faStorageGroup = faStorageGroup;
	}

	public byte[] getFaStorageKey() {
		return this.faStorageKey;
	}

	public void setFaStorageKey(byte[] faStorageKey) {
		this.faStorageKey = faStorageKey;
	}

	public byte[] getFaTimestamp() {
		return this.faTimestamp;
	}

	public void setFaTimestamp(byte[] faTimestamp) {
		this.faTimestamp = faTimestamp;
	}

	public int getFaUser() {
		return this.faUser;
	}

	public void setFaUser(int faUser) {
		this.faUser = faUser;
	}

	public String getFaUserText() {
		return this.faUserText;
	}

	public void setFaUserText(String faUserText) {
		this.faUserText = faUserText;
	}

	public int getFaWidth() {
		return this.faWidth;
	}

	public void setFaWidth(int faWidth) {
		this.faWidth = faWidth;
	}

}