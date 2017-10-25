package com.action.CommodityManage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.model.Commodity;
import com.model.Snacks;
import com.service.CommodityService.CommodityService;
import com.service.SnacksManage.SnacksService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.RETURN;

@Controller
public class CommodityAction {
	@Resource
private CommodityService commodityService;
	@Resource
private SnacksService snacksService;
private int page;//上传文件需要的参数
private File upload;// 上传的文件
private String uploadFileName;//上传的文件名陈
private String uploadContentType;// 接收文件上传的MIME类型
private Commodity commodity=new Commodity();
private String snacksName=new String();
private String commodityName=new String();
	public CommodityAction() {
		// TODO Auto-generated constructor stub
	}

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public int getPage() {
		return page;
	}

	public String getSnacksName() {
		return snacksName;
	}

	public void setSnacksName(String snacksName) {
		this.snacksName = snacksName;
	}

	public void setPage(int page) {
		this.page = page;
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

	public String saveNewCommodity(){
		Snacks snacks=new Snacks();
		snacks.setName(snacksName);
		if(snacksService==null)
		System.out.println(snacks.getName());
		snacksService.findSnacks(snacks);
		commodity.setSnacks(snacks);
		if(commodityService.isCommodityExisted(commodity)==1){     
	        if (upload != null) {
	            // 获得文件上传的磁盘绝对路径
	            try {
	                String realPath = ServletActionContext.getServletContext()
	                        .getRealPath("/images");
	                // 创建一个文件
	                File diskFile = new File(realPath + "//"
	                        + uploadFileName);
	                // 文件上传,使用FileUtils工具类
	                FileUtils.copyFile(upload, diskFile);
	                commodity.setPicturePath("/images"+uploadFileName);
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
			commodityService.saveNewCommodity(commodity);
			return "success";
		}
		else{
			return "existed";
		}
	}
	public String findCommodity(){
		if(commodityService.findCommodity(commodity)!=null){
			commodity=commodityService.findCommodity(commodity);
			return "success";
		}
		return "none";
		
	}
}
