package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the wdmsg_resource_links database table.
 * 
 */
@Entity
@Table(name="wdmsg_resource_links")
@NamedQuery(name="WdmsgResourceLink.findAll", query="SELECT w FROM WdmsgResourceLink w")
public class WdmsgResourceLink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="mrl_message")
	private byte[] mrlMessage;

	@Column(name="mrl_resource")
	private byte[] mrlResource;

	public WdmsgResourceLink() {
	}

	public byte[] getMrlMessage() {
		return this.mrlMessage;
	}

	public void setMrlMessage(byte[] mrlMessage) {
		this.mrlMessage = mrlMessage;
	}

	public byte[] getMrlResource() {
		return this.mrlResource;
	}

	public void setMrlResource(byte[] mrlResource) {
		this.mrlResource = mrlResource;
	}

}