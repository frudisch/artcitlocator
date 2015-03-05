package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wduser_newtalk database table.
 * 
 */
@Entity
@Table(name="wduser_newtalk")
@NamedQuery(name="WduserNewtalk.findAll", query="SELECT w FROM WduserNewtalk w")
public class WduserNewtalk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;

	@Column(name="user_ip")
	private byte[] userIp;

	@Column(name="user_last_timestamp")
	private byte[] userLastTimestamp;

	public WduserNewtalk() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public byte[] getUserIp() {
		return this.userIp;
	}

	public void setUserIp(byte[] userIp) {
		this.userIp = userIp;
	}

	public byte[] getUserLastTimestamp() {
		return this.userLastTimestamp;
	}

	public void setUserLastTimestamp(byte[] userLastTimestamp) {
		this.userLastTimestamp = userLastTimestamp;
	}

}