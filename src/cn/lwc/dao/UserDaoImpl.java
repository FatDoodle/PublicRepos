package cn.lwc.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.lwc.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private HibernateTemplate hibernate;

	public void setHibernate(HibernateTemplate hibernate) {
		this.hibernate = hibernate;
	}

	@SuppressWarnings("hiding")
	@Override
	public <User> void save(User t) {
		
	}

	@Override
	public void register(User user) {
		System.out.println("daoimpl.............");
		hibernate.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int usernameCheck(String userName) {
		List<Object> find = (List<Object>) hibernate.find("select count(*) from User where userName=?", userName);
		if (find!=null&&!find.isEmpty()) {
			return Integer.valueOf(find.get(0).toString());
		}
		return 0;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public User login(User user) {
		List<User> find = (List<User>) hibernate.find("from User where userName =? and userPassword=?",user.getUserName(),user.getUserPassword());
		
		if(find!=null&& find.size()>0){
		return find.get(0);
		}
		return null;
	}

	@Override
	public  cn.lwc.entity.User findUser(cn.lwc.entity.User user) {
		return null;
	}

	@Override
	public void update(cn.lwc.entity.User myUser) {
		 hibernate.update(myUser);
	}

	@Override
	public List<cn.lwc.entity.User> findAllUser() {
		return (List<cn.lwc.entity.User>) hibernate.find("from User");
	}

	
}
