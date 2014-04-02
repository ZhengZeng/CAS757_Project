package edu.mcm.cas757.service;

import edu.mcm.cas757.dao.entity.ObsData;
import edu.mcm.cas757.model.ObsCriteria;
import edu.mcm.cas757.model.PageDataModel;


public interface IObsDataService {

	public abstract void saveObsData(ObsCriteria obsData);
	
	public abstract PageDataModel<ObsData> getObsDataByPatId(ObsCriteria obsData);
}
