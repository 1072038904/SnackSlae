package com.action.CommodityManage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.GeneratedValue;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.internal.compiler.ast.Literal;
import org.springframework.stereotype.Controller;

import com.action.common.BaseAction;
import com.model.Commodity;
import com.model.Snacks;
import com.service.CommodityService.CommodityService;
import com.service.SnacksManage.SnacksService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.CommodityClassification;
import com.util.PageBean;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import sun.security.action.PutAllAction;

@Controller
public class CommodityAction  extends BaseAction{
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
private List <CommodityClassification>commodityClassifications=new ArrayList<>();
private Integer pageSize;
private String keyName;
private String secClass;
private String methodPack;
	public CommodityAction() {
		// TODO Auto-generated constructor stub
	}

	public CommodityService getCommodityService() {
		return commodityService;
	}



	public String getMethodPack() {
		return methodPack;
	}

	public void setMethodPack(String methodPack) {
		this.methodPack = methodPack;
	}

	public String getSecClass() {
		return secClass;
	}

	public void setSecClass(String secClass) {
		this.secClass = secClass;
	}

	public String getKeyName() {
		return keyName;
	}



	public List<CommodityClassification> getCommodityClassifications() {
		return commodityClassifications;
	}

	public void setCommodityClassifications(List<CommodityClassification> commodityClassifications) {
		this.commodityClassifications = commodityClassifications;
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
		//System.out.println(snacksName);
		snacks.setName(snacksName);
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
	       // System.out.println(commodity.getName());
			commodityService.saveNewEntity(commodity);
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
			pageBean=commodityService.findEntityPageByName(commodity.getName(), Commodity.class, currentPage, 10);
			return "success";	
	}
	//带分页的查询商品的执行方法  
	public String findAll(){
		pageBean=commodityService.findEntityByPage(Commodity.class, currentPage, 10);
	    return "success";     
	} 
	//用户商品页用 4个每页显示
	public String findAllUser(){  	
		createNavigation();
	pageBean=commodityService.findEntityByPage(Commodity.class, currentPage, 4);
	session.put("goods", pageBean);
    return "success";     
}
	public void createNavigation(){
		List <Snacks>list=snacksService.findAllEntity(Snacks.class);
		Set <String>tempPri=new HashSet<>();
		for(int i=0;i<list.size();i++){
			tempPri.add(list.get(i).getPriClassification());
		}
		Iterator<String> it = tempPri.iterator();
		while (it.hasNext()) {  
			  String str = it.next();  
			  CommodityClassification commodityClassification=new CommodityClassification();
			  commodityClassification.setPri(str);
			  commodityClassifications.add(commodityClassification);
			} 
		//得到了一级分类的链表 只要是一级分类的二级分类就存到这个一级分类的对象中
		for(int i = 0;i<list.size();i++){
			for(int j =0;j<commodityClassifications.size();j++){
				if(commodityClassifications.get(j).getPri().equals(list.get(i).getPriClassification()))
					commodityClassifications.get(j).getSec().add(list.get(i).getSecClassification());				
			}
		}
		for(int i=0;i<commodityClassifications.size();i++){
			commodityClassifications.get(i).trans();
		}
		session.put("a",commodityClassifications);
	}
	
	public String findAllUserBySec(){
		createNavigation();
	pageBean=commodityService.findCommodityByPageSecCategory(secClass, Commodity.class, currentPage, 10);
    return "success";     
}
	public String findAllUserByPackMethod(){
		//System.out.println("执行了此方法");
		//System.out.println(secClass);
		createNavigation();
		pageBean=commodityService.findCommodityByPagePackMethod(methodPack, Commodity.class, currentPage, 10);
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
