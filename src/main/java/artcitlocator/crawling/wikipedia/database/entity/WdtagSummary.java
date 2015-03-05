package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdtag_summary database table.
 * 
 */
@Entity
@Table(name="wdtag_summary")
@NamedQuery(name="WdtagSummary.findAll", query="SELECT w FROM WdtagSummary w")
public class WdtagSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="ts_log_id")
	private int tsLogId;

	@Column(name="ts_rc_id")
	private int tsRcId;

	@Column(name="ts_rev_id")
	private int tsRevId;

	@Lob
	@Column(name="ts_tags")
	private byte[] tsTags;

	public WdtagSummary() {
	}

	public int getTsLogId() {
		return this.tsLogId;
	}

	public void setTsLogId(int tsLogId) {
		this.tsLogId = tsLogId;
	}

	public int getTsRcId() {
		return this.tsRcId;
	}

	public void setTsRcId(int tsRcId) {
		this.tsRcId = tsRcId;
	}

	public int getTsRevId() {
		return this.tsRevId;
	}

	public void setTsRevId(int tsRevId) {
		this.tsRevId = tsRevId;
	}

	public byte[] getTsTags() {
		return this.tsTags;
	}

	public void setTsTags(byte[] tsTags) {
		this.tsTags = tsTags;
	}

}