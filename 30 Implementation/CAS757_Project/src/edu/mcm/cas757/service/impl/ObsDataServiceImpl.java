package edu.mcm.cas757.service.impl;

import java.util.Date;

import edu.mcm.cas757.dao.BaseDao;
import edu.mcm.cas757.dao.entity.ObsData;
import edu.mcm.cas757.model.ObsCriteria;
import edu.mcm.cas757.model.PageDataModel;
import edu.mcm.cas757.service.IObsDataService;

public class ObsDataServiceImpl implements IObsDataService {
	
    private BaseDao<ObsData> baseDao;

    public void setBaseDao(BaseDao<ObsData> baseDao) {
		this.baseDao = baseDao;
	}
    

	public ObsDataServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveObsData(ObsCriteria obsData) {
		ObsData obsDataEntity = new ObsData();
		obsDataEntity.setCongImpV(obsData.getCongImp());
		obsDataEntity.setDisinhV(obsData.getDisinh());
		obsDataEntity.setEmtDisV(obsData.getEmtDis());
		obsDataEntity.setPsychV(obsData.getPsych());
		obsDataEntity.setWithdV(obsData.getWithd());
		obsDataEntity.setPatientId(obsData.getPatientId());
		obsDataEntity.setCreateDate(new Date());
		obsDataEntity.setUpdateDate(new Date());
        baseDao.save(obsDataEntity);
		
	}
	
	@Override
	public PageDataModel<ObsData>  getObsDataByPatId(ObsCriteria obsData) {
		String hql = "from ObsData obs where obs.patientId = " + obsData.getPatientId();
		obsData.setQueryString(hql);
		PageDataModel<ObsData> pageDataModule = null;
		pageDataModule = baseDao.loadPageData(obsData);
		return pageDataModule;
	}

}
