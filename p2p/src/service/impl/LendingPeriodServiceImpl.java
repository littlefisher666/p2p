package service.impl;

import java.util.List;

import dao.LendingPeriodDao;

import entity.LendingPeriod;
import service.LendingPeriodService;
/**
 * 贷款周期服务对象的实现
 * @author 靳雅楠
 *
 */
public class LendingPeriodServiceImpl implements LendingPeriodService {
	
	private LendingPeriodDao lpd;
	

	public LendingPeriodDao getLpd() {
		return lpd;
	}

	public void setLpd(LendingPeriodDao lpd) {
		this.lpd = lpd;
	}

	@Override
	public void addLendingPeriod(LendingPeriod lendingPeriod) {
		lpd.insert(lendingPeriod);
	}

	@Override
	public List<LendingPeriod> loanTimeManage() {
		return lpd.selectAll();
	}

	@Override
	public void modLendingPeriodPeriod(LendingPeriod lendingPeriod) {
		lpd.updateLendingPeriodPeriod(lendingPeriod.getLendingPeriodId(), lendingPeriod.getPeriod());
	}

	@Override
	public void modLendingPeriodStatus(Integer lendingPeriodId, String status) {
		lpd.updateLendingPeriodStatus(lendingPeriodId, status);
	}

	@Override
	public List<LendingPeriod> qryLendingPeriodAll() {
		return loanTimeManage();
	}

}
