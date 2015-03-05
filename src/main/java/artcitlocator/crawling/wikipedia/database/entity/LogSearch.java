package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the log_search database table.
 * 
 */
@Entity
@Table(name="log_search")
@NamedQuery(name="LogSearch.findAll", query="SELECT l FROM LogSearch l")
public class LogSearch implements Serializable {
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
	private String lsValue;

	public LogSearch() {
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

	public String getLsValue() {
		return this.lsValue;
	}

	public void setLsValue(String lsValue) {
		this.lsValue = lsValue;
	}

}