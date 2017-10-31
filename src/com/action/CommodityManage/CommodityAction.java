package com.action.CommodityManage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.dao.CommodityManage.CommodityDao;
import com.model.Commodity;
import com.model.Snacks;
import com.service.CommodityService.CommodityService;
import com.service.SnacksManage.SnacksService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.PageBean;

@Controller
public class CommodityAction  {
	@Resource
private CommodityService commodityService;
	@Resource
private SnacksService snacksService;
private int page;
private File upload;// 上传的文件
private String uploadFileName;//上传的文件名陈
private String uploadContentType;// 接收文件上传的MIME类型
private Commodity commodity=new Commodity();
private String snacksName=new String();
private String commodityName=new String();
private  List<Commodity> commodities=new ArrayList<>();
private PageBean pageBean=new PageBean();
private Integer currentPage=new Integer(1);
private Integer pageSize;
private String keyName;
	public CommodityAction() {
		// TODO Auto-generated constructor stub
	}

	public CommodityService getCommodityService() {
		return commodityService;
	}


	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getSnacksName() {
		return snacksName;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}


	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public void setSnacksName(String snacksName) {
		this.snacksName = snacksName;
	}

	public File getUpload() {
		return upload;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public SnacksService getSnacksService() {
		return snacksService;
	}

	public void setSnacksService(SnacksService snacksService) {
		this.snacksService = snacksService;
	}

	public List<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<Commodity> commodities) {
		this.commodities = commodities;
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

	public String saveNewCommodity(){
		Snacks snacks=new Snacks();
		snacks.setName(snacksName);
		if(snacksService==null)
		System.out.println(snacks.getName());
		commodity.setSnacks(snacksService.findSnacks(snacks));
		  
	        if (upload != null) {
	            // 获得文件上传的磁盘绝对路径
	            try {
	                String realPath ="D:/C语言/java_workpace/SnackSale/WebContent/img";
	                // 创建一个文件
	                File diskFile = new File(realPath + "//"
	                        + uploadFileName);
	                // 文件上传,使用FileUtils工具类
	                FileUtils.copyFile(upload, diskFile);
	                commodity.setPicturePath("img/"+uploadFileName);
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
			commodityService.saveNewCommodity(commodity);
			return "success";
	}
	public String findCommodity(){
		if(commodityService.findCommodity(commodity)!=null){
			commodity=commodityService.findCommodity(commodity);
			return "success";
		}
		return "none";
		
	}
	public String findCommodityPage(){
			pageBean=commodityService.findEntityByPage(commodity.getName(), Commodity.class, currentPage, 10);
			return "success";	
	}
	//带分页的查询商品的执行方法  
	public String findAll(){  	
			//pageBean=commodityService.findCommodityByPage(currentPage,10);
		pageBean=commodityService.findEntityByPage(Commodity.class, currentPage, 10);
	    return "success";     
	}  
	public String deleteCommodity(){
		
		//commodityService.deleCommodity(commodity);
		commodityService.deleteEntity(commodity);
		return "success";
		
	}
	public String updateCommodity(){
		commodityService.updateEntity(commodity);
		//commodityService.updateCommodity(commodity);
		return "success";
		
	}
}
