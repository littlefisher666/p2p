package dao;

import entity.ProductType;

/**
 * 产品类型数据访问对象
 * @author 靳雅楠
 *
 */
public interface ProductTypeDao extends GenericDao<ProductType, Integer>{
	
	/**
	 * 根据产品类型id修改该产品类型的状态
	 * @param productTypeId 产品类型id
	 * @param status 要修改成的状态
	 */
	public void updateProductTypeStatus(Integer productTypeId,String status);
	
	/**
	 * 根据产品类型id修改该产品的名字
	 * @param productTypeId 产品类型id 
	 * @param productTypeName 产品类型名字
	 */
	public void updateProductType(Integer productTypeId,String productTypeName);
}
