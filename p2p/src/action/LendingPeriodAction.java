package action;

import java.util.List;

import entity.LendingPeriod;
import service.LendingPeriodService;

public class LendingPeriodAction extends BaseAction{
	
	private LendingPeriodService lendingPeriodService;
	private List<LendingPeriod> lendingPeriods;
	private LendingPeriod lendingPeriod;
	private Integer lendingPeriodId;
	private String status;
	
	
	
	/*
	 * GET/SET 方法
	 */
	public LendingPeriodService getLendingPeriodService() {
		return lendingPeriodService;
	}

	public void setLendingPeriodService(LendingPeriodService lendingPeriodService) {
		this.lendingPeriodService = lendingPeriodService;
	}

	public LendingPeriod getLendingPeriod() {
		return lendingPeriod;
	}

	public void setLendingPeriod(LendingPeriod lendingPeriod) {
		this.lendingPeriod = lendingPeriod;
	}

	public Integer getLendingPeriodId() {
		return lendingPeriodId;
	}

	public void setLendingPeriodId(Integer lendingPeriodId) {
		this.lendingPeriodId = lendingPeriodId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LendingPeriod> getLendingPeriods() {
		return lendingPeriods;
	}

	public void setLendingPeriods(List<LendingPeriod> lendingPeriods) {
		this.lendingPeriods = lendingPeriods;
	}
	
	/*
	 * Action业务方法
	 */
	public String addLendingPeriod() throws Exception {
		lendingPeriodService.addLendingPeriod(lendingPeriod);
		return SUCCESS;
	}
	
	public String modLendingPeriodPeriod() throws Exception {
		lendingPeriodService.modLendingPeriodPeriod(lendingPeriod);
		return SUCCESS;
	}
	
	public String modLendingPeriodStatus() throws Exception {
		System.out.println("LendingPeriodAction modLendingPeriodStatus lendingPeriodId:"+lendingPeriodId+",status:"+status);
		lendingPeriodService.modLendingPeriodStatus(lendingPeriodId, status);
		return SUCCESS;
	}
	
	public String loanTimeManage() throws Exception {
		lendingPeriods = lendingPeriodService.loanTimeManage();
		
		for (LendingPeriod lendingPeriod : lendingPeriods) {
			System.out.println("LendingPeriodAction loanTimeManage lendingPeriod.lendingPeriodId:"+lendingPeriod.getLendingPeriodId());
		}
		
		return SUCCESS;
	}
	
}
