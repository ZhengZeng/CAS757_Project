package edu.mcm.cas757.action;

import java.util.Date;

import edu.mcm.cas757.common.Constants;
import edu.mcm.cas757.dao.entity.User;
import edu.mcm.cas757.model.PageDataModel;
import edu.mcm.cas757.model.UserCriteria;

@SuppressWarnings("serial")
public class AdminAction extends BaseAction {

	private UserCriteria userInfo = new UserCriteria();
	private User user;
	private String txtUserName;
	private String txtPwd;
	private String txtCom;
	private int	ddRole;
	private String hidUserId; 
	
	public UserCriteria getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserCriteria userInfo) {
		this.userInfo = userInfo;
	}

	public String getHidUserId() {
		return hidUserId;
	}

	public void setHidUserId(String hidUserId) {
		this.hidUserId = hidUserId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(String txtUserName) {
		this.txtUserName = txtUserName;
	}

	public String getTxtPwd() {
		return txtPwd;
	}

	public void setTxtPwd(String txtPwd) {
		this.txtPwd = txtPwd;
	}

	public String getTxtCom() {
		return txtCom;
	}

	public void setTxtCom(String txtCom) {
		this.txtCom = txtCom;
	}

	public int getDdRole() {
		return ddRole;
	}

	public void setDdRole(int ddRole) {
		this.ddRole = ddRole;
	}

	
	public String initAdminPage(){
		initCriteria(userInfo);
		PageDataModel<User> dataModule = serviceLocator.getUserService()
				.getUserDataModule(userInfo);
		if(dataModule != null){
			getRequest().put("users", dataModule);
		}
		return "init_success";
	}
	
	public String createUser(){
		
		userInfo = (UserCriteria) getSession().get(Constants.USER_INFO);
		userInfo.setUserName(txtUserName);
		userInfo.setPwd(txtPwd);
		userInfo.setRole(ddRole);
		userInfo.setComments(txtCom);
		try {
			serviceLocator.getUserService().saveUser(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		return "create_success";
	}
	
	public String updateUser(){
		
		userInfo = (UserCriteria) getSession().get(Constants.USER_INFO);
		System.out.println("--- this.hidUserId:" + this.hidUserId);
		System.out.println("--- this.txtUserName:" + this.txtUserName);
		System.out.println("--- this.user.id:" + this.user.getId());
		user = serviceLocator.getUserService().findUserById(this.user.getId());
		try {
			user.setName(txtUserName);
			user.setPassword(txtPwd);
			user.setRole(ddRole);
			user.setComments(txtCom);
			user.setUpdateBy(userInfo.getUserId());
			user.setUpdateDate(new Date());

			serviceLocator.getUserService().updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		return "update_success";
	}
	
	public String searchUser(){
		initCriteria(userInfo);
		PageDataModel<User> dataModule = serviceLocator.getUserService()
				.getUserDataModule(userInfo);
		if(dataModule != null){
			getRequest().put("users", dataModule);
		}
		return "search_success";
	}
	
	public String pickUser(){
		// for displaying by display tag
		user = serviceLocator.getUserService().findUserById(Integer.valueOf(this.hidUserId));
		initCriteria(userInfo);
		userInfo.setPage(page);
		PageDataModel<User> dataModel = serviceLocator.getUserService()
				.getUserDataModule(userInfo);
		getRequest().put("users", dataModel);
		
		return "pick_success";
	}
	
	public String delUser(){
		
		userInfo = (UserCriteria) getSession().get(Constants.USER_INFO);

		user = serviceLocator.getUserService().findUserById(this.user.getId());
		try {
			user.setDefunct("Y");
			user.setUpdateBy(userInfo.getUserId());
			user.setUpdateDate(new Date());

			serviceLocator.getUserService().updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		
		return "del_success";
	}
	
}
