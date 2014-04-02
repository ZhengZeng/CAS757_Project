package edu.mcm.cas757.model;

@SuppressWarnings("serial")
public class UserCriteria extends BaseCriteria implements java.io.Serializable {
    private int role;
    private String pwd;
    private Integer userId;
	private String userName;
	private String comments;
    
    public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getRole() {
		return role;
	}


	public void setRole(int role) {
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


    /**
     * default constructor
     */
    public UserCriteria() {
    }

}