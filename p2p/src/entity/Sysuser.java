package entity;

/**
 * Sysuser entity. @author MyEclipse Persistence Tools
 */

public class Sysuser implements java.io.Serializable {
	
	/**
	 * SuperAdministrator
	 */
	public static final String STATUS_SUPERADMIN = "S";
	/**
	 * Administrator
	 */
	public static final String STATUS_ADMIN = "A";
	/**
	 * Ordinary Person ; Default
	 */
	public static final String STATUS_ORDINARY = "O";
	/**
	 * Deleted
	 */
	public static final String STATUS_DELETED = "D";
	/**
	 * 管理员id
	 */
	private Integer id;
	/**
	 * 管理员名称
	 */
	private String userName;
	/**
	 * 管理员登录名
	 */
	private String loginName;
	/**
	 * 管理员登录密码
	 */
	private String loginPassword;
	/**
	 * 管理员的权限级别
	 */
	private String status;

	// Constructors

	/** default constructor */
	public Sysuser() {
	}

	/** full constructor */
	public Sysuser(String userName, String loginName, String loginPassword,String status) {
		this.userName = userName;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}