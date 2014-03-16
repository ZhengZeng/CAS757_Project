package edu.mcm.cas757.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;

import edu.mcm.cas757.dao.BaseDao;
import edu.mcm.cas757.dao.entity.User;
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
        BeanUtils.copyProperties(user,t);
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
	
	public boolean isExist(UserCriteria user) {
		User userFind = this.findUserByUsername(user.getUserName());
		return (userFind != null && userFind.getPassword().equals(user.getPwd()));
	}
    
}
