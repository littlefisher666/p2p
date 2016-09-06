package service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ApplyDao;
import dao.CompanyDao;
import dao.ProductDao;
import entity.Apply;
import entity.Company;
import entity.Product;
import entity.Report;
import entity.ReportDetail;
import exception.IdNotFoundException;
import service.CompanyService;

/**
 * 银行的业务处理对象的实现
 * @author 靳雅楠
 *
 */
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class CompanyServiceImpl implements CompanyService{

	private ProductDao pd ;
	private ApplyDao ad;
	private CompanyDao cd;
	
	public CompanyDao getCd() {
		return cd;
	}

	public void setCd(CompanyDao cd) {
		this.cd = cd;
	}

	public ApplyDao getAd() {
		return ad;
	}

	public void setAd(ApplyDao ad) {
		this.ad = ad;
	}

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	@Override
	public void passApply(Integer applyId)
			throws IdNotFoundException {
		ad.updateApplyStatus(applyId, Apply.STATUS_PASS);
	}
	
	@Override
	public void refuseApply(Integer applyId) throws IdNotFoundException {
		ad.updateApplyStatus(applyId, Apply.STATUS_REFUSE);
	}

	@Override
	public void addProduct(Product product) {
		pd.insert(product);
		
	}

	@Override
	public void delProduct(Integer productId) throws IdNotFoundException {
		
		pd.updateProductStatus(productId, Product.STATUS_DELETED);
		
	}

	@Override
	public List<Report> qryCompanyReportAll() {
		return cd.selectCompanyReportAll();
	}

	@Override
	public List<Report> qryCompanyReportByYear(Integer year) {
		
		return cd.selectCompanyReportByYear(year);
	}

	@Override
	public List<ReportDetail> qryCompanyReportDetailByCompanyId(
			Integer companyId) throws IdNotFoundException {
		return cd.selectCompanyReportDetailByCompanyId(companyId);
	}

	@Override
	public Company companyDetail(Integer companyId) {
		return cd.selectById(companyId);
	}

	@Override
	public List<Company> companyManage() {
		return cd.selectAll();
	}

	@Override
	public List<Report> companyReport() {
		return cd.selectCompanyReportAll();
	}

	@Override
	public void modifyCompany(Company company) {
		cd.update(company);
	}

	@Override
	public void registCompany(Company company) {
		cd.insert(company);
	}


	

}
