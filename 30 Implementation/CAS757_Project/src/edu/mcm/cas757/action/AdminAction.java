package edu.mcm.cas757.action;

import edu.mcm.cas757.common.Constants;
import edu.mcm.cas757.dao.entity.User;
import edu.mcm.cas757.model.PageDataModel;
import edu.mcm.cas757.model.UserCriteria;

@SuppressWarnings("serial")
public class AdminAction extends BaseAction {

	private UserCriteria userModule = new UserCriteria();
	String txtUserName;
	String txtPwd;
	String txtCom;
	int	ddRole;
	
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
		initCriteria(userModule);
		PageDataModel<User> dataModule = serviceLocator.getUserService()
				.getUserDataModule(userModule);
		if(dataModule != null){
			getRequest().put("users", dataModule);
		}
		return "init_success";
	}
	
	public String createUser(){
		
		userModule = (UserCriteria) getSession().get(Constants.USER_INFO);
		userModule.setUserName(txtUserName);
		userModule.setPwd(txtPwd);
		userModule.setRole(ddRole);
		userModule.setComments(txtCom);
		try {
			serviceLocator.getUserService().saveUser(userModule);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		return "create_success";
	}
	
	public String searchUser(){
		initCriteria(userModule);
		PageDataModel<User> dataModule = serviceLocator.getUserService()
				.getUserDataModule(userModule);
		if(dataModule != null){
			getRequest().put("users", dataModule);
		}
		return "search_success";
	}
	
}
