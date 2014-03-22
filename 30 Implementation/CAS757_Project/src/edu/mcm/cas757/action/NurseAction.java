package edu.mcm.cas757.action;

import edu.mcm.cas757.common.Constants;
import edu.mcm.cas757.dao.entity.User;
import edu.mcm.cas757.model.PageDataModel;
import edu.mcm.cas757.model.UserCriteria;


@SuppressWarnings("serial")
public class NurseAction extends BaseAction {
	
	private UserCriteria user = new UserCriteria();
	private UserCriteria patient = new UserCriteria();
	private String txtPatientName;
	private String hidPatientId;
	private User patientEntity;


	public User getPatientEntity() {
		return patientEntity;
	}

	public void setPatientEntity(User patientEntity) {
		this.patientEntity = patientEntity;
	}

	public String getHidPatientId() {
		return hidPatientId;
	}

	public void setHidPatientId(String hidPatientId) {
		this.hidPatientId = hidPatientId;
	}

	public String initSearchPatient(){
		initCriteria(patient);
		PageDataModel<User> dataModule = serviceLocator.getUserService()
				.getPatientDataModule(patient);
		if(dataModule != null){
			getRequest().put("patients", dataModule);
		}
		
		return "searchPatient_init";
	}
	
	public String searchPatient(){
		System.out.println("--- this.PatientName:" + this.txtPatientName);
		initCriteria(patient);
		patient.setQueryString("and u.name like '%" + this.txtPatientName +"%'");
		PageDataModel<User> dataModule = serviceLocator.getUserService()
				.findPatientsByUsername(patient);
		if(dataModule != null){
			getRequest().put("patients", dataModule);
		}
		return "search_success";
	}
	
	public String pickPatient(){
		// for displaying by display tag
		patientEntity = serviceLocator.getUserService().findUserById(Integer.valueOf(this.hidPatientId));
		if(patientEntity != null){
			System.out.println("--- Pick PatientName:" + patientEntity.getName());
			getSession().put(Constants.CURR_PATIENT, patientEntity);
			return "pick_success";
		}else 
			return ERROR;
	}

	public UserCriteria getPatient() {
		return patient;
	}

	public void setPatient(UserCriteria patient) {
		this.patient = patient;
	}

	public UserCriteria getUser() {
		return user;
	}

	public void setUser(UserCriteria user) {
		this.user = user;
	}

	public String getTxtPatientName() {
		return txtPatientName;
	}

	public void setTxtPatientName(String txtPatientName) {
		this.txtPatientName = txtPatientName;
	}

	/*
	//Test Login
	public String findPatients() {

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
			return ERROR;
		}
		User userEntity = serviceLocator.getUserService().findUserByUsername(username);
		user.setRole(userEntity.getRole());
		user.setUserId(userEntity.getId());

		if (getSession().get(Constants.USER_INFO) != null) {
			getSession().remove(Constants.USER_INFO);
		}
		getSession().put(Constants.USER_INFO, user);
		return SUCCESS;
	}
	*/
	

}
