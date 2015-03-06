package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdmsg_resource database table.
 * 
 */
@Entity
@Table(name="wdmsg_resource")
@NamedQuery(name="WdmsgResource.findAll", query="SELECT w FROM WdmsgResource w")
public class WdmsgResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Lob
	@Column(name="mr_blob")
	private byte[] mrBlob;

	@Column(name="mr_lang")
	private byte[] mrLang;

	@Column(name="mr_resource")
	private byte[] mrResource;

	@Column(name="mr_timestamp")
	private byte[] mrTimestamp;

	public WdmsgResource() {
	}

	public byte[] getMrBlob() {
		return this.mrBlob;
	}

	public void setMrBlob(byte[] mrBlob) {
		this.mrBlob = mrBlob;
	}

	public byte[] getMrLang() {
		return this.mrLang;
	}

	public void setMrLang(byte[] mrLang) {
		this.mrLang = mrLang;
	}

	public byte[] getMrResource() {
		return this.mrResource;
	}

	public void setMrResource(byte[] mrResource) {
		this.mrResource = mrResource;
	}

	public byte[] getMrTimestamp() {
		return this.mrTimestamp;
	}

	public void setMrTimestamp(byte[] mrTimestamp) {
		this.mrTimestamp = mrTimestamp;
	}

}