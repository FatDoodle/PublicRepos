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
import cn.lwc.service.BaseDictService;
import cn.lwc.service.CustomerService;
import cn.lwc.entity.BaseDict;


@SuppressWarnings("serial")
@Controller
@Scope("prototype")
@ParentPackage("crm")
@Namespace("/")
@Results({
	@Result(location="/jsp/addCust.jsp",name="addCustPrepare"),
	@Result(location="/custList.jsp",name="custList"),
	@Result(location="/jsp/editCust.jsp",name="editCust"),
//	@Result(location="/jsp/error.jsp",name="input")
	@Result(location="/jsp/login.jsp",name="none")
})
public class CustAction extends ActionSupport implements ModelDriven<Customer> {
	

	private Customer customer=new Customer();
	
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	

	
	
	
	private List<BaseDict> baseDictSourceList;
	private List<BaseDict> baseDictIndustryList;
	private List<BaseDict> baseDictLevelList;

	@Autowired
	private BaseDictService bds;
	
	/**
	 * 这个方法用来做添加客户的前置准备工作，从数据库读取字典表的数据，返回前端的表单中的select项
	 * @return
	 */
	@Action("addCustPrepare")
	public String addCustPrepare() {
		baseDictSourceList=bds.findBaseDictByTypeCode("001");
		baseDictIndustryList=bds.findBaseDictByTypeCode("002");
		baseDictLevelList=bds.findBaseDictByTypeCode("003");

		return "addCustPrepare";
	}

	public List<BaseDict> getBaseDictSourceList() {
		return baseDictSourceList;
	}

	public List<BaseDict> getBaseDictIndustryList() {
		return baseDictIndustryList;
	}

	public List<BaseDict> getBaseDictLevelList() {
		return baseDictLevelList;
	}


	
	
	
	@Autowired
	private CustomerService custService;
	/**
	 * 这个方法用来添加客户
	 */
	@Action("addCustomer")
	public String addCust(){
		custService.saveCust(customer);
		return custList();
	}
	
	
	
	
	
	
	
	
	
	private List<Customer> customerList;
	
	public List<Customer> getCustomerList() {
		return customerList;
	}
	
	@Action("custList")
	public String custList(){
		baseDictSourceList=bds.findBaseDictByTypeCode("001");
		baseDictIndustryList=bds.findBaseDictByTypeCode("002");
		baseDictLevelList=bds.findBaseDictByTypeCode("003");
		customerList = custService.findCustList();
		return "custList";
		
	}
	
	
	/**
	 * 
	 * 触发：当点击custList.jsp里的“删除”时跳转这里
	 * 输入：前端传来参数custId，已经封装到了模型驱动的对象customer里
	 * 逻辑：在数据库删除customer对应的记录
	 * 输出："custList"
	 * 跳转：请求转发到custList.jsp
	 * @return
	 */
	@Action("deleteCust")
	public String deleteCust(){
		custService.deleteByObject(customer);
		baseDictSourceList=bds.findBaseDictByTypeCode("001");
		baseDictIndustryList=bds.findBaseDictByTypeCode("002");
		baseDictLevelList=bds.findBaseDictByTypeCode("003");
		customerList = custService.findCustList();
		return "custList";
	}

	/**
	 * 
	 * 触发：当点击custList.jsp里的“修改”时跳转这里
	 * 输入：前端传来参数custId，已经封装到了模型驱动的对象customer里
	 * 逻辑：通过customer在数据库查找记录，手动压入值栈返回前端；查找select内容通过属性驱动返回前端；
	 * 输出："editCust"
	 * 跳转：请求转发到editCust.jsp
	 * @return
	 */
	@Action("changeCust")
	public String changeCust(){
		baseDictSourceList=bds.findBaseDictByTypeCode("001");
		baseDictIndustryList=bds.findBaseDictByTypeCode("002");
		baseDictLevelList=bds.findBaseDictByTypeCode("003");
		
		Customer editCust=custService.findCustByObject(customer);
		ActionContext.getContext().getValueStack().set("editCust", editCust);
		return "editCust";		
	}
	
	
	/**
	 * 
	 * 触发：当点击editCust.jsp里的“提交”时跳转这里
	 * 输入：前端传来参数custId，已经封装到了模型驱动的对象customer里
	 * 逻辑：通过customer去数据库修改数据；最后跳转custList.jsp显示修改的成果，所以要到数据库查询所有记录；
	 * 输出："custList"
	 * 跳转：请求转发到custList.jsp
	 * @return
	 */
	
	
	@Action("editCustSub")
	public String changeCustSubmit(){
		custService.update(customer);
		baseDictSourceList=bds.findBaseDictByTypeCode("001");
		baseDictIndustryList=bds.findBaseDictByTypeCode("002");
		baseDictLevelList=bds.findBaseDictByTypeCode("003");
		customerList = custService.findCustList();
		return "custList";	
	}
	
	
	/**
	 * 
	 * 触发：当点击custlist.jsp里的“查询”时跳转这里
	 * 输入：无
	 * 逻辑：通过DetchedCriteria作为查询条件集去数据库查询数据；
	 * 		最后跳转custList.jsp显示修改的成果，所以要到数据库查询所有记录；
	 * 输出："custList"
	 * 跳转：请求转发到custList.jsp
	 * @return
	 */
	
	@Action("queryCondition")
	public String queryCondition(){
		DetachedCriteria criteria=DetachedCriteria.forClass(Customer.class);
		if(!StringUtils.isBlank(customer.getCustName())){
			criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		}
		if(customer.getBaseDictIndustry()!=null&&(customer.getBaseDictIndustry().getDictId())!=0){
			criteria.add(Restrictions.eq("baseDictIndustry.dictId", customer.getBaseDictIndustry().getDictId()));
		}
		if(customer.getBaseDictLevel()!=null&&(customer.getBaseDictLevel().getDictId())!=0){
			criteria.add(Restrictions.eq("baseDictLevel.dictId", customer.getBaseDictLevel().getDictId()));
		}
		if(customer.getBaseDictSource()!=null&&(customer.getBaseDictSource().getDictId())!=0){
			criteria.add(Restrictions.eq("baseDictSource.dictId", customer.getBaseDictSource().getDictId()));
		}
		customerList=custService.findByCondition(criteria);
		
		baseDictSourceList=bds.findBaseDictByTypeCode("001");
		baseDictIndustryList=bds.findBaseDictByTypeCode("002");
		baseDictLevelList=bds.findBaseDictByTypeCode("003");
		return "custList";	
	}
	
}
