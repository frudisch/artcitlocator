package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the user_newtalk database table.
 * 
 */
@Entity
@Table(name="user_newtalk")
@NamedQuery(name="UserNewtalk.findAll", query="SELECT u FROM UserNewtalk u")
public class UserNewtalk implements Serializable {
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

	public UserNewtalk() {
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