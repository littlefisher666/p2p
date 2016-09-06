package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Lendingperiod entity. @author MyEclipse Persistence Tools
 */

public class LendingPeriod implements java.io.Serializable {

	/**
	 * Open
	 */
	public static final String STATUS_OPEN = "O";
	/**
	 * Closed ; Default
	 */
	public static final String STATUS_CLOSED = "C";
	/**
	 * Deleted
	 */
	public static final String STATUS_DELETED = "D";
	/**
	 * 贷款周期id
	 */
	private Integer lendingPeriodId;
	/**
	 * 贷款周期
	 */
	private String period;
	/**
	 *status的状态有两种：
	 *		一种为开启状态O	Open
	 *		一种为关闭状态C	Closed 
	 */
	private String status;
	/**
	 * 当前周期下的产品
	 */
	private Set products = new HashSet(0);

	// Constructors

	/** default constructor */
	public LendingPeriod() {
	}

	/** full constructor */
	public LendingPeriod(String period, String status, Set products) {
		this.period = period;
		this.status = status;
		this.products = products;
	}

	// Property accessors


	public Integer getLendingPeriodId() {
		return this.lendingPeriodId;
	}

	public void setLendingPeriodId(Integer lendingPeriodId) {
		this.lendingPeriodId = lendingPeriodId;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}