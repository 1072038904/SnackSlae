package com.daoimple.SnacksManage;
import org.springframework.stereotype.Repository;

import com.dao.SnacksManage.SnacksDao;
import com.daoimple.common.BaseDaoHibernate4;
import com.model.Snacks;
@Repository
public class SnacksDaoImple extends BaseDaoHibernate4<Snacks>implements SnacksDao{
	public SnacksDaoImple() {
	}

}
