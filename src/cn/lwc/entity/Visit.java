package cn.lwc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="visit")
public class Visit {
	/**
	 * visit_id 主键 visit_cust_id 客户id visit_lkm_id 联系人id visit_user_id 用户id
	 * visit_date 时间 visit_address 地点 visit_detail 细节
	 * 
	 */
	@Id
	@Column(name = "visit_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int visitId;

	@Column(name = "visit_date")
	private String visitDate;

	@Column(name = "visit_address")
	private String visitAddress;

	@Column(name = "visit_detail")
	private String visitDetail;

	@ManyToOne(targetEntity = Linkman.class)
	@JoinColumn(name = "visit_lkm_id", referencedColumnName = "lkm_id")
	private Linkman visitLkm;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "visit_user_id", referencedColumnName = "user_id")
	private User visitUser;

	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "visit_cust_id", referencedColumnName = "cust_id")
	private Customer visitCust;

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public String getVisitAddress() {
		return visitAddress;
	}

	public void setVisitAddress(String visitAddress) {
		this.visitAddress = visitAddress;
	}

	public String getVisitDetail() {
		return visitDetail;
	}

	public void setVisitDetail(String visitDetail) {
		this.visitDetail = visitDetail;
	}

	public Linkman getVisitLkm() {
		return visitLkm;
	}

	public void setVisitLkm(Linkman visitLkm) {
		this.visitLkm = visitLkm;
	}

	public User getVisitUser() {
		return visitUser;
	}

	public void setVisitUser(User visitUser) {
		this.visitUser = visitUser;
	}

	public Customer getVisitCust() {
		return visitCust;
	}

	public void setVisitCust(Customer visitCust) {
		this.visitCust = visitCust;
	}

	
	
}
