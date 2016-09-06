package service;

import java.util.List;

import entity.Apply;
import exception.IdNotFoundException;

/**
 * 申请的业务处理对象
 * @author 靳雅楠
 *
 */
public interface ApplyService {

	/**
	 * 申请产品
	 * @param apply 封装了申请信息的对象
	 * @param productId 产品id
	 * @throws IdNotFoundException id不存在异常，当productId在数据库中不存在时，抛出此异常
	 */
	public void applyProduct(Apply apply,Integer productId) throws IdNotFoundException;
	
	/**
	 * 检索所有申请了该产品的申请
	 * @param productId 产品的id
	 * @return 封装了所有申请信息的集合，当申请不存在时，返回一个空的List集合
	 */
	public List<Apply> qryApplyByProduct(Integer productId);
	
	/**
	 * 根据产品id查询所有申请
	 * @param productId 产品的id 
	 * @return 封装了所有申请信息的集合，当申请不存在时，返回一个空的List集合
	 */
	public List<Apply> onlineApplyDetail(Integer productId);
	
	/**
	 * 修改申请的状态
	 * @param applyId 申请id
	 * @param status 要修改成的状态
	 */
	public void updateApplyStatus(Integer applyId,String status);
	
	/**
	 * 根据申请id查询一个申请
	 * @param applyId 申请id
	 * @return 封装了申请信息的实体
	 */
	public Apply qryApplyByApplyId(Integer applyId);
}















