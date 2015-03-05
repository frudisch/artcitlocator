package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdtranscache database table.
 * 
 */
@Entity
@NamedQuery(name="Wdtranscache.findAll", query="SELECT w FROM Wdtranscache w")
public class Wdtranscache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Lob
	@Column(name="tc_contents")
	private byte[] tcContents;

	@Column(name="tc_time")
	private byte[] tcTime;

	@Column(name="tc_url")
	private byte[] tcUrl;

	public Wdtranscache() {
	}

	public byte[] getTcContents() {
		return this.tcContents;
	}

	public void setTcContents(byte[] tcContents) {
		this.tcContents = tcContents;
	}

	public byte[] getTcTime() {
		return this.tcTime;
	}

	public void setTcTime(byte[] tcTime) {
		this.tcTime = tcTime;
	}

	public byte[] getTcUrl() {
		return this.tcUrl;
	}

	public void setTcUrl(byte[] tcUrl) {
		this.tcUrl = tcUrl;
	}

}