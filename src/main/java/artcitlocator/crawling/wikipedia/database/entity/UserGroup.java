package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the user_groups database table.
 * 
 */
@Entity
@Table(name="user_groups")
@NamedQuery(name="UserGroup.findAll", query="SELECT u FROM UserGroup u")
public class UserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="ug_group")
	private byte[] ugGroup;

	@Column(name="ug_user")
	private int ugUser;

	public UserGroup() {
	}

	public byte[] getUgGroup() {
		return this.ugGroup;
	}

	public void setUgGroup(byte[] ugGroup) {
		this.ugGroup = ugGroup;
	}

	public int getUgUser() {
		return this.ugUser;
	}

	public void setUgUser(int ugUser) {
		this.ugUser = ugUser;
	}

}