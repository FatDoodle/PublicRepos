package cn.lwc.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lwc.entity.Customer;
import cn.lwc.entity.Linkman;
import cn.lwc.entity.PageBean;
import cn.lwc.entity.User;
import cn.lwc.entity.Visit;
import cn.lwc.service.CustomerService;
import cn.lwc.service.LinkmanService;
import cn.lwc.service.UserService;
import cn.lwc.service.VisitService;
import cn.lwc.utils.JacksonUtils;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("crm")
@Namespace("/")
@Results({ 
	@Result(location = "/jsp/addVisit.jsp", name = "addVisit"),
	@Result(location = "/visitList.jsp", name = "visitList"),
	@Result(location = "/jsp/editVisit.jsp", name = "editVisit"),

})
public class VisitAction extends ActionSupport implements ModelDriven<Visit> {
	
	private Visit visit=new Visit();
	@Override
	public Visit getModel() {
		// TODO Auto-generated method stub
		return visit;
	}

	@Autowired
	private CustomerService custService;

	@Autowired
	private UserService userService;

	@Autowired
	private LinkmanService lkmService;

	@Action("addVisitPerpare")
	public String addVisitPerpare() {
		// 找到客户列表
		List<Customer> findCustList = custService.findCustList();
		// 找到用户列表
		List<User> userList = userService.findAllUser();
		// 压入值栈
		ActionContext.getContext().getValueStack().set("custList", findCustList);
		ActionContext.getContext().getValueStack().set("userList", userList);

		return "addVisit";
	}

	private int custId;

	public void setCustId(int custId) {
		this.custId = custId;
	}

	@Action("visitAction_getLkm")
	public String getLkmByCustId() {
		List<Linkman> lkmList = lkmService.findListByCustId(custId);

		String bean2Json = JacksonUtils.bean2Json(lkmList);
		ServletActionContext.getResponse().setHeader("content-type","text/html;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(bean2Json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}

	@Autowired
	private VisitService visitService;
	
	@Action("addAVisit")
	public String addVisit() {
		visitService.save(visit);
		visitList();
		return "visitList";
	}
	
	
	

	public PageBean<Visit> pageBean;
	public PageBean<Visit> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<Visit> pageBean) {
		this.pageBean = pageBean;
	}

	
	
	private String startTime;
	private String endTime;
	
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Action("visitList")
	public String visitList() {
		if (pageBean == null) {
			pageBean = new PageBean<>();
		}
		DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
		if(!StringUtils.isBlank(startTime)){
			criteria.add(Restrictions.ge("visitDate", startTime));
		}
		if(!StringUtils.isBlank(endTime)){
			criteria.add(Restrictions.le("visitDate", endTime));
		}
		visitService.visitList(criteria, pageBean);
		return "visitList";
	}
	
	
	@Action("editVisitPerpare")
	public String editVisitPerpare() {
		addVisitPerpare();
		Visit editVisit=visitService.findVisit(visit);
		ActionContext.getContext().getValueStack().set("editVisit", editVisit);
		return "editVisit";
	}
	
	@Action("editVisit")
	public String editVisit() {
		visitService.update(visit);
		visitList();
		return "visitList";
	}
	
	
	@Action("delVisit")
	public String delVisitPerpare() {
		visitService.delete(visit);
		visitList();
		return "visitList";
	}
}
