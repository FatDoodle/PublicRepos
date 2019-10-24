package cn.lwc.dao;

import java.util.List;

import cn.lwc.entity.User;

public interface UserDao {

	public <T> void save(T t);

	public void register(User user);

	public int usernameCheck(String userName);

	public User login(User user);

	public User findUser(User user);

	public void update(User myUser);

	public List<User> findAllUser();

}
