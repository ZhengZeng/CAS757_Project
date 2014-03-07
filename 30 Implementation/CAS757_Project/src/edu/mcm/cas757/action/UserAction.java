package edu.mcm.cas757.action;

import java.util.List;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;

import edu.mcm.cas757.dao.entity.User;
import edu.mcm.cas757.model.UserCriteria;


@SuppressWarnings("serial")
public class UserAction extends BaseAction implements ModelDriven<UserCriteria>,SessionAware {
	
	private UserCriteria user = new UserCriteria();
	private String pwd_login;
	private String role;
	private String userid;

	public String getPwd_login() {
		return pwd_login;
	}

	public void setPwd_login(String pwd_login) {
		this.pwd_login = pwd_login;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public UserCriteria getModel() {
		return user;
	}

	public String saveUser() {
		serviceLocator.getUserService().saveUser(user);
		return "success";
	}

	//Test Login
	public String loginUser() {

		//String pwd = MD5.MD5Encode(pwd_login);
		String pwd = pwd_login;
		
		String hql = "from User as a where a.name= '" + user.getUserName()
				+ " ' and a.password= '" + pwd + "'";

		List<User> userList = serviceLocator.getUserService().findUser(hql);
		
		if (userList.size() > 0) {			
			User loginUser = userList.get(0);
			session.put("loginUser", loginUser);
			return "success";
		} else
			return "error";
		
		//return "success";
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
		
	
	

}
