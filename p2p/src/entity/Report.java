package entity;


/**
 * 产品报表实体类
 * @author 靳雅楠
 *
 */
public class Report implements java.io.Serializable {
	
	/*
	select c.*,
		   sum(1),
		   sum(p.primeLendingRateTo),
		   sum(a.applyNum),
		   sum(a.applyNum*c.financingInReturn)
	from company c,product p,apply a
	where c.companyId=p.company 
	and a.applyProductId=p.productId
	and YEAR(p.createTime)=?; 
	*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Company company;
	private Integer productNum;
	private Integer financingTarget;
	private Integer financingActualTotal;
	private Double financingInReturnNumTotal;
	
	
	public Report() {
		super();
	}


	public Report(Company company, Integer productNum, Integer financingTarget,
			Integer financingActualTotal, Double financingInReturnNumTotal) {
		super();
		this.company = company;
		this.productNum = productNum;
		this.financingTarget = financingTarget;
		this.financingActualTotal = financingActualTotal;
		this.financingInReturnNumTotal = financingInReturnNumTotal;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Integer getProductNum() {
		return productNum;
	}


	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}


	public Integer getFinancingTarget() {
		return financingTarget;
	}


	public void setFinancingTarget(Integer financingTarget) {
		this.financingTarget = financingTarget;
	}


	public Integer getFinancingActualTotal() {
		return financingActualTotal;
	}


	public void setFinancingActualTotal(Integer financingActualTotal) {
		this.financingActualTotal = financingActualTotal;
	}


	public Double getFinancingInReturnNumTotal() {
		return financingInReturnNumTotal;
	}


	public void setFinancingInReturnNumTotal(Double financingInReturnNumTotal) {
		this.financingInReturnNumTotal = financingInReturnNumTotal;
	}
	
	
	
	
}




