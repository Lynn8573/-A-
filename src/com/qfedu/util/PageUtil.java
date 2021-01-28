package com.qfedu.util;

public class PageUtil {
	private int pageSize;//每页显示多少条 4
	private int pageCount;//一共多少页   5+1
	private int dataCount;//总数据数   21
	private int pageNo;//当前页码  1 2 3
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		if(dataCount%pageSize==0) {
			pageCount=dataCount/pageSize;
		}else {
			pageCount=dataCount/pageSize+1;
		}
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	
}
