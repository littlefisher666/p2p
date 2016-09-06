package service;

import java.util.List;

import entity.LendingPeriod;

/**
 * 贷款周期服务对象
 * @author 靳雅楠
 *
 */
public interface LendingPeriodService {
	
	/**
	 * 添加一个贷款周期对象
	 * @param lendingPeriod 贷款周期对象
	 */
	public void addLendingPeriod(LendingPeriod lendingPeriod);
	
	/**
	 * 修改贷款周期对象中的周期属性
	 * @param lendingPeriod 封装了贷款周期的对象
	 */
	public void modLendingPeriodPeriod(LendingPeriod lendingPeriod);
	
	/**
	 * 修改贷款周期对象中的状态属性
	 * @param lendingPeriodId 贷款周期id
	 * @param status 要修改成的状态
	 */
	public void modLendingPeriodStatus(Integer lendingPeriodId,String status);
	
	/**
	 * 贷款周期管理页面的显示
	 * @return 封装了贷款周期信息的List集合，当贷款周期不存在时，返回一个空的List集合
	 */
	public List<LendingPeriod> loanTimeManage();
	
	/**
	 * 查询所有的贷款周期
	 * @return 封装了贷款周期信息的List集合，当贷款周期不存在时，返回一个空的List集合
	 */
	public List<LendingPeriod> qryLendingPeriodAll();
}
