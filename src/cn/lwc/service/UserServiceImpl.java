package cn.lwc.service;


import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lwc.dao.UserDao;
import cn.lwc.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;



//	public void setDao(UserDaoImpl dao) {
//		this.dao = dao;
//	}




	public void register(User user){
		System.out.println("serviceImpl.............");
		dao.register(user);
	}




	@Override
	public int registerCheck(String userName) {
		
		return dao.usernameCheck(userName);
	}



	
	public User login(User user) {
		
		return dao.login(user);
	}




	public int changePwd(User user) {
		// TODO Auto-generated method stub
		User myUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		myUser.setUserPassword(user.getUserPassword());
		dao.update(myUser);
		return 0;
	}




	@Override
	public List<User> findAllUser() {
		return dao.findAllUser();
	}
	
}
