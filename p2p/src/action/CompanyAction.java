package action;

import java.util.List;

import service.CompanyService;
import service.SysuserService;
import entity.Company;
import entity.Product;
import entity.Report;
import entity.ReportDetail;

/**
 * 银行Action对象
 * @author 靳雅楠
 *
 */
public class CompanyAction extends BaseAction{

	private CompanyService companyService;
	private Integer applyId;
	private Product product;
	private Integer productId;
	private Integer companyId;
	private List<ReportDetail> reportDetails;
	private List<Report> reports;
	private Integer year;
	private Company company;
	private List<Company> companies;
	
	/*
	 * GET/SET 方法
	 */

	
	
	
	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public List<ReportDetail> getReportDetails() {
		return reportDetails;
	}

	public void setReportDetails(List<ReportDetail> reportDetails) {
		this.reportDetails = reportDetails;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	
	/*
	 * Action业务方法
	 */
	public String passApply() throws Exception {
		companyService.passApply(applyId);
		return SUCCESS;
	}
	
	public String refuseApply() throws Exception {
		companyService.refuseApply(applyId);
		return SUCCESS;
	}
	
	public String addProduct() throws Exception {
		companyService.addProduct(product);
		return SUCCESS;
	}
	
	public String delProduct() throws Exception {
		companyService.delProduct(productId);
		return SUCCESS;
	}
	
	public String qryCompanyReportDetailByCompanyId() throws Exception {
		reportDetails = companyService.qryCompanyReportDetailByCompanyId(companyId);
		return SUCCESS;
	}
	
	public String qryCompanyReportAll() throws Exception {
		reports = companyService.qryCompanyReportAll();
		return SUCCESS;
	}
	
	public String qryCompanyReportByYear() throws Exception {
		System.out.println("CompanyAction qryCompanyReportByYear year:"+year);
		reports = companyService.qryCompanyReportByYear(year);
		return SUCCESS;
	}
	
	public String companyAdd() throws Exception {
		companyService.registCompany(company);
		return SUCCESS;
	}
	
	public String companyModify() throws Exception {
		companyService.modifyCompany(company);
		return SUCCESS;
	}
	
	public String companyDetail() throws Exception {
		company = companyService.companyDetail(companyId);
		return SUCCESS;
	}
	
	public String companyManage() throws Exception {
		companies = companyService.companyManage();
		return SUCCESS;
	}
	
	public String companyReport() throws Exception {
		reports = companyService.companyReport();
		return SUCCESS;
	}
	
	public String ToCompanyModify() throws Exception {
		company = companyService.companyDetail(companyId);
		return SUCCESS;
	}
	
}









