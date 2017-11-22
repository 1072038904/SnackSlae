package com.service.AccountManage.imple;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountManage.RegisterDao;
import com.model.UserInfor;
import com.service.AccountManage.RegisterService;
@Service
@Transactional
public class RegisterServiceImple implements RegisterService{
@Autowired
private RegisterDao registerDao;
	public RegisterServiceImple() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public int isRegister(UserInfor userInfor) {
		// TODO �Զ����ɵķ������
	boolean judge=isExisted(userInfor);
	if(judge){return 2;}
	return 1;
}
	public void saveUserInfor(UserInfor userInfor){
		registerDao.save(userInfor);
	}
	@Override
	public boolean isExisted(UserInfor userInfor) {
		// TODO �Զ����ɵķ������
		List<UserInfor> pl =registerDao.find("from UserInfor where account='"+userInfor.getAccount().getAccount()+"'");
		if(pl.isEmpty()==true){
		return false;
		}
		else{
		for (Object ele : pl)
		{
			UserInfor p = (UserInfor)ele;
			if(userInfor.getAccount().getPassword().equals(p.getAccount().getPassword()))
			return true;
		}
		}
		return true;
	}

}
