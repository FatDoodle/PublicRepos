package cn.lwc.entity;

import java.util.List;

import cn.lwc.utils.J2EEUtils;

public class PageBean<T> {
	private int currentPage=1;
	private int pageCount;
	
	private int recordCount;
	private int pageRecordCount=1;
	private int startIndex;
	
	//Ç°¶ËÍ¨¹ý
	private int pageStart;
	private int pageEnd;
	private int showPageCount=5;
	private List<T> data;

	
	
	public int getShowPageCount() {
		return showPageCount;
	}

	public void setShowPageCount(int showPageCount) {
		this.showPageCount = showPageCount;
	}

	public int getPageStart() {
		if(getPageCount()<getShowPageCount()){
			pageStart=1;
		}else if(getCurrentPage()<=showPageCount/2+1){
			pageStart=1;
		}else if(currentPage+(showPageCount/2)<pageCount+1){
			pageStart=currentPage-2;
		}else{
			pageStart=pageCount-showPageCount+1;
		}
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		if(getPageCount()<getShowPageCount()){
			pageEnd=showPageCount;
		}else if(getCurrentPage()<=showPageCount/2+1){
			pageEnd=showPageCount;
		}
		else if(currentPage+(showPageCount/2)<pageCount+1){
			pageEnd=currentPage+showPageCount/2;
		}else{
			pageEnd=pageCount;
		}
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		pageCount=J2EEUtils.intCeil(recordCount, pageRecordCount);
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageRecordCount() {
		return pageRecordCount;
	}

	public void setPageRecordCount(int pageRecordCount) {
		this.pageRecordCount = pageRecordCount;
	}

	public int getStartIndex() {
		startIndex=J2EEUtils.startIndex(currentPage, pageRecordCount);
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> list) {
		this.data = list;
	}

	
	
}
