package com.daoimple;
import org.springframework.stereotype.Repository;

import com.dao.SnacksDao;
import com.daoimple.common.BaseDaoHibernate4;
import com.model.Snacks;
@Repository
public class SnacksDaoImple extends BaseDaoHibernate4<Snacks>implements SnacksDao{
	public SnacksDaoImple() {
	}

}
