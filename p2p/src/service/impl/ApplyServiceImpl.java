package service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.ApplyDao;
import dao.ProductDao;

import entity.Apply;
import entity.Product;
import service.ApplyService;

/**
 * 申请的业务处理对象的实现
 * @author 靳雅楠
 *
 */
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class ApplyServiceImpl implements ApplyService{

	private ApplyDao ad ;
	private ProductDao pd;
	
	public ProductDao getPd() {
		return pd;
	}

	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	public ApplyDao getAd() {
		return ad;
	}

	public void setAd(ApplyDao ad) {
		this.ad = ad;
	}

	@Override
	public List<Apply> qryApplyByProduct(Integer productId) {
		
		return ad.selectApplyByProductId(productId);
	}

	@Override
	public void applyProduct(Apply apply, Integer productId) {
		apply.setApplyProductId(productId);
		ad.insertApply(apply, productId);
	}

	@Override
	public List<Apply> onlineApplyDetail(Integer productId) {
		return qryApplyByProduct(productId);
	}

	@Override
	public void updateApplyStatus(Integer applyId, String status) {
		ad.updateApplyStatus(applyId, status);
	}

	@Override
	public Apply qryApplyByApplyId(Integer applyId) {
		return ad.selectById(applyId);
	}

	

	


}
