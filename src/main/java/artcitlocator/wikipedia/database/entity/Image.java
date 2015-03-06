package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="img_name")
	private String imgName;

	@Column(name="img_bits")
	private int imgBits;

	@Lob
	@Column(name="img_description")
	private byte[] imgDescription;

	@Column(name="img_height")
	private int imgHeight;

	@Column(name="img_major_mime")
	private String imgMajorMime;

	@Column(name="img_media_type")
	private String imgMediaType;

	@Lob
	@Column(name="img_metadata")
	private byte[] imgMetadata;

	@Column(name="img_minor_mime")
	private byte[] imgMinorMime;

	@Column(name="img_sha1")
	private byte[] imgSha1;

	@Column(name="img_size")
	private int imgSize;

	@Column(name="img_timestamp")
	private byte[] imgTimestamp;

	@Column(name="img_user")
	private int imgUser;

	@Column(name="img_user_text")
	private String imgUserText;

	@Column(name="img_width")
	private int imgWidth;

	public Image() {
	}

	public String getImgName() {
		return this.imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public int getImgBits() {
		return this.imgBits;
	}

	public void setImgBits(int imgBits) {
		this.imgBits = imgBits;
	}

	public byte[] getImgDescription() {
		return this.imgDescription;
	}

	public void setImgDescription(byte[] imgDescription) {
		this.imgDescription = imgDescription;
	}

	public int getImgHeight() {
		return this.imgHeight;
	}

	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}

	public String getImgMajorMime() {
		return this.imgMajorMime;
	}

	public void setImgMajorMime(String imgMajorMime) {
		this.imgMajorMime = imgMajorMime;
	}

	public String getImgMediaType() {
		return this.imgMediaType;
	}

	public void setImgMediaType(String imgMediaType) {
		this.imgMediaType = imgMediaType;
	}

	public byte[] getImgMetadata() {
		return this.imgMetadata;
	}

	public void setImgMetadata(byte[] imgMetadata) {
		this.imgMetadata = imgMetadata;
	}

	public byte[] getImgMinorMime() {
		return this.imgMinorMime;
	}

	public void setImgMinorMime(byte[] imgMinorMime) {
		this.imgMinorMime = imgMinorMime;
	}

	public byte[] getImgSha1() {
		return this.imgSha1;
	}

	public void setImgSha1(byte[] imgSha1) {
		this.imgSha1 = imgSha1;
	}

	public int getImgSize() {
		return this.imgSize;
	}

	public void setImgSize(int imgSize) {
		this.imgSize = imgSize;
	}

	public byte[] getImgTimestamp() {
		return this.imgTimestamp;
	}

	public void setImgTimestamp(byte[] imgTimestamp) {
		this.imgTimestamp = imgTimestamp;
	}

	public int getImgUser() {
		return this.imgUser;
	}

	public void setImgUser(int imgUser) {
		this.imgUser = imgUser;
	}

	public String getImgUserText() {
		return this.imgUserText;
	}

	public void setImgUserText(String imgUserText) {
		this.imgUserText = imgUserText;
	}

	public int getImgWidth() {
		return this.imgWidth;
	}

	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}

}