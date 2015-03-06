package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the msg_resource_links database table.
 * 
 */
@Entity
@Table(name="msg_resource_links")
@NamedQuery(name="MsgResourceLink.findAll", query="SELECT m FROM MsgResourceLink m")
public class MsgResourceLink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="mrl_message")
	private byte[] mrlMessage;

	@Column(name="mrl_resource")
	private byte[] mrlResource;

	public MsgResourceLink() {
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