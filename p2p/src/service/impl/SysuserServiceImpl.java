package service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ApplyDao;
import dao.CompanyDao;
import dao.NewsDao;
import dao.ProductDao;
import dao.ProductTypeDao;
import dao.SysuserDao;

import entity.Apply;
import entity.Company;
import entity.News;
import entity.Product;
import entity.Sysuser;
import exception.FaultNameOrPasswordException;
import exception.IdNotFoundException;
import service.SysuserService;

@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class SysuserServiceImpl implements SysuserService{

	private CompanyDao cd;
	private ProductDao pd;
	private ApplyDao ad;
	private SysuserDao sd;
	private NewsDao nd;
	private ProductTypeDao ptd;
	
	
	
	public ProductTypeDao getPtd() {
		return ptd;
	}

	public void setPtd(ProductTypeDao ptd) {
		this.ptd = ptd;
	}

	public NewsDao getNd() {
		return nd;
	}

	public void setNd(NewsDao nd) {
		this.nd = nd;
	}

	public SysuserDao getSd() {
		return sd;
	}

	public void setSd(SysuserDao sd) {
		this.sd = sd;
	}

	public CompanyDao getCd() {
		return cd;
	}

	public void setCd(CompanyDao cd) {
		this.cd = cd;
	}

	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	public ApplyDao getAd() {
		return ad;
	}

	public void setAd(ApplyDao ad) {
		this.ad = ad;
	}


	@Override
	public void delCompanyByCompanyId(Integer companyId)
			throws IdNotFoundException {
		
		cd.updateCompanyStatus(companyId, Company.STATUS_DELETED);
	}

	@Override
	public void delProductByProductId(Integer productId)
			throws IdNotFoundException {
		pd.updateProductStatus(productId, Product.STATUS_DELETED);
	}

	@Override
	public Sysuser login(Sysuser sysuser) throws FaultNameOrPasswordException {
		Sysuser su = sd.selectBySysuser(sysuser);
		
		if(su == null) {
			throw new FaultNameOrPasswordException("用户名或密码错误");
		}
		
		return su;
	}

	@Override
	public List<Apply> qryApplyAll() {
		return ad.selectAll();
	}

	@Override
	public List<Company> qryCompanyAll() {
		return cd.selectAll();
	}

	@Override
	public List<Product> qryProductAll() {
		return pd.selectAll();
	}

	@Override
	public void modSysuserPassword(Sysuser sysuser)  {
		sd.updateSysuser(sysuser);
	}

	@Override
	public void passCompany(Integer companyId) {
		cd.updateCompanyStatus(companyId, Company.STATUS_PASS);
	}

	@Override
	public void refuseCompany(Integer companyId) throws IdNotFoundException {
		cd.updateCompanyStatus(companyId, Company.STATUS_REFUSE);
	}

	@Override
	public void delNewsByNewsId(Integer newsId) throws IdNotFoundException {
		nd.updateNewsStatus(newsId, News.STATUS_DELETED);
	}

	@Override
	public void updateProductTypeStatus(Integer productTypeId, String status)
			throws IdNotFoundException {
		
		ptd.updateProductTypeStatus(productTypeId, status);
	}

	


}
