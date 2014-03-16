package edu.mcm.cas757.action;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;

import edu.mcm.cas757.common.Constants;
import edu.mcm.cas757.dao.entity.User;
import edu.mcm.cas757.model.UserCriteria;


@SuppressWarnings("serial")
public class UserAction extends BaseAction implements ModelDriven<UserCriteria>,SessionAware {
	
	private UserCriteria user = new UserCriteria();
	private String pwd_login;
	private String role;
	private String username;

	public String getPwd_login() {
		return pwd_login;
	}

	public void setPwd_login(String pwd_login) {
		this.pwd_login = pwd_login;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		if (getSession().get(Constants.USER_INFO) != null) {
			return SUCCESS;
		}
		//String pwd = MD5.MD5Encode(pwd_login);
		user.setPwd(pwd_login);
		user.setUserName(username);
		if ("".equals(user.getUserName().trim())) {
			addFieldError("user.name", "Please input your user name!");
		} else if ("".equals(user.getPwd())) {
			addFieldError("user.password", "Please input your password!");
		}
		
		boolean isFind = serviceLocator.getUserService().isExist(user);

		if (!isFind) {
			addFieldError("error", "The user name or password is wrong!");
			return "error";
		}
		User userEntity = serviceLocator.getUserService().findUserByUsername(username);
		//user.setRole(userEntity.getRole().getName());

		if (getSession().get(Constants.USER_INFO) != null) {
			getSession().remove(Constants.USER_INFO);
		}
		getSession().put(Constants.USER_INFO, user);
		return "success";
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
		
	
	

}
