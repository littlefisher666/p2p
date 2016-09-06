package action;

import java.util.List;

import entity.ProductType;
import service.ProductTypeService;

/**
 * 产品类型Action对象
 * @author 靳雅楠
 *
 */
public class ProductTypeAction extends BaseAction {

	private ProductTypeService productTypeService;
	private List<ProductType> productTypes;
	private ProductType productType;
	
	/*
	 * GET/SET方法
	 */
	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	public List<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	/*
	 * Action业务方法
	 */
	public String productTypeManage() throws Exception {
		productTypes = productTypeService.productTypeManage();
		return SUCCESS;
	}
	
	public String productTypeModify() throws Exception {
		System.out.println("ProductTypeAction productTypeModify productType.productTypeId:"+productType.getProductTypeId());
		System.out.println("ProductTypeAction productTypeModify productType.productTypeName:"+productType.getProductTypeName());
		productTypeService.productTypeModify(productType);
		return SUCCESS;
	}
	
	public String addProductType() throws Exception {
		productTypeService.addProductType(productType);
		return SUCCESS;
	}
	
}
