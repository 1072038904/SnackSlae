package com.action.SnacksManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.model.Snacks;
import com.service.SnacksManage.SnacksService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.FormatTestDataToArray;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

@Controller
public class SnacksAction {
@Resource
private SnacksService snacksService;
private String packMethod;
private Snacks snacks=new Snacks();
private List <Snacks>snacks2 =new ArrayList<>();
	public SnacksAction() {
		// TODO Auto-generated constructor stub
	}
	public SnacksService getSnacksService() {
		return snacksService;
	}
	public void setSnacksService(SnacksService snacksService) {
		this.snacksService = snacksService;
	}
	public Snacks getSnacks() {
		return snacks;
	}
	public void setSnacks(Snacks snacks) {
		this.snacks = snacks;
	}
	public void saveSnacksInfor(){
		snacksService.saveNewSnacks(snacks);
	}
	public String getPackMethod() {
		return packMethod;
	}
	public void setPackMethod(String packMethod) {
		this.packMethod = packMethod;
	} 
	public List<Snacks> getSnacks2() {
		return snacks2;
	}
	public void setSnacks2(List<Snacks> snacks2) {
		this.snacks2 = snacks2;
	}
	public String saveDemoData(){
		String string[]=new String[]{"夏威夷果-袋装,坚果炒货,夏威夷果,袋装,25"
				,"夏威夷果-散称,坚果炒货,夏威夷果,散称,5"
				,"松子-袋装,坚果炒货,松子,袋装,30"
				,"松子-散称,坚果炒货,松子,散称,6"
				,"开心果-袋装,坚果炒货,开心果,袋装,10"
				,"开心果-散称,坚果炒货,开心果,散称,2"
				,"腰果-袋装,坚果炒货,腰果,袋装,15"
				,"腰果-散称,坚果炒货,腰果,散称,2.5"
				,"松子-袋装,坚果炒货,松子,袋装,15"
				,"松子-散称,坚果炒货,松子,散称,20"
				,"花生-袋装,坚果炒货,花生,袋装,15"
				,"花生-散称,坚果炒货,花生,散称,2.5"
				,"牛肉干-袋装,肉类即食,牛肉干,袋装,30"
				,"牛肉干-散称,肉类即食,牛肉干,散称,40",
				"猪肉脯-袋装,肉类即食,猪肉脯,袋装,20",
				"猪肉脯-散称,肉类即食,猪肉脯,散称,30",
				"牛板筋-袋装,肉类即食,牛板筋,袋装,23.0",
				"牛板筋-散称,肉类即食,牛板筋,散称,4.6",
				"鸡肉-袋装,肉类即食,鸡肉,袋装,20.0",
				"鸡肉-散称,肉类即食,鸡肉,散称,4.0",
				"巧克力-袋装,进口食品,巧克力,袋装,50.0",
				"巧克力-散称,进口食品,巧克力,散称,10.0",
				"果冻-袋装,进口食品,果冻,袋装,35.0",
				"果冻-散称,进口食品,果冻,散称,7.0",
				"咖啡糖-袋装,进口食品,咖啡糖,袋装,25.0",
				"咖啡糖-散称,进口食品,咖啡糖,散称,5.0",
				"牛轧糖-袋装,进口食品,牛轧糖,袋装,28.0",
				"牛轧糖-散称,进口食品,牛轧糖,散称,5.6",
				"奶片-袋装,进口食品,奶片,袋装,29.0",
				"奶片-散称,进口食品,奶片,散称,5.8",
				"海苔-袋装,进口食品,海苔,袋装,30.0",
				"海苔-散称,进口食品,海苔,散称,6.0",
				"口香糖-袋装,进口食品,口香糖,袋装,32.0",
				"口香糖-散称,进口食品,口香糖,散称,6.4",
				"软糖-袋装,进口食品,软糖,袋装,33.0",
				"软糖-散称,进口食品,软糖,散称,6.6",
				"红枣-袋装,梅/果干,红枣,袋装,29.0",
				"红枣-散称,梅/果干,红枣,散称,5.8",
				"梅类-袋装,梅/果干,梅类,袋装,29.0",
				"梅类-散称,梅/果干,梅类,散称,5.8",
				"蜜饯-袋装,梅/果干,蜜饯,袋装,29.0",
				"蜜饯-散称,梅/果干,蜜饯,散称,5.8",
				"果脯-袋装,梅/果干,果脯,袋装,29.0",
				"果脯-散称,梅/果干,果脯,散称,5.8",
				"榴莲干-袋装,梅/果干,榴莲干,袋装,29.0",
				"榴莲干-散称,梅/果干,榴莲干,散称,5.8",
				"核桃仁-袋装,核桃,核桃仁,袋装,29.0",
				"核桃仁-散称,核桃,核桃仁,散称,5.8",
				"山核桃-袋装,核桃,山核桃,袋装,29.0",
				"山核桃-散称,核桃,山核桃,散称,5.8",
				"长寿果-袋装,核桃,长寿果,袋装,29.0",
				"长寿果-散称,核桃,长寿果,散称,5.8"};
		List<Snacks> list=new ArrayList<>();
		for(int i=0;i<string.length;i++)
		list.add(FormatTestDataToArray.getSnacksForm(string[i]));
		//snacksService.saveAllSnacks(list);
		for(int i=0;i<list.size();i++){
			snacksService.mergeNewSnacks(list.get(i));
		}
		return null;
		
	}
	/**
	 * 保存新的零食信息
	 * @return 
	 */
	public String saveNewSnacks(){
		System.out.println(snacks.getName()+snacks.getPackMethod()+snacks.getPrice()+snacks.getPriClassification());
		if(snacksService.isSnacksExisted(snacks)==1){
			snacksService.saveNewSnacks(snacks);
			return "success";
		}
		return "error";
	}
	
	public String findAllSnacks(){
		snacks2=snacksService.findAllSnacks();
		if(snacks2.isEmpty()!=true)
		return "success";
		return "error";
	}
}
