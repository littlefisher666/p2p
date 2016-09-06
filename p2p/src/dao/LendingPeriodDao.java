package dao;

import entity.LendingPeriod;

/**
 * 贷款周期的数据访问对象
 * @author 靳雅楠
 *
 */
public interface LendingPeriodDao extends GenericDao<LendingPeriod, Integer>{
	
	/**
	 * 修改lendingPeriod的status的值
	 * @param lendingPeriodId 贷款周期id
	 * @param status 要修改成的状态
	 */
	public void updateLendingPeriodStatus(Integer lendingPeriodId,String status); 
	
	/**
	 * 修干lendingPeriod的period的值
	 * @param lendingPeriodId 贷款周期id
	 * @param period 要修改成的周期值
	 */
	public void updateLendingPeriodPeriod(Integer lendingPeriodId,String period);
}
