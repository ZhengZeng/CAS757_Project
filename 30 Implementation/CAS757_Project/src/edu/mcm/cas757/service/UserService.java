package edu.mcm.cas757.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mcm.cas757.dao.BaseDao;
import edu.mcm.cas757.dao.entity.Tuser;
import edu.mcm.cas757.model.User;


@Service("userService")
public class UserService {

    @Autowired
    private BaseDao<Tuser> userDao;

    @Transactional
    public void saveUser(User user) {
        Tuser t = new Tuser();
        BeanUtils.copyProperties(user,t);
        userDao.save(t);
    }
    //Get user list
    @Transactional
    public List<Tuser> findUser(String hql){
    	List<Tuser> userList = userDao.find(hql);
    	return userList;
    }
    
    //Update user
    @Transactional
    public Tuser updateUser(Tuser user){
    	userDao.update(user);
    	return user;
    }
    

    
    
    
    
    
    
    
    
}
