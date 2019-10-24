package cn.lwc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column(name="cust_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int custId;
	
	@Column(name="cust_name")
	private String custName;
	
	@Column(name="cust_phone")
	private String custPhone;
	
	@Column(name="cust_mobile")
	private String custMobile;
	
	
	@ManyToOne(targetEntity=BaseDict.class)
	@JoinColumn(name="cust_source",referencedColumnName="dict_id")
	private BaseDict baseDictSource;
	
	@ManyToOne(targetEntity=BaseDict.class)
	@JoinColumn(name="cust_industry",referencedColumnName="dict_id")
	private BaseDict baseDictIndustry;
	
	@ManyToOne(targetEntity=BaseDict.class)
	@JoinColumn(name="cust_level",referencedColumnName="dict_id")
	private BaseDict baseDictLevel;
	
	@OneToMany(targetEntity=Linkman.class,mappedBy="customer")
	private List<Linkman> linkmans=new ArrayList<Linkman>();
	
	@OneToMany(targetEntity=Visit.class,mappedBy="visitCust")
	private List<Visit> visit=new ArrayList<Visit>();

	public List<Visit> getVisit() {
		return visit;
	}




	public void setVisit(List<Visit> visit) {
		this.visit = visit;
	}




	public int getCustId() {
		return custId;
	}




	public void setCustId(int custId) {
		this.custId = custId;
	}




	public String getCustName() {
		return custName;
	}




	public void setCustName(String custName) {
		this.custName = custName;
	}




	public String getCustPhone() {
		return custPhone;
	}




	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}




	public String getCustMobile() {
		return custMobile;
	}




	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}




	public BaseDict getBaseDictSource() {
		return baseDictSource;
	}




	public void setBaseDictSource(BaseDict baseDictSource) {
		this.baseDictSource = baseDictSource;
	}




	public BaseDict getBaseDictIndustry() {
		return baseDictIndustry;
	}




	public void setBaseDictIndustry(BaseDict baseDictIndustry) {
		this.baseDictIndustry = baseDictIndustry;
	}




	public BaseDict getBaseDictLevel() {
		return baseDictLevel;
	}




	public void setBaseDictLevel(BaseDict baseDictLevel) {
		this.baseDictLevel = baseDictLevel;
	}




	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custPhone=" + custPhone + ", custMobile="
				+ custMobile + ", baseDictSource=" + baseDictSource + ", baseDictIndustry=" + baseDictIndustry
				+ ", baseDictLevel=" + baseDictLevel + "]";
	}

	
	
	
	
	
	
	
}
