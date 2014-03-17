package edu.mcm.cas757.service;

import java.util.List;

import edu.mcm.cas757.dao.entity.User;
import edu.mcm.cas757.model.BaseCriteria;
import edu.mcm.cas757.model.PageDataModel;
import edu.mcm.cas757.model.UserCriteria;

public interface IUserService {

	public abstract void saveUser(UserCriteria user);

	//Get user list
	public abstract List<User> findUser(String hql);

	//Update user
	public abstract User updateUser(User user);
	
	public User findUserByUsername(String username);
	
	public boolean isExist(UserCriteria user);
	
	public PageDataModel<User> getUserDataModule(BaseCriteria criteria);

}