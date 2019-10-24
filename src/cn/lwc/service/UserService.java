package cn.lwc.service;

import java.util.List;

import cn.lwc.entity.User;

public interface UserService {
	public void register(User user);

	public int registerCheck(String userName);

	public User login(User user);

	public int changePwd(User user);

	public List<User> findAllUser();

}
