package artcitlocator.crawling.wikipedia.database.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;

	@Column(name="user_editcount")
	private int userEditcount;

	@Lob
	@Column(name="user_email")
	private String userEmail;

	@Column(name="user_email_authenticated")
	private byte[] userEmailAuthenticated;

	@Column(name="user_email_token")
	private byte[] userEmailToken;

	@Column(name="user_email_token_expires")
	private byte[] userEmailTokenExpires;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_newpass_time")
	private byte[] userNewpassTime;

	@Lob
	@Column(name="user_newpassword")
	private byte[] userNewpassword;

	@Lob
	@Column(name="user_password")
	private byte[] userPassword;

	@Column(name="user_real_name")
	private String userRealName;

	@Column(name="user_registration")
	private byte[] userRegistration;

	@Column(name="user_token")
	private byte[] userToken;

	@Column(name="user_touched")
	private byte[] userTouched;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserEditcount() {
		return this.userEditcount;
	}

	public void setUserEditcount(int userEditcount) {
		this.userEditcount = userEditcount;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public byte[] getUserEmailAuthenticated() {
		return this.userEmailAuthenticated;
	}

	public void setUserEmailAuthenticated(byte[] userEmailAuthenticated) {
		this.userEmailAuthenticated = userEmailAuthenticated;
	}

	public byte[] getUserEmailToken() {
		return this.userEmailToken;
	}

	public void setUserEmailToken(byte[] userEmailToken) {
		this.userEmailToken = userEmailToken;
	}

	public byte[] getUserEmailTokenExpires() {
		return this.userEmailTokenExpires;
	}

	public void setUserEmailTokenExpires(byte[] userEmailTokenExpires) {
		this.userEmailTokenExpires = userEmailTokenExpires;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte[] getUserNewpassTime() {
		return this.userNewpassTime;
	}

	public void setUserNewpassTime(byte[] userNewpassTime) {
		this.userNewpassTime = userNewpassTime;
	}

	public byte[] getUserNewpassword() {
		return this.userNewpassword;
	}

	public void setUserNewpassword(byte[] userNewpassword) {
		this.userNewpassword = userNewpassword;
	}

	public byte[] getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(byte[] userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRealName() {
		return this.userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public byte[] getUserRegistration() {
		return this.userRegistration;
	}

	public void setUserRegistration(byte[] userRegistration) {
		this.userRegistration = userRegistration;
	}

	public byte[] getUserToken() {
		return this.userToken;
	}

	public void setUserToken(byte[] userToken) {
		this.userToken = userToken;
	}

	public byte[] getUserTouched() {
		return this.userTouched;
	}

	public void setUserTouched(byte[] userTouched) {
		this.userTouched = userTouched;
	}

}