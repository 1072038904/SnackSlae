package com.util;

import java.util.List;

public class PageBean {
    //Result List
    @SuppressWarnings("rawtypes")
    private List list;
     
    public PageBean(Integer pageSize) {
		super();
		this.pageSize = pageSize;
	}

	//总行数
    private Long allRow;
    //总页数
    private Integer totalPage;
    //当前页
    private Integer currentPage;
    //每页条目数
    private Integer pageSize;
     
    //是否为第一页
    private Boolean firstPage;
    //是否为最后一页
    private Boolean lastPage;
    //是否有前一页
    private Boolean hasPreviousPage;
    //是否有后一页
    private Boolean hasNextPage;
     
    @SuppressWarnings("rawtypes")
    public List getList() {
        return list;
    }
    @SuppressWarnings("rawtypes")
    public void setList(List list) {
        this.list = list;
    }
    public PageBean() {
		super();
	}
	public Long getAllRow() {
        return allRow;
    }
    public void setAllRow(Long allRow) {
        this.allRow = allRow;
    }
    public Number getTotalPage() {
        return totalPage;
    }
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Boolean getFirstPage() {
        return firstPage;
    }
    public void setFirstPage(Boolean firstPage) {
        this.firstPage = firstPage;
    }
    public Boolean getLastPage() {
        return lastPage;
    }
    public void setLastPage(Boolean lastPage) {
        this.lastPage = lastPage;
    }
    public Boolean getHasPreviousPage() {
        return hasPreviousPage;
    }
    public void setHasPreviousPage(Boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }
    public Boolean getHasNextPage() {
        return hasNextPage;
    }
    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
     
    /**
     * 初始化结果页面信息
     */
    public void init(){
    	 this.totalPage = countTotalPage(pageSize, allRow);
    	isFirstPage();
        isLastPage();
        isHasPreviousPage();  
         isHasNextPage();
    }
     
    private void isFirstPage() {
    	firstPage=(currentPage != 1)?true:false;
    }
    private void isLastPage() {
    	lastPage=(currentPage != totalPage)?true:false;
    }
    private void isHasPreviousPage() {
    	hasPreviousPage=(currentPage != 1)?true:false;
    }
    private void isHasNextPage() {
    	hasNextPage=(currentPage != totalPage)?true:false;
    }
     
     
    /**
     * 计算总页数
     * @param pageSize 每页记录数
     * @param allRow 总记录数
     * @return 总页数
     */
    private Integer countTotalPage(Integer pageSize,Long allRow){
        Integer row = allRow.intValue();
        Integer totalPage = row.intValue() % pageSize == 0 ? row/pageSize : row/pageSize+1;
        return totalPage;
    }
     
    /**
     * 计算当前页起始记录
     * @param pageSize 每页记录数
     * @param currentPage 当前第几页
     * @return
     */
    public Integer countOffset(Integer pageSize,Integer currentPage){
        Integer offset = pageSize*(currentPage-1);
        return offset;
    }
     
}