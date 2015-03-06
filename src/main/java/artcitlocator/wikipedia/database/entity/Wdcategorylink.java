package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the wdcategorylinks database table.
 * 
 */
@Entity
@Table(name="wdcategorylinks")
@NamedQuery(name="Wdcategorylink.findAll", query="SELECT w FROM Wdcategorylink w")
public class Wdcategorylink implements Serializable {
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
	private byte[] clSortkeyPrefix;

	@Column(name="cl_timestamp")
	private Timestamp clTimestamp;

	@Column(name="cl_to")
	private byte[] clTo;

	@Column(name="cl_type")
	private String clType;

	public Wdcategorylink() {
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

	public byte[] getClSortkeyPrefix() {
		return this.clSortkeyPrefix;
	}

	public void setClSortkeyPrefix(byte[] clSortkeyPrefix) {
		this.clSortkeyPrefix = clSortkeyPrefix;
	}

	public Timestamp getClTimestamp() {
		return this.clTimestamp;
	}

	public void setClTimestamp(Timestamp clTimestamp) {
		this.clTimestamp = clTimestamp;
	}

	public byte[] getClTo() {
		return this.clTo;
	}

	public void setClTo(byte[] clTo) {
		this.clTo = clTo;
	}

	public String getClType() {
		return this.clType;
	}

	public void setClType(String clType) {
		this.clType = clType;
	}

}