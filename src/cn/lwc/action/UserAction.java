package cn.lwc.action;

import java.io.IOException;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lwc.entity.User;
import cn.lwc.service.UserService;

@SuppressWarnings("serial")
@Controller
@Scope(value="prototype")
@ParentPackage("crm")
@Namespace("/")
@Results({
	@Result(location="/jsp/success.jsp",name="success",type="redirect"),
	@Result(location="/index.jsp",name="loginSuccess",type="redirect"),
	@Result(location="/jsp/login.jsp",name="loginFailed"),
	@Result(location="/jsp/login.jsp",name="login",type="redirect"),

})
public class UserAction extends ActionSupport implements ModelDriven<User>{
	@Autowired
	private UserService service;
	
	private User user=new User();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	@Action("register")
	public String register(){
		service.register(user);

		return "success";
		
	}
	
	
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Action("registerCheck")
	public String registerCheck() throws IOException{
		userName=ServletActionContext.getRequest().getParameter("userName");
		int count=service.registerCheck(userName);
		ServletActionContext.getResponse().getWriter().print(count);
		System.out.println("这里action获得"+count);
		return NONE;
	}
	
	@Action("login")
	public String login() throws IOException{
		User loginUser=service.login(user);
		ServletActionContext.getRequest().getSession().setAttribute("user", loginUser);
		if(loginUser!=null){return "loginSuccess";}
		this.addFieldError("msg", "用户名或密码错误");
		return "loginFailed";
	}
	
	
	@Action("loginOut")
	public String loginOut() throws IOException{
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "login";
	}
	
	@SuppressWarnings("unused")
	@Action("changePwd")
	public String changeOut() throws IOException{
		int count=service.changePwd(user);
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		return "loginSuccess";
	}
}
