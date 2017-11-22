package com.service.ShoppingCart.imple;

import java.text.Normalizer.Form;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dao.ShoppingCartDao;
import com.model.Commodity;
import com.model.ShoppingCart;
import com.service.ShoppingCart.ShoppingCartService;
import com.service.common.imple.BaseServiceImple;
import com.util.GeneratedHql;
import com.util.PageBean;
@Service
@Transactional
public class ShoppingCartServiceImple extends BaseServiceImple<ShoppingCart>implements ShoppingCartService {

private ShoppingCartDao shoppingCartDao;
	public ShoppingCartServiceImple() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}
@Resource
	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		super.setBaseDao(shoppingCartDao);
		this.shoppingCartDao = shoppingCartDao;
	}

@Override
public ShoppingCart findShopingCartByAccountAndCommodity(ShoppingCart shoppingCart) {
	// TODO Auto-generated method stub
	List<ShoppingCart> ple=shoppingCartDao.find("from ShoppingCart as a where a.commodity.id='"+shoppingCart.getCommodity().getId()+"'"
			+ "and a.account.id='"+shoppingCart.getAccount().getId()+"'");
	for(Object ele:ple){
		ShoppingCart p=(ShoppingCart)ele;
		return p;
	}
	return null;
}


@Override
public PageBean findShopingCartByPageAccount(String account, Class<ShoppingCart> entityClazz, Integer currentPage,Integer pageSize) {
	// TODO Auto-generated method stub
	PageBean pageBean = new PageBean();
    //Set Parameters totalRows
    Long totalRows = shoppingCartDao.findCount(entityClazz);
    pageBean.setAllRow(totalRows);
    pageBean.setCurrentPage(currentPage.intValue());
    pageBean.setPageSize(pageSize.intValue()); 
    //Initialize PageBean
    pageBean.init();
    //get the resultSet
    List<ShoppingCart> resultList = shoppingCartDao.findByPage(GeneratedHql.genHql(entityClazz.getSimpleName()+" as s", "s.account.account",account), currentPage, pageSize);
    pageBean.setList(resultList);
    return pageBean;
}

}
