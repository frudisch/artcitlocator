package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdmodule_deps database table.
 * 
 */
@Entity
@Table(name="wdmodule_deps")
@NamedQuery(name="WdmoduleDep.findAll", query="SELECT w FROM WdmoduleDep w")
public class WdmoduleDep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Lob
	@Column(name="md_deps")
	private byte[] mdDeps;

	@Column(name="md_module")
	private byte[] mdModule;

	@Column(name="md_skin")
	private byte[] mdSkin;

	public WdmoduleDep() {
	}

	public byte[] getMdDeps() {
		return this.mdDeps;
	}

	public void setMdDeps(byte[] mdDeps) {
		this.mdDeps = mdDeps;
	}

	public byte[] getMdModule() {
		return this.mdModule;
	}

	public void setMdModule(byte[] mdModule) {
		this.mdModule = mdModule;
	}

	public byte[] getMdSkin() {
		return this.mdSkin;
	}

	public void setMdSkin(byte[] mdSkin) {
		this.mdSkin = mdSkin;
	}

}