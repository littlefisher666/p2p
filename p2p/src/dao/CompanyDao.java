package dao;

import java.util.List;

import entity.Company;
import entity.Report;
import entity.ReportDetail;

/**
 * 银行的数据访问对象
 * @author 靳雅楠
 *
 */
public interface CompanyDao extends GenericDao<Company, Integer> {
	
	
	/**
	 * 查询所有银行的报表
	 * @return 封装了报表信息的集合，如果未查询到则返回空的集合
	 */
	public List<Report> selectCompanyReportAll();
	
	/**
	 *  根据年份查询符合要求的银行的报表
	 * @param year 年份
	 * @return 封装了报表信息的集合，如果未查询到则返回空的集合
	 */
	public List<Report> selectCompanyReportByYear(Integer year);
	
	/**
	 * 根据银行id查询该公司旗下所有产品的报表明细
	 * @param companyId 银行id
	 * @return 封装了报表明细信息的集合，如果未查询到则返回空的集合
	 */
	public List<ReportDetail> selectCompanyReportDetailByCompanyId(Integer companyId);
	
	/**
	 * 根据银行id修改银行的状态
	 * @param companyId 银行id
	 * @param status 要修改成的状态
	 */
	public void updateCompanyStatus(Integer companyId,String status);
	
}









