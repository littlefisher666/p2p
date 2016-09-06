package dao.impl;


import dao.ProductTypeDao;
import entity.ProductType;

public class ProductTypeDaoImpl extends GenericDaoImpl<ProductType, Integer> implements ProductTypeDao {

	@Override
	public void updateProductTypeStatus(Integer productTypeId, String status) {
		String hql = new StringBuffer()
				.append(" update ProductType pt ")
				.append(" 	set pt.status = ? ") 
				.append(" 	where pt.productTypeId = ? ") 
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{status,productTypeId});
	}

	@Override
	public void updateProductType(Integer productTypeId, String productTypeName) {
		String hql = new StringBuffer()
				.append(" update ProductType pt ") 
				.append(" 	set pt.productTypeName = ? ") 
				.append(" 	where pt.productTypeId = ? ") 
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{productTypeName,productTypeId});
	}


}
