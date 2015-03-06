package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the uploadstash database table.
 * 
 */
@Entity
@NamedQuery(name="Uploadstash.findAll", query="SELECT u FROM Uploadstash u")
public class Uploadstash implements Serializable {
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
	private String usKey;

	@Column(name="us_media_type")
	private String usMediaType;

	@Column(name="us_mime")
	private String usMime;

	@Column(name="us_orig_path")
	private String usOrigPath;

	@Column(name="us_path")
	private String usPath;

	@Column(name="us_sha1")
	private String usSha1;

	@Column(name="us_size")
	private int usSize;

	@Column(name="us_source_type")
	private String usSourceType;

	@Column(name="us_status")
	private String usStatus;

	@Column(name="us_timestamp")
	private byte[] usTimestamp;

	@Column(name="us_user")
	private int usUser;

	public Uploadstash() {
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

	public String getUsKey() {
		return this.usKey;
	}

	public void setUsKey(String usKey) {
		this.usKey = usKey;
	}

	public String getUsMediaType() {
		return this.usMediaType;
	}

	public void setUsMediaType(String usMediaType) {
		this.usMediaType = usMediaType;
	}

	public String getUsMime() {
		return this.usMime;
	}

	public void setUsMime(String usMime) {
		this.usMime = usMime;
	}

	public String getUsOrigPath() {
		return this.usOrigPath;
	}

	public void setUsOrigPath(String usOrigPath) {
		this.usOrigPath = usOrigPath;
	}

	public String getUsPath() {
		return this.usPath;
	}

	public void setUsPath(String usPath) {
		this.usPath = usPath;
	}

	public String getUsSha1() {
		return this.usSha1;
	}

	public void setUsSha1(String usSha1) {
		this.usSha1 = usSha1;
	}

	public int getUsSize() {
		return this.usSize;
	}

	public void setUsSize(int usSize) {
		this.usSize = usSize;
	}

	public String getUsSourceType() {
		return this.usSourceType;
	}

	public void setUsSourceType(String usSourceType) {
		this.usSourceType = usSourceType;
	}

	public String getUsStatus() {
		return this.usStatus;
	}

	public void setUsStatus(String usStatus) {
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