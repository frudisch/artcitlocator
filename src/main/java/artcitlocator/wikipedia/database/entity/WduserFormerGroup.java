package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wduser_former_groups database table.
 * 
 */
@Entity
@Table(name="wduser_former_groups")
@NamedQuery(name="WduserFormerGroup.findAll", query="SELECT w FROM WduserFormerGroup w")
public class WduserFormerGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="ufg_group")
	private byte[] ufgGroup;

	@Column(name="ufg_user")
	private int ufgUser;

	public WduserFormerGroup() {
	}

	public byte[] getUfgGroup() {
		return this.ufgGroup;
	}

	public void setUfgGroup(byte[] ufgGroup) {
		this.ufgGroup = ufgGroup;
	}

	public int getUfgUser() {
		return this.ufgUser;
	}

	public void setUfgUser(int ufgUser) {
		this.ufgUser = ufgUser;
	}

}