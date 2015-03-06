package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wduser_groups database table.
 * 
 */
@Entity
@Table(name="wduser_groups")
@NamedQuery(name="WduserGroup.findAll", query="SELECT w FROM WduserGroup w")
public class WduserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="ug_group")
	private byte[] ugGroup;

	@Column(name="ug_user")
	private int ugUser;

	public WduserGroup() {
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