package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;


import dao.ApplyDao;
import entity.Apply;

/**
 * 申请访问对象的实现
 * @author 靳雅楠
 *
 */
public class ApplyDaoImpl extends GenericDaoImpl<Apply, Integer> implements ApplyDao  {


	@SuppressWarnings("unchecked")
	@Override
	public Apply selectByApply(Apply apply) {
		String hql = new StringBuffer()
				.append(" from Apply a ")
				.append("	where a.applyPerson = ? and ") 
				.append("	a.applyPersonIDCard = ? and ") 
				.append("	a.applyNum = ? and ") 
				.append("	a.applyProductName = ? and ") 
				.append("	a.applyProductId = ? ") 
				.toString();
		Object[] objs = new Object[]{apply.getApplyPerson(),apply.getApplyPersonIdcard(),apply.getApplyNum(),
									 apply.getApplyProductName(),apply.getApplyProductId()};
		List<Apply> applies = getHibernateTemplate().find(hql, objs);
		return applies.size() != 0 ? applies.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Apply> selectApplyByProductId(Integer productId) {
		String hql = new StringBuffer()
				.append(" from Apply a ")
				.append(" 	where a.applyProductId = ? ") 
				.toString();
		return getHibernateTemplate().find(hql,productId);
	}

	@Override
	public void updateApplyStatus(Integer applyId, String status) {
		String hql = new StringBuffer()
				.append(" update Apply a  ")
				.append(" 	set a.status = ? ") 
				.append(" 	where a.applyId = ? ")
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{status,applyId});
	}

	@Override
	public void insertApply(final Apply apply, final Integer productId) {
		
		getHibernateTemplate().execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Connection con = session.connection();
				String sql = new StringBuffer()
					.append("insert into apply \n")
					.append("	(applyProductId, applyPerson, applyPersonIDCard, applyDate)  \n")
					.append("	values \n")
					.append("	(?,?,?,?)\n")
					.toString();
				System.out.println(sql);
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, productId);
				ps.setString(2, apply.getApplyPerson());
				ps.setString(3, apply.getApplyPersonIdcard());
				ps.setDate(4, (java.sql.Date) apply.getApplyDate());
				ps.execute();
					
				return null;
			}
		});
	}

}
