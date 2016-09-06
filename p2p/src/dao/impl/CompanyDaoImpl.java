package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import dao.CompanyDao;
import entity.Company;
import entity.Product;
import entity.Report;
import entity.ReportDetail;

/**
 * 银行数据访问对象的实现
 * @author 靳雅楠
 *
 */
public class CompanyDaoImpl extends GenericDaoImpl<Company, Integer> implements CompanyDao{
	
	@Override
	public List<Report> selectCompanyReportAll() {
		final List<Report> reports = new ArrayList<Report>();
		getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Connection con = session.connection();
				String sql = new StringBuffer()
						.append("select c.companyName companyName,\n")
						.append("		c.companyId companyId,\n")
						.append("		(select count(1) \n")
						.append("			from product p \n")
						.append("			where p.company = c.companyId ) productNum,\n")
						.append("		(select sum(p.financingAmountTo) \n")
						.append("			from product p \n")
						.append("			where p.company = c.companyId ) financingActualTotal,\n")
						.append("		(select sum(a.applyNum)\n")
						.append("			from apply a,product p\n")
						.append("			where a.applyProductId = p.productId\n")
						.append("			and p.company = c.companyId) financingTarget,\n")
						.append("		truncate((select sum(a.applyNum*c.financingInReturn/100) from product p,apply a \n")
						.append("			where a.applyProductId = p.productId\n")
						.append("			and p.company = c.companyId),2) financingInReturnNumTotal\n")
						.append("from company c \n")
						.toString();
				System.out.println(sql);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Report r = new Report();
					Company c = new Company();
					c.setCompanyName(rs.getString("companyName"));
					c.setCompanyId(rs.getInt("companyId"));
					r.setCompany(c);
					r.setProductNum(rs.getInt("productNum"));
					r.setFinancingActualTotal(rs.getInt("financingActualTotal"));
					r.setFinancingTarget(rs.getInt("financingTarget"));
					r.setFinancingInReturnNumTotal(rs.getDouble("financingInReturnNumTotal"));
					reports.add(r);
				}
				stmt.close();
				rs.close();
				return reports;
			}
		});
		return reports;
		 
	
	}
	
	@Override
	public List<Report> selectCompanyReportByYear(final Integer year) {
		final List<Report> reports = new ArrayList<Report>();
		
		getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Connection con = session.connection();
				String sql = new StringBuffer()
						.append("select c.companyName companyName,\n")
						.append("		c.companyId companyId,\n")
						.append("		(select count(1) \n")
						.append("			from product p \n")
						.append("			where p.company = c.companyId \n")
						.append("			and YEAR(p.createTime) = "+year+") productNum,\n")
						.append("		(select sum(p.financingAmountTo) \n")
						.append("			from product p \n")
						.append("			where p.company = c.companyId \n")
						.append("			and YEAR(p.createTime) = "+year+") financingActualTotal,\n")
						.append("		(select sum(a.applyNum)\n")
						.append("			from apply a,product p\n")
						.append("			where a.applyProductId = p.productId\n")
						.append("			and p.company = c.companyId\n")
						.append("			and YEAR(p.createTime) = "+year+") financingTarget,\n")
						.append("		truncate((select sum(a.applyNum*c.financingInReturn/100) from product p,apply a \n")
						.append("			where a.applyProductId = p.productId\n")
						.append("			and p.company = c.companyId\n")
						.append("			and YEAR(p.createTime) = "+year+"),2) financingInReturnNumTotal\n")
						.append("from company c\n")
						.toString();
				System.out.println(sql);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Report r = new Report();
					Company c = new Company();
					c.setCompanyName(rs.getString("companyName"));
					c.setCompanyId(rs.getInt("companyId"));
					r.setCompany(c);
					r.setProductNum(rs.getInt("productNum"));
					r.setFinancingActualTotal(rs.getInt("financingActualTotal"));
					r.setFinancingTarget(rs.getInt("financingTarget"));
					r.setFinancingInReturnNumTotal(rs.getDouble("financingInReturnNumTotal"));
					reports.add(r);
				}
				stmt.close();
				rs.close();
				return reports;
			}
		});
		return reports;
	}

	@Override
	public List<ReportDetail> selectCompanyReportDetailByCompanyId(
			final Integer companyId) {
		
		final List<ReportDetail> reportDetails = new ArrayList<ReportDetail>();
		
		getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Connection con = session.connection();
				String sql = new StringBuffer()
						.append("select p.productName productName,\n")
						.append("	    p.createTime createTime,\n")
						.append("	    p.financingAmountTo financingAmountTo,\n")
						.append("	    (select sum(a.applyNum)\n")
						.append("			from apply a\n")
						.append("			where a.applyProductId = p.productId) financingActual,\n")
						.append("		(select truncate(sum(a.applyNum*c.financingInReturn)/100,2)\n")
						.append("			from company c,apply a\n")
						.append("			where p.company = c.companyId\n")
						.append("			and a.applyProductId = p.productId) financingInReturnNum\n")
						.append("from product p\n")
						.append("where p.company = "+companyId)
						.toString();
				System.out.println(sql);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					ReportDetail rd = new ReportDetail();
					Product p = new Product();
					p.setProductName(rs.getString("productName"));
					p.setCreateTime(rs.getDate("createTime"));
					p.setFinancingAmountTo(rs.getInt("financingAmountTo"));
					rd.setProduct(p);
					rd.setFinancingActual(rs.getInt("financingActual"));
					rd.setFinancingInReturnNum(rs.getDouble("financingInReturnNum"));
					reportDetails.add(rd);
				}
		 		
				return reportDetails;
			}
		});
		return reportDetails;
	}


	@Override
	public void updateCompanyStatus(Integer companyId, String status) {
		String hql = new StringBuffer()
				.append(" update Company c ") 
				.append(" 	set c.status = ? ") 
				.append("	where c.companyId = ? ") 
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{status,companyId});
	}
	

	
	public static void main(String[] args) {
		List<Report> reports = new CompanyDaoImpl().selectCompanyReportAll();
		System.out.println(reports);
	}
	
	
	
	
	
	
	
	
	
	
	
}
