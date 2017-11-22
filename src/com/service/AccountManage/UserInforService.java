package com.service.AccountManage;

import com.model.Account;
import com.model.UserInfor;
import com.service.common.BaseService;

public interface UserInforService extends BaseService<UserInfor> {
	UserInfor findEnetityByAccount(Account account);
}
