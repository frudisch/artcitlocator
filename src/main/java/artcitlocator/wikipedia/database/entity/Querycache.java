package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the querycache database table.
 * 
 */
@Entity
@NamedQuery(name = "Querycache.findAll", query = "SELECT q FROM Querycache q")
public class Querycache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "qc_namespace")
	private int qcNamespace;

	@Column(name = "qc_title")
	private String qcTitle;

	@Column(name = "qc_type")
	private byte[] qcType;

	@Column(name = "qc_value")
	private int qcValue;

	public Querycache() {
	}

	public int getQcNamespace() {
		return this.qcNamespace;
	}

	public void setQcNamespace(int qcNamespace) {
		this.qcNamespace = qcNamespace;
	}

	public String getQcTitle() {
		return this.qcTitle;
	}

	public void setQcTitle(String qcTitle) {
		this.qcTitle = qcTitle;
	}

	public byte[] getQcType() {
		return this.qcType;
	}

	public void setQcType(byte[] qcType) {
		this.qcType = qcType;
	}

	public int getQcValue() {
		return this.qcValue;
	}

	public void setQcValue(int qcValue) {
		this.qcValue = qcValue;
	}

}