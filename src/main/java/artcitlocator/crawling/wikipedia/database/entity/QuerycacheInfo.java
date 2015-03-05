package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the querycache_info database table.
 * 
 */
@Entity
@Table(name="querycache_info")
@NamedQuery(name="QuerycacheInfo.findAll", query="SELECT q FROM QuerycacheInfo q")
public class QuerycacheInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="qci_timestamp")
	private byte[] qciTimestamp;

	@Column(name="qci_type")
	private byte[] qciType;

	public QuerycacheInfo() {
	}

	public byte[] getQciTimestamp() {
		return this.qciTimestamp;
	}

	public void setQciTimestamp(byte[] qciTimestamp) {
		this.qciTimestamp = qciTimestamp;
	}

	public byte[] getQciType() {
		return this.qciType;
	}

	public void setQciType(byte[] qciType) {
		this.qciType = qciType;
	}

}