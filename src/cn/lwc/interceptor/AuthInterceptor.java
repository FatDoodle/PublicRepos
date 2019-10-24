package cn.lwc.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AuthInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Object attribute = ServletActionContext.getRequest().getSession().getAttribute("user");
		if(attribute!=null){
			 return invocation.invoke();
		}
		return "login";
	}

}
