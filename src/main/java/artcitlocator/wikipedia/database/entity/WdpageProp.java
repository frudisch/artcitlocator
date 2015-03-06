package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdpage_props database table.
 * 
 */
@Entity
@Table(name="wdpage_props")
@NamedQuery(name="WdpageProp.findAll", query="SELECT w FROM WdpageProp w")
public class WdpageProp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="pp_page")
	private int ppPage;

	@Column(name="pp_propname")
	private byte[] ppPropname;

	@Lob
	@Column(name="pp_value")
	private byte[] ppValue;

	public WdpageProp() {
	}

	public int getPpPage() {
		return this.ppPage;
	}

	public void setPpPage(int ppPage) {
		this.ppPage = ppPage;
	}

	public byte[] getPpPropname() {
		return this.ppPropname;
	}

	public void setPpPropname(byte[] ppPropname) {
		this.ppPropname = ppPropname;
	}

	public byte[] getPpValue() {
		return this.ppValue;
	}

	public void setPpValue(byte[] ppValue) {
		this.ppValue = ppValue;
	}

}