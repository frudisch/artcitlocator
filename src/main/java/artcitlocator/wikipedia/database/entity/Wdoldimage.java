package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdoldimage database table.
 * 
 */
@Entity
@NamedQuery(name="Wdoldimage.findAll", query="SELECT w FROM Wdoldimage w")
public class Wdoldimage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="oi_archive_name")
	private byte[] oiArchiveName;

	@Column(name="oi_bits")
	private int oiBits;

	@Column(name="oi_deleted")
	private byte oiDeleted;

	@Lob
	@Column(name="oi_description")
	private byte[] oiDescription;

	@Column(name="oi_height")
	private int oiHeight;

	@Column(name="oi_major_mime")
	private String oiMajorMime;

	@Column(name="oi_media_type")
	private String oiMediaType;

	@Lob
	@Column(name="oi_metadata")
	private byte[] oiMetadata;

	@Column(name="oi_minor_mime")
	private byte[] oiMinorMime;

	@Column(name="oi_name")
	private byte[] oiName;

	@Column(name="oi_sha1")
	private byte[] oiSha1;

	@Column(name="oi_size")
	private int oiSize;

	@Column(name="oi_timestamp")
	private byte[] oiTimestamp;

	@Column(name="oi_user")
	private int oiUser;

	@Column(name="oi_user_text")
	private byte[] oiUserText;

	@Column(name="oi_width")
	private int oiWidth;

	public Wdoldimage() {
	}

	public byte[] getOiArchiveName() {
		return this.oiArchiveName;
	}

	public void setOiArchiveName(byte[] oiArchiveName) {
		this.oiArchiveName = oiArchiveName;
	}

	public int getOiBits() {
		return this.oiBits;
	}

	public void setOiBits(int oiBits) {
		this.oiBits = oiBits;
	}

	public byte getOiDeleted() {
		return this.oiDeleted;
	}

	public void setOiDeleted(byte oiDeleted) {
		this.oiDeleted = oiDeleted;
	}

	public byte[] getOiDescription() {
		return this.oiDescription;
	}

	public void setOiDescription(byte[] oiDescription) {
		this.oiDescription = oiDescription;
	}

	public int getOiHeight() {
		return this.oiHeight;
	}

	public void setOiHeight(int oiHeight) {
		this.oiHeight = oiHeight;
	}

	public String getOiMajorMime() {
		return this.oiMajorMime;
	}

	public void setOiMajorMime(String oiMajorMime) {
		this.oiMajorMime = oiMajorMime;
	}

	public String getOiMediaType() {
		return this.oiMediaType;
	}

	public void setOiMediaType(String oiMediaType) {
		this.oiMediaType = oiMediaType;
	}

	public byte[] getOiMetadata() {
		return this.oiMetadata;
	}

	public void setOiMetadata(byte[] oiMetadata) {
		this.oiMetadata = oiMetadata;
	}

	public byte[] getOiMinorMime() {
		return this.oiMinorMime;
	}

	public void setOiMinorMime(byte[] oiMinorMime) {
		this.oiMinorMime = oiMinorMime;
	}

	public byte[] getOiName() {
		return this.oiName;
	}

	public void setOiName(byte[] oiName) {
		this.oiName = oiName;
	}

	public byte[] getOiSha1() {
		return this.oiSha1;
	}

	public void setOiSha1(byte[] oiSha1) {
		this.oiSha1 = oiSha1;
	}

	public int getOiSize() {
		return this.oiSize;
	}

	public void setOiSize(int oiSize) {
		this.oiSize = oiSize;
	}

	public byte[] getOiTimestamp() {
		return this.oiTimestamp;
	}

	public void setOiTimestamp(byte[] oiTimestamp) {
		this.oiTimestamp = oiTimestamp;
	}

	public int getOiUser() {
		return this.oiUser;
	}

	public void setOiUser(int oiUser) {
		this.oiUser = oiUser;
	}

	public byte[] getOiUserText() {
		return this.oiUserText;
	}

	public void setOiUserText(byte[] oiUserText) {
		this.oiUserText = oiUserText;
	}

	public int getOiWidth() {
		return this.oiWidth;
	}

	public void setOiWidth(int oiWidth) {
		this.oiWidth = oiWidth;
	}

}