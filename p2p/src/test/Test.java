package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import service.NewsService;
import service.ProductService;
import util.JSONUtil;

import action.NewsAction;
import action.ProductAction;

import dao.ApplyDao;
import dao.CompanyDao;
import dao.NewsDao;
import dao.ProductDao;
import entity.Apply;
import entity.Company;
import entity.LendingPeriod;
import entity.News;
import entity.Product;
import entity.ProductType;
import entity.Report;
import entity.ReportDetail;

public class Test {
	public static void main(String[] args) {
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext*.xml");
		
		ApplyDao ad = (ApplyDao) ac.getBean("applyDao"); 
		ProductDao pd = (ProductDao) ac.getBean("productDao");
		CompanyDao cd = (CompanyDao) ac.getBean("companyDao");
		
		List<Product> products = pd.selectAll();
		List<Apply> applies = ad.selectAll();
		List<Company> companies = cd.selectAll();
		
		System.out.println(products);
		System.out.println(applies);
		System.out.println(companies);
		
		NewsDao nd = (NewsDao) ac.getBean("newsDao");
		News news = nd.selectById(1);
		System.out.println(news.getNewsTitle());
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext*.xml");
		ProductDao pd = (ProductDao) ac.getBean("productDao");
		
		List<Product> products = pd.selectProduct(null, null, null, null, 1, null);*/
//		System.out.println(products);
		
		/*
		List<Product> products = pd.selectAll();
		
		
		ProductType pt = new ProductType();
		pt.setProductTypeId(1);
		pt.setProductTypeName("123");
		pt.setStatus("D");
		ProductType pt2 = pt;
		List<ProductType> pts = new ArrayList<ProductType>();
		pts.add(pt);
		pts.add(pt2);
		
		Product p = new Product();
		p.setProductId(1);
		Company c = new Company();
		c.setCompanyId(2);
		p.setCompany(c);
		LendingPeriod l = new LendingPeriod();
		l.setLendingPeriodId(2);
		p.setLendingPeriod(l);
		Set<Apply> applies = new TreeSet<Apply>();
		Apply a = new Apply();
		a.setApplyDate(new Date());
		a.setApplyId(2);
		applies.add(a);
		Apply a1 = a;
		applies.add(a1);
		p.setApplies(applies);
		Product p1 = p;
		List<Product> products = new ArrayList<Product>();
		products.add(p);
		products.add(p1);
		
		System.out.println(JSONUtil.productToJSON(products));*/
		/*
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext*.xml");
		CompanyDao cd = (CompanyDao) ac.getBean("companyDao");
		
		List<Report> reports = cd.selectCompanyReportByYear(2015);
		for (Report report : reports) {
			System.out.println("report companyName:"+report.getCompany().getCompanyName());
			System.out.println("report productNum:"+report.getProductNum());
			System.out.println("report financingActualTotal:"+report.getFinancingActualTotal());
			System.out.println("report financingTarget:"+report.getFinancingTarget());
			System.out.println("report financingInReturnNumTotal:"+report.getFinancingInReturnNumTotal());
		}
		List<ReportDetail> rds = cd.selectCompanyReportDetailByCompanyId(1);
		for (ReportDetail rd : rds) {
			System.out.println("reportDetail productName:"+rd.getProduct().getProductName());
			System.out.println("reportDetail createTime:"+rd.getProduct().getCreateTime());
			System.out.println("reportDetail financingAmountTo:"+rd.getProduct().getFinancingAmountTo());
			System.out.println("reportDetail financingActual:"+rd.getFinancingActual());
			System.out.println("reportDetail financingInReturnNum:"+rd.getFinancingInReturnNum());
		}
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext*.xml");
		ApplyDao ad = (ApplyDao) ac.getBean("applyDao");
		Apply a = new Apply();
		a.setApplyProductId(1);
		a.setApplyPerson("123");
		a.setApplyPersonIdcard("123123123");
		a.setApplyDate(new java.sql.Date(new Date().getTime()));
		ad.insertApply(a, 1);
		*/
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext*.xml");
		ProductDao pd = (ProductDao) ac.getBean("productDao");
		List<Product> products = pd.selectProduct(null, null, null, null, 1, null);
		
		for (Product p : products) {
			System.out.println("p.productId:"+p.getProductId());
			System.out.println("p.company.companyName:"+p.getCompany().getCompanyName());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
