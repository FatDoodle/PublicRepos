package cn.lwc.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lwc.entity.Customer;
import cn.lwc.entity.Linkman;
import cn.lwc.entity.PageBean;
import cn.lwc.service.CustomerService;
import cn.lwc.service.LinkmanService;

@SuppressWarnings("serial")
@Controller
@Scope(value = "prototype")
@ParentPackage("crm")
@Namespace("/")
@Results({ @Result(location = "/jsp/addLinkman.jsp", name = "addLinkman"),
		@Result(location = "/linkList.jsp", name = "linkList"), @Result(location = "/jsp/editLkm.jsp", name = "editLkm")

})
public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {

	private Linkman linkman = new Linkman();

	@Override
	public Linkman getModel() {
		// TODO Auto-generated method stub
		return linkman;
	}

	@Autowired
	private CustomerService custService;

	private List<Customer> customerList;

	public List<Customer> getCustomerList() {
		return customerList;
	}

	/**
	 * 当想跳转addLkm.jsp时可以调用这个方法，里面封装了进入addLkm.jsp的所有准备工作
	 * 
	 * @return
	 */
	@Action("addLkmPrepare")
	public String LkmPrepare() {
		customerList = custService.findCustList();
		return "addLinkman";
	}

	@Autowired
	private LinkmanService lkmService;

	@SuppressWarnings("unused")
	@Action("addLkm")
	public String addLkm() {
		int count = lkmService.addLkm(linkman);
		lkmList();
		return "linkList";
	}

	

	public PageBean<Linkman> pageBean;
	public PageBean<Linkman> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<Linkman> pageBean) {
		this.pageBean = pageBean;
	}

	/**
	 * 当想跳入默认的linkList.jsp时可以调用这个方法，里面封装了进入linkList.jsp的所有准备工作
	 * 
	 * @return
	 */
	@Action("lkmList")
	public String lkmList() {
		LkmPrepare();
		if(pageBean==null){
			pageBean=new PageBean<>();
		}
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		lkmService.lkmList(criteria,pageBean);
		return "linkList";
	}

	@Action("queryLkmByCondition")
	public String queryLkmByCondition() {
		if(pageBean==null){
			pageBean=new PageBean<>();
		}
		LkmPrepare();
		DetachedCriteria criteria = DetachedCriteria.forClass(Linkman.class);
		if (linkman.getLkmName() != null && !StringUtils.isBlank(linkman.getLkmName())) {
			criteria.add(Restrictions.like("lkmName", "%"+linkman.getLkmName()+"%"));
		}
		if (linkman.getLkmGender() != null && !StringUtils.isBlank(linkman.getLkmGender())) {
			criteria.add(Restrictions.eq("lkmGender", linkman.getLkmGender()));
		}
		if (linkman.getCustomer() != null && linkman.getCustomer().getCustId() != 0) {
			criteria.add(Restrictions.eq("customer.custId", linkman.getCustomer().getCustId()));
		}
		lkmService.lkmList(criteria,pageBean);
		return "linkList";
	}

	@Action("editLkmPerpare")
	public String editLkmPerpare() {
		Linkman editLkm = lkmService.findLkmByObject(linkman);
		ActionContext.getContext().getValueStack().set("editLkm", editLkm);
		LkmPrepare();
		return "editLkm";
	}

	@Action("editLkm")
	public String editLkm() {
		lkmService.editLkm(linkman);
		lkmList();
		return "linkList";
	}

	@Action("deleteLkm")
	public String deleteLkm() {
		lkmService.deleteLkm(linkman);
		lkmList();
		return "linkList";
	}
}
