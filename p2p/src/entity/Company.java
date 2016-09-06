package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */

public class Company implements java.io.Serializable {
	
	/**
	 * passed
	 */
	public static final String STATUS_PASS = "P";
	/**
	 * refused
	 */
	public static final String STATUS_REFUSE = "R";
	/**
	 * wait to pass ; Default
	 */
	public static final String STATUS_WAIT = "W";
	/**
	 * Deleted
	 */
	public static final String STATUS_DELETED = "D";
	/**
	 * 银行id
	 */
	private Integer companyId;
	/**
	 * 银行名称
	 */
	private String companyName;
	/**
	 * 佣金
	 */
	private double financingInReturn;
	/**
	 * 银行描述
	 */
	private String companyDetail;
	/**
	 * 银行的状态
	 */
	private String status;
	/**
	 * 该银行下的产品
	 */
	private Set products = new HashSet(0);

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** full constructor */
	public Company(String companyName, double financingInReturn,
			String companyDetail, Set products,String status) {
		this.companyName = companyName;
		this.financingInReturn = financingInReturn;
		this.companyDetail = companyDetail;
		this.products = products;
		this.status = status;
	}

	// Property accessors



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getFinancingInReturn() {
		return this.financingInReturn;
	}

	public void setFinancingInReturn(double financingInReturn) {
		this.financingInReturn = financingInReturn;
	}

	public String getCompanyDetail() {
		return this.companyDetail;
	}

	public void setCompanyDetail(String companyDetail) {
		this.companyDetail = companyDetail;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}