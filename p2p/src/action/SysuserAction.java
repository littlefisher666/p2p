package action;

import java.util.List;

import entity.Apply;
import entity.Company;
import entity.Product;
import entity.Sysuser;
import service.SysuserService;

/**
 * 管理员Action的对象
 * @author 靳雅楠
 *
 */
public class SysuserAction extends BaseAction{

	private SysuserService sysuserService;
	private Sysuser sysuser;
	private List<Product> products;
	private List<Apply> applies;
	private List<Company> companies;
	private Integer productId;
	private Integer companyId;
	private Integer newsId;
	private String status;
	private Integer productTypeId;
	
	/*
	 * GET/SET方法
	 */
	
	public SysuserService getSysuserService() {
		return sysuserService;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public void setSysuserService(SysuserService sysuserService) {
		this.sysuserService = sysuserService;
	}

	public Sysuser getSysuser() {
		return sysuser;
	}

	public void setSysuser(Sysuser sysuser) {
		this.sysuser = sysuser;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Apply> getApplies() {
		return applies;
	}

	public void setApplies(List<Apply> applies) {
		this.applies = applies;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/*
	 * Action业务方法
	 */
	public String modSysuserPassword() throws Exception {
		sysuserService.modSysuserPassword(sysuser);
		return SUCCESS;
	}
	
	public String login() throws Exception {
		sysuser = sysuserService.login(sysuser);
		session.put("sysuser", sysuser);
		return SUCCESS;
	}
	public String logout() throws Exception {
		session.remove("sysuser");
		return SUCCESS;
	}
	
	public String qryProductAll() throws Exception {
		products = sysuserService.qryProductAll();
		return SUCCESS;
	}
	
	public String qryApplyAll() throws Exception {
		applies = sysuserService.qryApplyAll();
		return SUCCESS;
	}
	
	public String qryCompanyAll() throws Exception {
		companies = sysuserService.qryCompanyAll();
		return SUCCESS;
	}
	
	public String delProductByProductId() throws Exception {
		sysuserService.delProductByProductId(productId);
		return SUCCESS;
	}
	
	public String delCompanyByCompanyId() throws Exception {
		sysuserService.delCompanyByCompanyId(companyId);
		return SUCCESS;
	}
	
	public String passCompany() throws Exception {
		sysuserService.passCompany(companyId);
		return SUCCESS;
	}
	
	public String refuseCompany() throws Exception {
		sysuserService.refuseCompany(companyId);
		return SUCCESS;
	}
	
	public String delNewsByNewsId() throws Exception {
		System.out.println("SysuserAction delNewsByNewsId newsId:"+newsId);
		sysuserService.delNewsByNewsId(newsId);
		return SUCCESS;
	}
	
	public String updateProductTypeStatus() throws Exception {
		System.out.println("SysuserAction updateProductTypeStatus productTypeId:"+productTypeId);
		System.out.println("SysuserAction updateProductTypeStatus status:"+status); 
		sysuserService.updateProductTypeStatus(productTypeId, status);
		return SUCCESS;
	}
	
}


