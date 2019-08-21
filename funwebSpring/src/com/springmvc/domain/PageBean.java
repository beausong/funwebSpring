package com.springmvc.domain;

public class PageBean {
	//저장   count pageNum // pageCount pageBlock startPage endPage
	private int startRow; //시작하는 행번호 구한값
	private int pageSize; // 한화면에 보여줄 글개수 
	private int count;  //전체글개수
	private int pageNum; //현페이지번호
	private int pageCount; //전체 페이지수
	private int pageBlock; //한화면에 보여줄 페이지 수
	private int startPage; //시작페이지번호
	private int endPage; // 끝페이지번호
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		pageinit();
	}
	public void pageinit() {
		pageCount=count/pageSize+(count%pageSize==0?0:1);
		pageBlock=10;
		startPage=((pageNum-1)/pageBlock)*pageBlock+1;
		endPage=startPage+pageBlock-1;
		if(endPage > pageCount){
			endPage=pageCount;
		}
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	
}
