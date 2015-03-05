package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdquerycachetwo database table.
 * 
 */
@Entity
@NamedQuery(name="Wdquerycachetwo.findAll", query="SELECT w FROM Wdquerycachetwo w")
public class Wdquerycachetwo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="qcc_namespace")
	private int qccNamespace;

	@Column(name="qcc_namespacetwo")
	private int qccNamespacetwo;

	@Column(name="qcc_title")
	private byte[] qccTitle;

	@Column(name="qcc_titletwo")
	private byte[] qccTitletwo;

	@Column(name="qcc_type")
	private byte[] qccType;

	@Column(name="qcc_value")
	private int qccValue;

	public Wdquerycachetwo() {
	}

	public int getQccNamespace() {
		return this.qccNamespace;
	}

	public void setQccNamespace(int qccNamespace) {
		this.qccNamespace = qccNamespace;
	}

	public int getQccNamespacetwo() {
		return this.qccNamespacetwo;
	}

	public void setQccNamespacetwo(int qccNamespacetwo) {
		this.qccNamespacetwo = qccNamespacetwo;
	}

	public byte[] getQccTitle() {
		return this.qccTitle;
	}

	public void setQccTitle(byte[] qccTitle) {
		this.qccTitle = qccTitle;
	}

	public byte[] getQccTitletwo() {
		return this.qccTitletwo;
	}

	public void setQccTitletwo(byte[] qccTitletwo) {
		this.qccTitletwo = qccTitletwo;
	}

	public byte[] getQccType() {
		return this.qccType;
	}

	public void setQccType(byte[] qccType) {
		this.qccType = qccType;
	}

	public int getQccValue() {
		return this.qccValue;
	}

	public void setQccValue(int qccValue) {
		this.qccValue = qccValue;
	}

}