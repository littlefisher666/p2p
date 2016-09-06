package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;



import dao.ProductDao;
import entity.Company;
import entity.LendingPeriod;
import entity.Product;
import entity.ProductType;

/**
 * 产品数据数据访问对象的实现
 * @author 靳雅楠
 *
 */
public class ProductDaoImpl extends GenericDaoImpl<Product, Integer> implements ProductDao{
	
	
	
	@Override
	public List<Product> selectProduct(
						final Integer financingAmountFrom, final Integer financingAmountTo,
						final Double primeLendingRateFrom, final Double primeLendingRateTo,
						final Integer productTypeId,final Integer lendingPeriodId){
		
		final List<Product> products = new ArrayList<Product>();
		
		getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Connection con = session.connection();
				StringBuffer sql = new StringBuffer()
					.append("select p.*, \t\n")	
					.append("		(select c.companyName\t\n")
					.append("			from company c \t\n")	
					.append("			where c.companyId = p.company) companyName,\t\n")	
					.append("		(select pt.productTypeName\t\n")	
					.append("			from productType pt\t\n")	
					.append("			where pt.productTypeId = p.productType) productTypeName,\t\n")	
					.append("		(select lp.period\t\n")	
					.append("			from lendingPeriod lp\t\n")	
					.append("			where lp.lendingPeriodId = p.lendingPeriod) period\t\n")	
					.append("from product p where\t\n");
				
				if(financingAmountFrom != null && financingAmountTo != null) {
					sql.append(" 	p.financingAmountFrom >= "+financingAmountFrom+" and p.financingAmountTo <= "+financingAmountTo+" \t\n")
					   .append(" and \t\n");
				}
				if(primeLendingRateFrom != null && primeLendingRateTo != null) {
					sql.append(" 	p.primeLendingRateFrom >= "+primeLendingRateFrom+" and p.primeLendingRateTo <= "+primeLendingRateTo+" \t\n")
					   .append(" and \t\n");
				}
				if(productTypeId != null) {
					if(productTypeId != 6){
						sql.append("	p.productType = "+productTypeId+" \t\n") 
						   .append(" and \t\n");
					} else {
						sql.append("	p.productType >= 6 \t\n") 
						   .append(" and \t\n");
					}
				}
				if(lendingPeriodId != null) {
					if(lendingPeriodId != 5) {
						sql.append(" 	p.lendingPeriod = "+lendingPeriodId+" \t\n")
						   .append(" and \t\n");
					} else {
						sql.append("	p.lendingPeriod >= 5 \t\n") 
						   .append(" and \t\n");
					}
					
				}
				sql.append(" 1=1 \t\n");
				
				System.out.println(sql);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());
				while(rs.next()){
					Product p = new Product();
					p.setProductId(rs.getInt("productId"));
					p.setProductName(rs.getString("productName"));
					
					Company c = new Company();
					c.setCompanyName(rs.getString("companyName"));
					p.setCompany(c);
					
					ProductType pt = new ProductType(); 
//					System.out.println("rs.getInt('productType'):"+rs.getInt("productType"));
					pt.setProductTypeName(rs.getString("productTypeName"));
					p.setProductType(pt);
//					System.out.println("p.getProductType().getProductTypeId():"+p.getProductType().getProductTypeId());
					
					p.setFinancingAmountFrom(rs.getInt("financingAmountFrom"));
					p.setFinancingAmountTo(rs.getInt("financingAmountTo"));
					p.setPrimeLendingRateFrom(rs.getDouble("primeLendingRateFrom"));
					p.setPrimeLendingRateTo(rs.getDouble("primeLendingRateTo"));
					
					LendingPeriod lp = new LendingPeriod();
					lp.setPeriod(rs.getString("period"));
					p.setLendingPeriod(lp);
					
					products.add(p);
				}
				stmt.close();
				rs.close();
				return products;
			}
		}); 
//		for (Product product : products) {
//			System.out.println("productId:"+product.getProductId());
//			System.out.println("companyId:"+product.getCompany().getCompanyId());
//			System.out.println("productTypeId:"+product.getProductType().getProductTypeId());
//			System.out.println("lendingPeriodId:"+product.getLendingPeriod().getLendingPeriodId());
//			System.out.println("financingAmountFrom:"+product.getFinancingAmountFrom());
//		}
		return products;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByFinancingAmount(
			Integer financingAmountFrom, Integer financingAmountTo) {
		String hql = new StringBuffer()
				.append(" from Product p")
				.append(" 	where p.financingAmountFrom >= ? and ") 
				.append("	p.financingAmountTo <= ?") 
				.toString();
		List<Product> products = getHibernateTemplate()
									.find(hql, new Object[]{financingAmountFrom,financingAmountTo});
		
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByLendingPeriod(Integer lendingPeriodId) {
		String hql = new StringBuffer()
				.append(" from Product p")
				.append(" where p.lendingPeriod = ( ")
				.append("		select period ") 
				.append(" 		from lendingperiod l ")
				.append(" 		where l.lendingPeriodId = ? ")
				.append(" )")
				.toString();
		List<Product> products = getHibernateTemplate().find(hql, lendingPeriodId);
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByPrimeLendingRate(
			Double primeLendingRateFrom, Double primeLendingRateTo) {
		String hql = new StringBuffer()
				.append(" from Product p")
				.append("	where p.primeLendingRateFrom >= ? and ") 
				.append("	p.primeLendingRateTo <= ?")
				.toString();
		List<Product> products = getHibernateTemplate()
									.find(hql,new Object[]{primeLendingRateFrom,primeLendingRateTo});
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByType(Integer productTypeId) {
		String hql = new StringBuffer()
				.append(" from Product p ")
				.append(" where p.productType = ( ")
				.append(" 	select productType ") 
				.append("		from productType pt ")
				.append("		where pt.productTypeId = ? ") 
				.append("	) ")
				.toString();
		List<Product> products = getHibernateTemplate().find(hql, productTypeId);
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectProductByCompanyId(Integer companyId) {
		String hql = new StringBuffer()
				.append(" from Product p ")
				.append(" 	where p.company = ? ")
				.toString();
		List<Product> products = getHibernateTemplate().find(hql, companyId);
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> selectAllByDate() {
		String hql = new StringBuffer()
				.append(" from Product p ")
				.append(" 	order by p.createTime") 
				.toString();
		return getHibernateTemplate().find(hql);
	}

	@Override
	public void updateProductStatus(Integer productId, String status) {
		String hql = new StringBuffer()
				.append(" update Product p ")
				.append(" 	set p.status = ? ") 
				.append(" 	where p.productId = ? ") 
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{status,productId});
	}
	

	@Override
	public List<Product> selectProductBySysuserUserName(String userName) {
		System.out.println("userName:"+userName);
		if("superAdmin".equals(userName)) {
			return selectAllByDate();
		}
		String hql = new StringBuffer()
				.append(" from Product p ")
				.append(" 	where p.linkMan = ? ") 
				.toString();
		List<Product> products = getHibernateTemplate().find(hql, userName);
		System.out.println(products);
		return products;
	}

	@Override
	public void updateProduct(Product product) {
		String hql = new StringBuffer()
				.append(" update Product p ")
				.append(" 	set p.company=?, ") 
				.append(" 		p.productType=?, ") 
				.append("		p.lendingPeriod=?, ") 
				.append(" 		p.productName=?, ") 
				.append(" 		p.primeLendingRateFrom=?, ") 
				.append(" 		p.primeLendingRateTo=?, ") 
				.append(" 		p.financingAmountFrom=?, ") 
				.append(" 		p.financingAmountTo=?, ") 
				.append(" 		p.linkMan=?, ") 
				.append(" 		p.ownedBank=?, ") 
				.append(" 		p.productDescription=? ") 
				.append(" 	where p.productId = ? ") 
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{product.getCompany(),
															product.getProductType(),
															product.getLendingPeriod(),
															product.getProductName(),
															product.getPrimeLendingRateFrom(),
															product.getPrimeLendingRateTo(),
															product.getFinancingAmountFrom(),
															product.getFinancingAmountTo(),
															product.getLinkMan(),
															product.getOwnedBank(),
															product.getProductDescription(),
															product.getProductId()});
	}

}




















