package edu.mcm.cas757.action;

import java.util.List;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import edu.mcm.cas757.common.MD5;
import edu.mcm.cas757.dao.entity.Tuser;
import edu.mcm.cas757.model.User;
import edu.mcm.cas757.service.UserService;


@SuppressWarnings("serial")
public class UserAction extends BaseAction implements ModelDriven<User>,SessionAware {
	
	private User user = new User();
	private String pwd_login;
	private String message;
	private String sendto;
	private String role;
	private String userid;

	@Autowired
	private UserService userService;


	public String getSendto() {
		return sendto;
	}

	

	public void setSendto(String sendto) {
		this.sendto = sendto;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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


	@Override
	public User getModel() {
		return user;
	}

	public String saveUser() {
		userService.saveUser(user);
		return "success";
	}

	// 登陆
	public String loginUser() {

		String pwd = MD5.MD5Encode(pwd_login);
		/*
		String hql = "from Tuser as a where a.email= '" + user.getUserName()
				+ " ' and a.pwd= '" + pwd + "'";

		List<Tuser> userList = userService.findUser(hql);
		
		if (userList.size() > 0) {			
			Tuser loginUser = userList.get(0);
			session.put("loginUser", loginUser);
			return "login_success";
		} else
			return "login_error";
		*/
		return "success";
	}
	
	//ajax用户登录
	public void ajaxLoginUser() {

		String pwd = MD5.MD5Encode(pwd_login);
		
		String hql = "from Tuser as a where a.email= '" + user.getUserName()
				+ " ' and a.pwd= '" + pwd + "'";

		List<Tuser> userList = userService.findUser(hql);
		
		if (userList.size() > 0) {
			Tuser loginUser = userList.get(0);
			session.put("loginUser", loginUser);
			super.writeJson("success");
		} else
			super.writeJson("error");
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
	
		
	
	

}
