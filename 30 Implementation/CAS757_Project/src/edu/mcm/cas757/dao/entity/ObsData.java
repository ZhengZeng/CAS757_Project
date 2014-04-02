package edu.mcm.cas757.dao.entity;

public class ObsData extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3438721351216025224L;

	private Integer id;
	private Integer patientId;

	int emtDisV = 0;
	int congImpV = 0;
	int psychV = 0;
	int disinhV = 0;
	int withdV = 0;
	
	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getEmtDisV() {
		return emtDisV;
	}

	public void setEmtDisV(int emtDisV) {
		this.emtDisV = emtDisV;
	}

	public int getCongImpV() {
		return congImpV;
	}

	public void setCongImpV(int congImpV) {
		this.congImpV = congImpV;
	}

	public int getPsychV() {
		return psychV;
	}

	public void setPsychV(int psychV) {
		this.psychV = psychV;
	}

	public int getDisinhV() {
		return disinhV;
	}

	public void setDisinhV(int disinhV) {
		this.disinhV = disinhV;
	}

	public int getWithdV() {
		return withdV;
	}

	public void setWithdV(int withdV) {
		this.withdV = withdV;
	}

	public ObsData() {
		// TODO Auto-generated constructor stub
	}

}
