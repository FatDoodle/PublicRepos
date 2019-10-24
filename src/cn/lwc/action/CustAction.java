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
	 * ���������������ӿͻ���ǰ��׼�������������ݿ��ȡ�ֵ������ݣ�����ǰ�˵ı��е�select��
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
	 * �������������ӿͻ�
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
	 * �����������custList.jsp��ġ�ɾ����ʱ��ת����
	 * ���룺ǰ�˴�������custId���Ѿ���װ����ģ�������Ķ���customer��
	 * �߼��������ݿ�ɾ��customer��Ӧ�ļ�¼
	 * �����"custList"
	 * ��ת������ת����custList.jsp
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
	 * �����������custList.jsp��ġ��޸ġ�ʱ��ת����
	 * ���룺ǰ�˴�������custId���Ѿ���װ����ģ�������Ķ���customer��
	 * �߼���ͨ��customer�����ݿ���Ҽ�¼���ֶ�ѹ��ֵջ����ǰ�ˣ�����select����ͨ��������������ǰ�ˣ�
	 * �����"editCust"
	 * ��ת������ת����editCust.jsp
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
	 * �����������editCust.jsp��ġ��ύ��ʱ��ת����
	 * ���룺ǰ�˴�������custId���Ѿ���װ����ģ�������Ķ���customer��
	 * �߼���ͨ��customerȥ���ݿ��޸����ݣ������תcustList.jsp��ʾ�޸ĵĳɹ�������Ҫ�����ݿ��ѯ���м�¼��
	 * �����"custList"
	 * ��ת������ת����custList.jsp
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
	 * �����������custlist.jsp��ġ���ѯ��ʱ��ת����
	 * ���룺��
	 * �߼���ͨ��DetchedCriteria��Ϊ��ѯ������ȥ���ݿ��ѯ���ݣ�
	 * 		�����תcustList.jsp��ʾ�޸ĵĳɹ�������Ҫ�����ݿ��ѯ���м�¼��
	 * �����"custList"
	 * ��ת������ת����custList.jsp
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
