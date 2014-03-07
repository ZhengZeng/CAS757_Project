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
	/* (non-Javadoc)
	 * @see edu.mcm.cas757.service.impl.IUserServiceImpl#saveUser(edu.mcm.cas757.model.User)
	 */
    @Override
	public void saveUser(UserCriteria user) {
        User t = new User();
        BeanUtils.copyProperties(user,t);
        baseDao.save(t);
    }
    //Get user list
    /* (non-Javadoc)
	 * @see edu.mcm.cas757.service.impl.IUserServiceImpl#findUser(java.lang.String)
	 */
    @Override
	public List<User> findUser(String hql){
    	List<User> userList = baseDao.find(hql);
    	return userList;
    }
    
    //Update user
    /* (non-Javadoc)
	 * @see edu.mcm.cas757.service.impl.IUserServiceImpl#updateUser(edu.mcm.cas757.dao.entity.Tuser)
	 */
    @Override
	public User updateUser(User user){
    	baseDao.update(user);
    	return user;
    }

    
}
