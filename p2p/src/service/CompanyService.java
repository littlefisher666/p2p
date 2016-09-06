package service;

import java.util.List;

import entity.Company;
import entity.Product;
import entity.Report;
import entity.ReportDetail;
import exception.IdNotFoundException;

/**
 * 银行服务对象
 * @author 靳雅楠
 *
 */
public interface CompanyService {

	/**
	 * 通过该申请
	 * @param applyId 申请id
	 * @throws IdNotFoundException id不存在异常，当申请id或者产品id在本系统中不存在时，抛出此异常
	 */
	public void passApply(Integer applyId) throws IdNotFoundException;
	
	/**
	 * 拒绝该申请
	 * @param applyId 申请id
	 * @throws IdNotFoundException id不存在异常，当申请id或者产品id在本系统中不存在时，抛出此异常
	 */
	public void refuseApply(Integer applyId) throws IdNotFoundException;
	
	/**
	 * 新增一个产品
	 * @param product 封装了产品信息的对象
	 */
	public void addProduct(Product product);
	
	/**
	 * 删除一个产品
	 * @param productId 产品id
	 * @throws IdNotFoundException id不存在异常，当产品id在本系统中不存在时，抛出此异常
	 */
	public void delProduct(Integer productId) throws IdNotFoundException;
	
	/**
	 * 输出一个银行的产品报表明细
	 * @param companyId 银行id
	 * @throws IdNotFoundException id不存在异常，当产品id在本系统中不存在时，抛出此异常
	 * @return 封装了产品报表明细的集合，当明细不存在时，返回一个空的List集合
	 */
	public List<ReportDetail> qryCompanyReportDetailByCompanyId(Integer companyId) throws IdNotFoundException;
	
	/**
	 * 输出所有银行的产品报表
	 * @return 封装了产品报表的集合，当明细不存在时，返回一个空的List集合
	 */
	public List<Report> qryCompanyReportAll();
	
	/**
	 * 根据年份输出当前年份银行的产品报表
	 * @param year 年份
	 * @return 封装了产品报表的集合，当明细不存在时，返回一个空的List集合
	 */
	public List<Report> qryCompanyReportByYear(Integer year);
	
	/**
	 * 注册一家银行
	 * @param company 封装了银行信息的对象
	 */
	public void registCompany(Company company);
	
	/**
	 * 修改银行信息
	 * @param company 封装了银行新信息的对象
	 */
	public void modifyCompany(Company company);
	
	/**
	 * 显示当前银行详细信息
	 * @param companyId 银行id
	 * @return 封装了银行信息的对象
	 */
	public Company companyDetail(Integer companyId);
	
	/**
	 * 企业管理页面的显示
	 * @return 封装了银行信息的集合，当银行信息不存在时，返回一个空的List集合
	 */
	public List<Company> companyManage();
	
	/**
	 * 企业报表页面的显示
	 * @return 封装了产品报表的集合，当明细不存在时，返回一个空的List集合
	 */
	public List<Report> companyReport();
}










