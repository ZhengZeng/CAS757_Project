package edu.mcm.cas757.model;

@SuppressWarnings("serial")
public class ObsCriteria extends BaseCriteria implements java.io.Serializable {

	int emtDis;
	int congImp;
	int psych;
	int disinh;
	int withd;
	int patientId;
	
	public int getPatientId() {
		return patientId;
	}



	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}



	public int getEmtDis() {
		return emtDis;
	}



	public void setEmtDis(int emtDis) {
		this.emtDis = emtDis;
	}



	public int getCongImp() {
		return congImp;
	}



	public void setCongImp(int congImp) {
		this.congImp = congImp;
	}



	public int getPsych() {
		return psych;
	}



	public void setPsych(int psych) {
		this.psych = psych;
	}



	public int getDisinh() {
		return disinh;
	}



	public void setDisinh(int disinh) {
		this.disinh = disinh;
	}



	public int getWithd() {
		return withd;
	}



	public void setWithd(int withd) {
		this.withd = withd;
	}



	public ObsCriteria() {
		// TODO Auto-generated constructor stub
	}
	
}
