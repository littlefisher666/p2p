package service;

import java.util.List;

import entity.ProductType;

/**
 * 产品类型服务对象
 * @author 靳雅楠
 *
 */
public interface ProductTypeService {
	
	/**
	 * 产品类型管理页面的显示 
	 * @return 封装了产品类型信息的List集合，当产品类型不存在时，返回一个空的List集合
	 */
	public List<ProductType> productTypeManage();
	
	/**
	 * 修改产品类型
	 * @param productType 封装了产品类型信息的对象
	 */
	public void productTypeModify(ProductType productType);
	
	/**
	 * 添加一个产品类型
	 * @param productType 封装了产品类型信息的对象
	 */
	public void addProductType(ProductType productType);
	
	/**
	 * 查询所有的产品类型
	 * @return 封装了产品类型信息的List集合，当产品类型不存在时，返回一个空的List集合
	 */
	public List<ProductType> qryProductTypeAll();
}
