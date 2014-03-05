package edu.mcm.cas757.dao.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "t_user", catalog = "cas757"
)

public class Tuser implements java.io.Serializable {

	private static final long serialVersionUID = -727099224747798213L;
	
	private String role;
    private String pwd;
    private Integer userId;
    private String userName;
    
    @Column(name = "role", length = 200)
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "pwd", length = 200)
	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "UserID", unique = true, nullable = false)
	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "UserName", length = 20)
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


    /**
     * default constructor
     */
    public Tuser() {
    }

}