package edu.mcm.cas757.model;



public class UserCriteria implements java.io.Serializable {
    private String role;
    private String pwd;
    private Integer userId;
    
    public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	private String userName;


    /**
     * default constructor
     */
    public UserCriteria() {
    }

}