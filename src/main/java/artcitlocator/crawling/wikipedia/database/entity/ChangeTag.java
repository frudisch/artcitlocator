package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the change_tag database table.
 * 
 */
@Entity
@Table(name="change_tag")
@NamedQuery(name="ChangeTag.findAll", query="SELECT c FROM ChangeTag c")
public class ChangeTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="ct_log_id")
	private int ctLogId;

	@Lob
	@Column(name="ct_params")
	private byte[] ctParams;

	@Column(name="ct_rc_id")
	private int ctRcId;

	@Column(name="ct_rev_id")
	private int ctRevId;

	@Column(name="ct_tag")
	private String ctTag;

	public ChangeTag() {
	}

	public int getCtLogId() {
		return this.ctLogId;
	}

	public void setCtLogId(int ctLogId) {
		this.ctLogId = ctLogId;
	}

	public byte[] getCtParams() {
		return this.ctParams;
	}

	public void setCtParams(byte[] ctParams) {
		this.ctParams = ctParams;
	}

	public int getCtRcId() {
		return this.ctRcId;
	}

	public void setCtRcId(int ctRcId) {
		this.ctRcId = ctRcId;
	}

	public int getCtRevId() {
		return this.ctRevId;
	}

	public void setCtRevId(int ctRevId) {
		this.ctRevId = ctRevId;
	}

	public String getCtTag() {
		return this.ctTag;
	}

	public void setCtTag(String ctTag) {
		this.ctTag = ctTag;
	}

}