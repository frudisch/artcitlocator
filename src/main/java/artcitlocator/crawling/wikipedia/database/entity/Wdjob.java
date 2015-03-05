package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wdjob database table.
 * 
 */
@Entity
@NamedQuery(name="Wdjob.findAll", query="SELECT w FROM Wdjob w")
public class Wdjob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="job_id")
	private int jobId;

	@Column(name="job_attempts")
	private int jobAttempts;

	@Column(name="job_cmd")
	private byte[] jobCmd;

	@Column(name="job_namespace")
	private int jobNamespace;

	@Lob
	@Column(name="job_params")
	private byte[] jobParams;

	@Column(name="job_random")
	private int jobRandom;

	@Column(name="job_sha1")
	private byte[] jobSha1;

	@Column(name="job_timestamp")
	private byte[] jobTimestamp;

	@Column(name="job_title")
	private byte[] jobTitle;

	@Column(name="job_token")
	private byte[] jobToken;

	@Column(name="job_token_timestamp")
	private byte[] jobTokenTimestamp;

	public Wdjob() {
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getJobAttempts() {
		return this.jobAttempts;
	}

	public void setJobAttempts(int jobAttempts) {
		this.jobAttempts = jobAttempts;
	}

	public byte[] getJobCmd() {
		return this.jobCmd;
	}

	public void setJobCmd(byte[] jobCmd) {
		this.jobCmd = jobCmd;
	}

	public int getJobNamespace() {
		return this.jobNamespace;
	}

	public void setJobNamespace(int jobNamespace) {
		this.jobNamespace = jobNamespace;
	}

	public byte[] getJobParams() {
		return this.jobParams;
	}

	public void setJobParams(byte[] jobParams) {
		this.jobParams = jobParams;
	}

	public int getJobRandom() {
		return this.jobRandom;
	}

	public void setJobRandom(int jobRandom) {
		this.jobRandom = jobRandom;
	}

	public byte[] getJobSha1() {
		return this.jobSha1;
	}

	public void setJobSha1(byte[] jobSha1) {
		this.jobSha1 = jobSha1;
	}

	public byte[] getJobTimestamp() {
		return this.jobTimestamp;
	}

	public void setJobTimestamp(byte[] jobTimestamp) {
		this.jobTimestamp = jobTimestamp;
	}

	public byte[] getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(byte[] jobTitle) {
		this.jobTitle = jobTitle;
	}

	public byte[] getJobToken() {
		return this.jobToken;
	}

	public void setJobToken(byte[] jobToken) {
		this.jobToken = jobToken;
	}

	public byte[] getJobTokenTimestamp() {
		return this.jobTokenTimestamp;
	}

	public void setJobTokenTimestamp(byte[] jobTokenTimestamp) {
		this.jobTokenTimestamp = jobTokenTimestamp;
	}

}