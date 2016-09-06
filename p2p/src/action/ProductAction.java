package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import entity.Company;
import entity.LendingPeriod;
import entity.Product;
import entity.ProductType;

import service.LendingPeriodService;
import service.ProductService;
import service.ProductTypeService;
import service.SysuserService;
import util.JSONUtil;

/**
 * 产品Action对象
 * @author 靳雅楠
 *
 */
public class ProductAction extends BaseAction{
	
	private ProductService productService;
	private SysuserService sysuserService;
	private ProductTypeService productTypeService;
	private LendingPeriodService lendingPeriodService;
	private List<LendingPeriod> lendingPeriods;
	private List<ProductType> productTypes;
	private List<Product> products;
	private List<Company> companies;
	private Integer productTypeId;
	private Integer lendingPeriodId;
	private Double primeLendingRateFrom;
	private Double primeLendingRateTo;
	private Integer financingAmountFrom;
	private Integer financingAmountTo;
	private Product product;
	private Integer productId;
	private String userName;
	private Integer pageSum;
	
	
	

	/*
	 * Action业务方法
	 */
	public String qryProductAll() throws Exception {
		products = productService.qryProductAll();
		return SUCCESS;
	}
	
	public String qryProductByLendingPeriod() throws Exception {
		products = productService.qryProductByLendingPeriod(lendingPeriodId);
		return SUCCESS;
	}
	
	public String qryProductByPrimeLendingRate() throws Exception {
		products = productService.qryProductByPrimeLendingRate(primeLendingRateFrom, primeLendingRateTo);
		return SUCCESS;
	}
	
	public String qryProductByFinancingAmount() throws Exception {
		products = productService.qryProductByFinancingAmount(financingAmountFrom, financingAmountTo);
		return SUCCESS;
	}
	
	public String qryProductById() throws Exception {
		product = productService.qryProductById(productId);
		return SUCCESS;
	}
	
	public String index() throws Exception {
		products = productService.index();
		pageSum = products.size()/10+1;
		List<Product> ops = products;
		List<Product> nps = new ArrayList<Product>();
		if(ops.size() > 10) {
			for (int i = 0; i < 10; i++) {
				nps.add(ops.get(i));
			}
			products = nps;
		} else {
			products = ops;
		}
		System.out.println("ProductAction index pageSum:"+pageSum);
		return SUCCESS;
		
		
	}
	
	public String productIndex() throws Exception {
		product = productService.productIndex(productId);
		return SUCCESS;
	}
	
	public String productManager() throws Exception {
		products = productService.productManager(userName);
		return SUCCESS;
	}
	
	public String onlineApply() throws Exception {
		products = productService.onlineApply();
		return SUCCESS;
	}
	
	public String addProduct() throws Exception {
		product.setCreateTime(new Date());
		productService.addProduct(product);
		return SUCCESS;
	}
	
	public String productDetail() throws Exception {
		product = productService.productDetail(productId);
		return SUCCESS;
	}
	
	public String productModify() throws Exception {
		productService.productModify(product);
		return SUCCESS;
	}
	
	public String productAdd() throws Exception {
		companies = sysuserService.qryCompanyAll();
		productTypes = productTypeService.qryProductTypeAll();
		lendingPeriods = lendingPeriodService.qryLendingPeriodAll();
		return SUCCESS;
	}
	
	public String toProductModify() throws Exception {
		product = productService.qryProductById(productId);
		companies = sysuserService.qryCompanyAll();
		productTypes = productTypeService.qryProductTypeAll();
		lendingPeriods = lendingPeriodService.qryLendingPeriodAll();
		return SUCCESS;
	}
	
	/*
	 * GET/SET方法
	 */
	
	
	

	public Integer getPageSum() {
		return pageSum;
	}

	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	
	public ProductService getProductService() {
		return productService;
	}

	public SysuserService getSysuserService() {
		return sysuserService;
	}

	public void setSysuserService(SysuserService sysuserService) {
		this.sysuserService = sysuserService;
	}

	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}

	public LendingPeriodService getLendingPeriodService() {
		return lendingPeriodService;
	}

	public void setLendingPeriodService(LendingPeriodService lendingPeriodService) {
		this.lendingPeriodService = lendingPeriodService;
	}

	public List<LendingPeriod> getLendingPeriods() {
		return lendingPeriods;
	}

	public void setLendingPeriods(List<LendingPeriod> lendingPeriods) {
		this.lendingPeriods = lendingPeriods;
	}

	public List<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Integer getLendingPeriodId() {
		return lendingPeriodId;
	}

	public void setLendingPeriodId(Integer lendingPeriodId) {
		this.lendingPeriodId = lendingPeriodId;
	}

	public Double getPrimeLendingRateFrom() {
		return primeLendingRateFrom;
	}

	public void setPrimeLendingRateFrom(Double primeLendingRateFrom) {
		this.primeLendingRateFrom = primeLendingRateFrom;
	}

	public Double getPrimeLendingRateTo() {
		return primeLendingRateTo;
	}

	public void setPrimeLendingRateTo(Double primeLendingRateTo) {
		this.primeLendingRateTo = primeLendingRateTo;
	}

	public Integer getFinancingAmountFrom() {
		return financingAmountFrom;
	}

	public void setFinancingAmountFrom(Integer financingAmountFrom) {
		this.financingAmountFrom = financingAmountFrom;
	}

	public Integer getFinancingAmountTo() {
		return financingAmountTo;
	}

	public void setFinancingAmountTo(Integer financingAmountTo) {
		this.financingAmountTo = financingAmountTo;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
}














