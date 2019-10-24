package cn.lwc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_base_dict")
public class BaseDict {

	@Id
	@Column(name="dict_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dictId;
	
	@Column(name="dict_type_code")
	private String dictTypeCode;
	
	@Column(name="dict_type_name")
	private String dictTypeName;
	
	@Column(name="dict_item_name")
	private String dictItemName;
	
	@Column(name="dict_item_code")
	private String dictItemCode;
	
	@Column(name="dict_memo")
	private String dictMemo;
	
	@Column(name="dict_enable")
	private char dictEnable;
	
	@Column(name="dict_sort")
	private int dictSort;

	

	public int getDictId() {
		return dictId;
	}



	public void setDictId(int dictId) {
		this.dictId = dictId;
	}



	public String getDictTypeCode() {
		return dictTypeCode;
	}



	public void setDictTypeCode(String dictTypeCode) {
		this.dictTypeCode = dictTypeCode;
	}



	public String getDictTypeName() {
		return dictTypeName;
	}



	public void setDictTypeName(String dictTypeName) {
		this.dictTypeName = dictTypeName;
	}



	public String getDictItemName() {
		return dictItemName;
	}



	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}



	public String getDictItemCode() {
		return dictItemCode;
	}



	public void setDictItemCode(String dictItemCode) {
		this.dictItemCode = dictItemCode;
	}



	public String getDictMemo() {
		return dictMemo;
	}



	public void setDictMemo(String dictMemo) {
		this.dictMemo = dictMemo;
	}



	public char getDictEnable() {
		return dictEnable;
	}



	public void setDictEnable(char dictEnable) {
		this.dictEnable = dictEnable;
	}



	public int getDictSort() {
		return dictSort;
	}



	public void setDictSort(int dictSort) {
		this.dictSort = dictSort;
	}



	@Override
	public String toString() {
		return "BaseDict [dictId=" + dictId + ", dictTypeCode=" + dictTypeCode + ", dictTypeName=" + dictTypeName
				+ ", dictItemName=" + dictItemName + ", dictItemCode=" + dictItemCode + ", dictMemo=" + dictMemo
				+ ", dictEnable=" + dictEnable + ", dictSort=" + dictSort + "]";
	}


	
	
	
	
	
}
