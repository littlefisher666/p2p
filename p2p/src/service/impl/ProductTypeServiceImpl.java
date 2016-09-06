package service.impl;

import java.util.List;

import dao.ProductTypeDao;

import entity.ProductType;
import service.ProductTypeService;
/**
 * 产品类型服务对象的实现
 * @author 靳雅楠
 *
 */
public class ProductTypeServiceImpl implements ProductTypeService {

	private ProductTypeDao ptd;
	
	public ProductTypeDao getPtd() {
		return ptd;
	}

	public void setPtd(ProductTypeDao ptd) {
		this.ptd = ptd;
	}

	@Override
	public void addProductType(ProductType productType) {
		ptd.insert(productType);
	}

	@Override
	public List<ProductType> productTypeManage() {
		return ptd.selectAll();
	}

	@Override
	public void productTypeModify(ProductType productType) {
		ptd.updateProductType(productType.getProductTypeId(), productType.getProductTypeName());
	}

	@Override
	public List<ProductType> qryProductTypeAll() {
		return productTypeManage();
	}


}
