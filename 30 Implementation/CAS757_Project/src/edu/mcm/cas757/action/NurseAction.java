package edu.mcm.cas757.action;

import edu.mcm.cas757.common.Constants;
import edu.mcm.cas757.dao.entity.User;
import edu.mcm.cas757.model.ObsCriteria;
import edu.mcm.cas757.model.PageDataModel;
import edu.mcm.cas757.model.UserCriteria;


@SuppressWarnings("serial")
public class NurseAction extends BaseAction {
	
	private UserCriteria user = new UserCriteria();
	private UserCriteria patient = new UserCriteria();
	private ObsCriteria obsData = new ObsCriteria();
	private String txtPatientName;
	private String hidPatientId;
	private User patientEntity;
	
	private String emtDis;
	private String congImp;
	private String psychosis;
	private String disinhibition;
	private String withdraw;


	public String getCongImp() {
		return congImp;
	}

	public void setCongImp(String congImp) {
		this.congImp = congImp;
	}

	public String getPsychosis() {
		return psychosis;
	}

	public void setPsychosis(String psychosis) {
		this.psychosis = psychosis;
	}

	public String getDisinhibition() {
		return disinhibition;
	}

	public void setDisinhibition(String disinhibition) {
		this.disinhibition = disinhibition;
	}

	public String getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}

	public String getEmtDis() {
		return emtDis;
	}

	public void setEmtDis(String emtDis) {
		this.emtDis = emtDis;
	}

	public ObsCriteria getObsData() {
		return obsData;
	}

	public void setObsData(ObsCriteria obsData) {
		this.obsData = obsData;
	}

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
	
	/*
	 * this function tell whether the checkbox has been checked.
	 */
	
	
	public String saveObservationData(){
		
		System.out.println("=======　hidPatientId　===== " + hidPatientId);
		String emtDisStr = this.getEmtDis(); 
		String congImpStr = this.getCongImp();
		String psychStr = this.getPsychosis();
		String disinhStr = this.getDisinhibition();
		String withdStr = this.getWithdraw();	
		
		String[] emtDisArr = (emtDisStr != null)? emtDisStr.split(", ") :  new String[]{"0"};
		String[] congImpArr = (congImpStr != null)?congImpStr.split(", ") :  new String[]{"0"};;
		String[] psychArr = (psychStr != null)?psychStr.split(", ") :  new String[]{"0"};;
		String[] disinhArr = (disinhStr != null)?disinhStr.split(", ") :  new String[]{"0"};;
		String[] withdArr = (withdStr != null)?withdStr.split(", ") :  new String[]{"0"};;
		
		int emtDisV = 0;
		int congImpV = 0;
		int psychV = 0;
		int disinhV = 0;
		int withdV = 0;
		
		for (int i = 0; i < emtDisArr.length; i ++){
			emtDisV += Integer.valueOf(emtDisArr[i]);
		}
		
		for (int i = 0; i < congImpArr.length; i ++){
			congImpV += Integer.valueOf(congImpArr[i]);
		}
		
		for (int i = 0; i < psychArr.length; i ++){
			psychV += Integer.valueOf(psychArr[i]);
		}
		
		for (int i = 0; i < disinhArr.length; i ++){
			disinhV += Integer.valueOf(disinhArr[i]);
		}
		
		for (int i = 0; i < withdArr.length; i ++){
			withdV += Integer.valueOf(withdArr[i]);
		}
		
		initCriteria(obsData);
		
		obsData.setEmtDis(emtDisV);
		obsData.setCongImp(congImpV);
		obsData.setPsych(psychV);
		obsData.setDisinh(disinhV);
		obsData.setWithd(withdV);
		obsData.setPatientId(((User)getSession().get(Constants.CURR_PATIENT)).getId());
		
		try {
			serviceLocator.getObsDataService().saveObsData(obsData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
		return "saveObs_success";
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
