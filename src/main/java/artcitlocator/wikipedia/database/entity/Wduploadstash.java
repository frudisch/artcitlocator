package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wduploadstash database table.
 * 
 */
@Entity
@NamedQuery(name="Wduploadstash.findAll", query="SELECT w FROM Wduploadstash w")
public class Wduploadstash implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="us_id")
	private int usId;

	@Column(name="us_chunk_inx")
	private int usChunkInx;

	@Column(name="us_image_bits")
	private int usImageBits;

	@Column(name="us_image_height")
	private int usImageHeight;

	@Column(name="us_image_width")
	private int usImageWidth;

	@Column(name="us_key")
	private byte[] usKey;

	@Column(name="us_media_type")
	private String usMediaType;

	@Column(name="us_mime")
	private byte[] usMime;

	@Column(name="us_orig_path")
	private byte[] usOrigPath;

	@Column(name="us_path")
	private byte[] usPath;

	@Lob
	@Column(name="us_props")
	private byte[] usProps;

	@Column(name="us_sha1")
	private byte[] usSha1;

	@Column(name="us_size")
	private int usSize;

	@Column(name="us_source_type")
	private byte[] usSourceType;

	@Column(name="us_status")
	private byte[] usStatus;

	@Column(name="us_timestamp")
	private byte[] usTimestamp;

	@Column(name="us_user")
	private int usUser;

	public Wduploadstash() {
	}

	public int getUsId() {
		return this.usId;
	}

	public void setUsId(int usId) {
		this.usId = usId;
	}

	public int getUsChunkInx() {
		return this.usChunkInx;
	}

	public void setUsChunkInx(int usChunkInx) {
		this.usChunkInx = usChunkInx;
	}

	public int getUsImageBits() {
		return this.usImageBits;
	}

	public void setUsImageBits(int usImageBits) {
		this.usImageBits = usImageBits;
	}

	public int getUsImageHeight() {
		return this.usImageHeight;
	}

	public void setUsImageHeight(int usImageHeight) {
		this.usImageHeight = usImageHeight;
	}

	public int getUsImageWidth() {
		return this.usImageWidth;
	}

	public void setUsImageWidth(int usImageWidth) {
		this.usImageWidth = usImageWidth;
	}

	public byte[] getUsKey() {
		return this.usKey;
	}

	public void setUsKey(byte[] usKey) {
		this.usKey = usKey;
	}

	public String getUsMediaType() {
		return this.usMediaType;
	}

	public void setUsMediaType(String usMediaType) {
		this.usMediaType = usMediaType;
	}

	public byte[] getUsMime() {
		return this.usMime;
	}

	public void setUsMime(byte[] usMime) {
		this.usMime = usMime;
	}

	public byte[] getUsOrigPath() {
		return this.usOrigPath;
	}

	public void setUsOrigPath(byte[] usOrigPath) {
		this.usOrigPath = usOrigPath;
	}

	public byte[] getUsPath() {
		return this.usPath;
	}

	public void setUsPath(byte[] usPath) {
		this.usPath = usPath;
	}

	public byte[] getUsProps() {
		return this.usProps;
	}

	public void setUsProps(byte[] usProps) {
		this.usProps = usProps;
	}

	public byte[] getUsSha1() {
		return this.usSha1;
	}

	public void setUsSha1(byte[] usSha1) {
		this.usSha1 = usSha1;
	}

	public int getUsSize() {
		return this.usSize;
	}

	public void setUsSize(int usSize) {
		this.usSize = usSize;
	}

	public byte[] getUsSourceType() {
		return this.usSourceType;
	}

	public void setUsSourceType(byte[] usSourceType) {
		this.usSourceType = usSourceType;
	}

	public byte[] getUsStatus() {
		return this.usStatus;
	}

	public void setUsStatus(byte[] usStatus) {
		this.usStatus = usStatus;
	}

	public byte[] getUsTimestamp() {
		return this.usTimestamp;
	}

	public void setUsTimestamp(byte[] usTimestamp) {
		this.usTimestamp = usTimestamp;
	}

	public int getUsUser() {
		return this.usUser;
	}

	public void setUsUser(int usUser) {
		this.usUser = usUser;
	}

}