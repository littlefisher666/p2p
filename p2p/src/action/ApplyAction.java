package action;


import java.util.Date;
import java.util.List;

import entity.Apply;

import service.ApplyService;

/**
 * 申请Action的对象
 * @author 靳雅楠
 *
 */
public class ApplyAction extends BaseAction {
	
	private ApplyService applyService;
	private Apply apply;
	private Integer productId;
	private Integer applyId;
	private String status;
	private List<Apply> applies;
	
	/*
	 * GET/SET 方法
	 */
	
	public ApplyService getApplyService() {
		return applyService;
	}

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public List<Apply> getApplies() {
		return applies;
	}

	public void setApplies(List<Apply> applies) {
		this.applies = applies;
	}

	/*
	 * Action业务方法
	 */
	public String applyProduct() throws Exception {
		apply.setApplyDate(new java.sql.Date(new java.util.Date().getTime()));
		applyService.applyProduct(apply, productId);
		return SUCCESS;
	}
	
	public String qryApplyByProduct() throws Exception {
		applies = applyService.qryApplyByProduct(productId);
		return SUCCESS;
	}
	
	public String onlineApplyDetail() throws Exception {
		applies = applyService.onlineApplyDetail(productId);
		return SUCCESS;
	}
	 public String modApplyStatus() throws Exception {
		 applyService.updateApplyStatus(applyId, status);
		 productId = applyService.qryApplyByApplyId(applyId).getApplyProductId();
		 return SUCCESS;
	 }
}















