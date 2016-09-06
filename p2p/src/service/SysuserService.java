package service;

import java.util.List;

import entity.Apply;
import entity.Company;
import entity.Product;
import entity.Sysuser;
import exception.FaultNameOrPasswordException;
import exception.IdNotFoundException;

/**
 * 超级管理员服务对象
 * @author 靳雅楠
 *
 */
public interface SysuserService {

	/**
	 * 管理员密码修改
	 * @param sysuser 带有新密码的管理员信息对象
	 * @throws FaultNameOrPasswordException 用户名或密码错误异常，当登录信息错误时抛出此异常
	 */
	public void modSysuserPassword(Sysuser sysuser) throws FaultNameOrPasswordException;
	
	/**
	 * 管理员登录
	 * @param sysuser 封装了管理员信息的对象
	 * @throws FaultNameOrPasswordException 用户名或密码错误异常，当登录信息错误时抛出此异常
	 * @return 封装了管理员信息的对象
	 */
	public Sysuser login(Sysuser sysuser) throws FaultNameOrPasswordException;
	
	/**
	 * 查询所有的产品信息
	 * @return 封装了产品信息的List集合，当产品不存在时，返回一个空的List集合
	 */
	public List<Product> qryProductAll();
	
	/**
	 * 检索所有申请
	 * @return 封装了所有申请信息的集合，当申请者不存在时，返回一个空的List集合
	 */
	public List<Apply> qryApplyAll();
	
	/**
	 * 检索所有的银行
	 * @return 封装了所有银行信息的集合，当申请者不存在时，返回一个空的List集合
	 */
	public List<Company> qryCompanyAll();
	
	/**
	 * 根据产品id删除一个产品
	 * @param productId 产品id
	 * @exception IdNotFoundException id不存在异常，当该id在本系统中查询不到时，抛出此异常
	 */
	public void delProductByProductId(Integer productId) throws IdNotFoundException;
	
	/**
	 * 根据银行id删除一个银行
	 * @param companyId 银行id
	 * @exception IdNotFoundException id不存在异常，当该id在本系统中查询不到时，抛出此异常
	 */
	public void delCompanyByCompanyId(Integer companyId) throws IdNotFoundException;
	
	/**
	 * 通过银行进入本系统的申请
	 * @param companyId 银行id
	 */
	public void passCompany(Integer companyId);
	
	/**
	 * 拒绝银行进入本系统的申请
	 * @param companyId 银行id
	 */
	public void refuseCompany(Integer companyId) throws IdNotFoundException;
	
	/**
	 * 根据新闻id删除一条新闻
	 * @param newsId 新闻id
	 * @throws IdNotFoundException id不存在异常，当该id在本系统中查询不到时，抛出此异常
	 */
	public void delNewsByNewsId(Integer newsId) throws IdNotFoundException;
	
	/**
	 * 根据产品类型id修改它的状态
	 * @param productTypeId 产品类型id
	 * @param status 要修改成的状态
	 * @throws IdNotFoundException id不存在异常，当该id在本系统中查询不到时，抛出此异常
	 */
	public void updateProductTypeStatus(Integer productTypeId,String status) throws IdNotFoundException;
	
}













