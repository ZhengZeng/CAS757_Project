package edu.mcm.cas757.action;

import edu.mcm.cas757.common.Constants;
import edu.mcm.cas757.dao.entity.ObsData;
import edu.mcm.cas757.dao.entity.User;
import edu.mcm.cas757.model.ObsCriteria;
import edu.mcm.cas757.model.PageDataModel;
import edu.mcm.cas757.model.UserCriteria;


@SuppressWarnings("serial")
public class DoctorAction extends BaseAction {
	
	private UserCriteria user = new UserCriteria();
	private UserCriteria patient = new UserCriteria();
	private ObsCriteria obsData = new ObsCriteria();
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
			
			initCriteria(obsData);
			obsData.setPatientId(patientEntity.getId());
			PageDataModel<ObsData> dataModule = serviceLocator.getObsDataService().getObsDataByPatId(obsData);
			if(dataModule != null){
				getRequest().put("obsData", dataModule);
			}
			
			
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

}
