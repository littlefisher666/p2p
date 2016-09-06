package dao.impl;

import dao.LendingPeriodDao;
import entity.LendingPeriod;

/**
 * 贷款周期的数据访问对象的实现
 * @author 靳雅楠
 *
 */
public class LendingPeriodDaoImpl extends GenericDaoImpl<LendingPeriod, Integer> implements LendingPeriodDao{

	@Override
	public void updateLendingPeriodStatus(Integer lendingPeriodId, String status) {
		String hql = new StringBuffer()
				.append(" update LendingPeriod l ") 
				.append("	 set l.status = ? ") 
				.append("	 where l.lendingPeriodId = ? ") 
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{status,lendingPeriodId});
	}

	@Override
	public void updateLendingPeriodPeriod(Integer lendingPeriodId, String period) {
		String hql = new StringBuffer()
				.append(" update LendingPeriod l ")
				.append(" 	set l.period = ? ") 
				.append("	where l.lendingPeriodId = ? ") 
				.toString();
		getHibernateTemplate().bulkUpdate(hql, new Object[]{period,lendingPeriodId});
	}

}
