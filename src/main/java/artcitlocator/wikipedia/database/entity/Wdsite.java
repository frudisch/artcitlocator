package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wdsites database table.
 * 
 */
@Entity
@Table(name="wdsites")
@NamedQuery(name="Wdsite.findAll", query="SELECT w FROM Wdsite w")
public class Wdsite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="site_id")
	private int siteId;

	@Lob
	@Column(name="site_config")
	private byte[] siteConfig;

	@Lob
	@Column(name="site_data")
	private byte[] siteData;

	@Column(name="site_domain")
	private byte[] siteDomain;

	@Column(name="site_forward")
	private byte siteForward;

	@Column(name="site_global_key")
	private byte[] siteGlobalKey;

	@Column(name="site_group")
	private byte[] siteGroup;

	@Column(name="site_language")
	private byte[] siteLanguage;

	@Column(name="site_protocol")
	private byte[] siteProtocol;

	@Column(name="site_source")
	private byte[] siteSource;

	@Column(name="site_type")
	private byte[] siteType;

	public Wdsite() {
	}

	public int getSiteId() {
		return this.siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public byte[] getSiteConfig() {
		return this.siteConfig;
	}

	public void setSiteConfig(byte[] siteConfig) {
		this.siteConfig = siteConfig;
	}

	public byte[] getSiteData() {
		return this.siteData;
	}

	public void setSiteData(byte[] siteData) {
		this.siteData = siteData;
	}

	public byte[] getSiteDomain() {
		return this.siteDomain;
	}

	public void setSiteDomain(byte[] siteDomain) {
		this.siteDomain = siteDomain;
	}

	public byte getSiteForward() {
		return this.siteForward;
	}

	public void setSiteForward(byte siteForward) {
		this.siteForward = siteForward;
	}

	public byte[] getSiteGlobalKey() {
		return this.siteGlobalKey;
	}

	public void setSiteGlobalKey(byte[] siteGlobalKey) {
		this.siteGlobalKey = siteGlobalKey;
	}

	public byte[] getSiteGroup() {
		return this.siteGroup;
	}

	public void setSiteGroup(byte[] siteGroup) {
		this.siteGroup = siteGroup;
	}

	public byte[] getSiteLanguage() {
		return this.siteLanguage;
	}

	public void setSiteLanguage(byte[] siteLanguage) {
		this.siteLanguage = siteLanguage;
	}

	public byte[] getSiteProtocol() {
		return this.siteProtocol;
	}

	public void setSiteProtocol(byte[] siteProtocol) {
		this.siteProtocol = siteProtocol;
	}

	public byte[] getSiteSource() {
		return this.siteSource;
	}

	public void setSiteSource(byte[] siteSource) {
		this.siteSource = siteSource;
	}

	public byte[] getSiteType() {
		return this.siteType;
	}

	public void setSiteType(byte[] siteType) {
		this.siteType = siteType;
	}

}