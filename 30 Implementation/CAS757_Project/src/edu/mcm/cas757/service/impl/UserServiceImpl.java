package edu.mcm.cas757.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import edu.mcm.cas757.dao.BaseDao;
import edu.mcm.cas757.dao.entity.User;
import edu.mcm.cas757.model.BaseCriteria;
import edu.mcm.cas757.model.PageDataModel;
import edu.mcm.cas757.model.UserCriteria;
import edu.mcm.cas757.service.IUserService;


public class UserServiceImpl implements IUserService {

    private BaseDao<User> baseDao;

    public void setBaseDao(BaseDao<User> baseDao) {
		this.baseDao = baseDao;
	}

    @Override
	public void saveUser(UserCriteria user) {
		User t = new User();
		t.setName(user.getUserName());
		t.setPassword(user.getPwd());
		t.setComments(user.getComments());
		t.setRole(user.getRole());
		t.setCreatorId(user.getUserId());
		//user.setPerson(person);
		t.setUpdateBy(user.getUserId());
		t.setCreateDate(new Date());
		t.setUpdateDate(new Date());
		t.setDefunct("N");
        baseDao.save(t);
    }
    //Get user list
    @Override
	public List<User> findUser(String hql){
    	List<User> userList = baseDao.find(hql);
    	return userList;
    }
    
    //Update user
    @Override
	public User updateUser(User user){
    	baseDao.update(user);
    	return user;
    }
    
	public User findUserByUsername(String username) {
		String hql = "from User u where u.name='" + username +"'";
		List<User> users = this.findUser(hql);
		if (users != null && users.size() != 0) {
			return users.get(0);
		}
		return null;
	}
	
	public PageDataModel<User> findPatientsByUsername(UserCriteria criteria) {
		StringBuffer hql = new StringBuffer();
		hql.append("from User u where u.defunct='N' and u.role = 4 ");
		hql.append(criteria.getQueryString());
		
		criteria.setQueryString(hql.toString());
		PageDataModel<User> pageDataModule = null;
		pageDataModule = baseDao.loadPageData(criteria);
		return pageDataModule;
	}
	
	public User findUserById(int userId) {
		String hql = "from User u where u.id=" + userId +"";
		List<User> users = this.findUser(hql);
		if (users != null && users.size() != 0) {
			return users.get(0);
		}
		return null;
	}
	
	public boolean isExist(UserCriteria user) {
		User userFind = this.findUserByUsername(user.getUserName());
		return (userFind != null && userFind.getPassword().equals(user.getPwd()));
	}
	
	public PageDataModel<User> getUserDataModule(BaseCriteria criteria) {
		StringBuffer hql = new StringBuffer();
		hql.append("from User u where u.defunct='N'");
		hql.append(this.getOrder(criteria, "u"));

		criteria.setQueryString(hql.toString());
		PageDataModel<User> pageDataModule = null;
		pageDataModule = baseDao.loadPageData(criteria);
		return pageDataModule;
	}
	
	public PageDataModel<User> getPatientDataModule(UserCriteria criteria) {
		StringBuffer hql = new StringBuffer();
		hql.append("from User u where u.role = 4 and u.defunct='N'");
		hql.append(this.getOrder(criteria, "u"));

		criteria.setQueryString(hql.toString());
		PageDataModel<User> pageDataModule = null;
		pageDataModule = baseDao.loadPageData(criteria);
		return pageDataModule;
	}
	
	protected String getOrder(BaseCriteria criteria) {
		return getOrder(criteria, null);
	}

	protected String getOrder(BaseCriteria criteria, String alias) {
		StringBuffer orderby = new StringBuffer(" ");
		if (!StringUtils.isEmpty(criteria.getSortBy())) {
			orderby.append("order by ");
			if (!StringUtils.isEmpty(alias)) {
				orderby.append(alias).append(".");
			}
			orderby.append(criteria.getSortBy()).append(" ").append(
					criteria.getSortDir());
		}
		return orderby.toString();
	}
    
}
