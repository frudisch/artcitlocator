package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the watchlist database table.
 * 
 */
@Entity
@NamedQuery(name="Watchlist.findAll", query="SELECT w FROM Watchlist w")
public class Watchlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="wl_namespace")
	private int wlNamespace;

	@Column(name="wl_notificationtimestamp")
	private byte[] wlNotificationtimestamp;

	@Column(name="wl_title")
	private String wlTitle;

	@Column(name="wl_user")
	private int wlUser;

	public Watchlist() {
	}

	public int getWlNamespace() {
		return this.wlNamespace;
	}

	public void setWlNamespace(int wlNamespace) {
		this.wlNamespace = wlNamespace;
	}

	public byte[] getWlNotificationtimestamp() {
		return this.wlNotificationtimestamp;
	}

	public void setWlNotificationtimestamp(byte[] wlNotificationtimestamp) {
		this.wlNotificationtimestamp = wlNotificationtimestamp;
	}

	public String getWlTitle() {
		return this.wlTitle;
	}

	public void setWlTitle(String wlTitle) {
		this.wlTitle = wlTitle;
	}

	public int getWlUser() {
		return this.wlUser;
	}

	public void setWlUser(int wlUser) {
		this.wlUser = wlUser;
	}

}