package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdlog_search database table.
 * 
 */
@Entity
@Table(name="wdlog_search")
@NamedQuery(name="WdlogSearch.findAll", query="SELECT w FROM WdlogSearch w")
public class WdlogSearch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="ls_field")
	private byte[] lsField;

	@Column(name="ls_log_id")
	private int lsLogId;

	@Column(name="ls_value")
	private byte[] lsValue;

	public WdlogSearch() {
	}

	public byte[] getLsField() {
		return this.lsField;
	}

	public void setLsField(byte[] lsField) {
		this.lsField = lsField;
	}

	public int getLsLogId() {
		return this.lsLogId;
	}

	public void setLsLogId(int lsLogId) {
		this.lsLogId = lsLogId;
	}

	public byte[] getLsValue() {
		return this.lsValue;
	}

	public void setLsValue(byte[] lsValue) {
		this.lsValue = lsValue;
	}

}