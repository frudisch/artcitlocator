package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the categorylinks database table.
 * 
 */
@Entity
@Table(name="categorylinks")
@NamedQuery(name="Categorylink.findAll", query="SELECT c FROM Categorylink c")
public class Categorylink implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="cl_collation")
	private byte[] clCollation;

	@Column(name="cl_from")
	private int clFrom;

	@Column(name="cl_sortkey")
	private byte[] clSortkey;

	@Column(name="cl_sortkey_prefix")
	private String clSortkeyPrefix;

	@Column(name="cl_timestamp")
	private Timestamp clTimestamp;

	@Column(name="cl_to")
	private String clTo;

	@Column(name="cl_type")
	private String clType;

	public Categorylink() {
	}

	public byte[] getClCollation() {
		return this.clCollation;
	}

	public void setClCollation(byte[] clCollation) {
		this.clCollation = clCollation;
	}

	public int getClFrom() {
		return this.clFrom;
	}

	public void setClFrom(int clFrom) {
		this.clFrom = clFrom;
	}

	public byte[] getClSortkey() {
		return this.clSortkey;
	}

	public void setClSortkey(byte[] clSortkey) {
		this.clSortkey = clSortkey;
	}

	public String getClSortkeyPrefix() {
		return this.clSortkeyPrefix;
	}

	public void setClSortkeyPrefix(String clSortkeyPrefix) {
		this.clSortkeyPrefix = clSortkeyPrefix;
	}

	public Timestamp getClTimestamp() {
		return this.clTimestamp;
	}

	public void setClTimestamp(Timestamp clTimestamp) {
		this.clTimestamp = clTimestamp;
	}

	public String getClTo() {
		return this.clTo;
	}

	public void setClTo(String clTo) {
		this.clTo = clTo;
	}

	public String getClType() {
		return this.clType;
	}

	public void setClType(String clType) {
		this.clType = clType;
	}

}