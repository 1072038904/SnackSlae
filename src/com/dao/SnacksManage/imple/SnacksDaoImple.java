package com.dao.SnacksManage.imple;
import org.springframework.stereotype.Repository;

import com.dao.SnacksManage.SnacksDao;
import com.dao.common.imple.BaseDaoHibernate4;
import com.model.Snacks;
@Repository
public class SnacksDaoImple extends BaseDaoHibernate4<Snacks>implements SnacksDao{
	public SnacksDaoImple() {
	}

}
