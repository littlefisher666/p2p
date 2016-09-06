package dao;

import java.util.List;

import entity.Apply;

/**
 * 申请的数据访问对象
 * @author 靳雅楠
 *
 */
public interface ApplyDao extends GenericDao<Apply, Integer>{
	
	
	
	/**
	 * 根据申请者申请的产品id查询出所有申请了该产品的申请
	 * @param productId 产品id
	 * @return 封装了所有申请信息的集合，如果没查找到返回一个空的集合
	 */
	public List<Apply> selectApplyByProductId(Integer productId);
	
	/**
	 * 根据申请的信息查询数据库中是否已经存在一个该申请
	 * @param apply 封装了申请信息的对象
	 * @return 封装了申请信息的对象
	 */
	public Apply selectByApply(Apply apply);
	
	/**
	 * 根据applyId修改该apply的status
	 * @param applyId 申请id
	 * @param status 要修改成的状态
	 */
	public void updateApplyStatus(Integer applyId,String status);
	
	/**
	 * 插入一条申请
	 * @param apply 封装了申请的对象
	 * @param productId 要申请的产品id
	 */
	public void insertApply(Apply apply,Integer productId);
	
}



















