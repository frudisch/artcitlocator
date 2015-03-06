package artcitlocator.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the job database table.
 * 
 */
@Entity
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="job_id")
	private int jobId;

	@Column(name="job_cmd")
	private byte[] jobCmd;

	@Column(name="job_namespace")
	private int jobNamespace;

	@Lob
	@Column(name="job_params")
	private byte[] jobParams;

	@Column(name="job_timestamp")
	private byte[] jobTimestamp;

	@Column(name="job_title")
	private String jobTitle;

	public Job() {
	}

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
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

	public byte[] getJobTimestamp() {
		return this.jobTimestamp;
	}

	public void setJobTimestamp(byte[] jobTimestamp) {
		this.jobTimestamp = jobTimestamp;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}