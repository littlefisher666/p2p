package entity;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	/**
	 * The effective product ; Default
	 */
	public static final String STATUS_EFFICTIVE = "E";
	/**
	 * The Invalid product
	 */
	public static final String STATUS_INVALID = "I";
	/**
	 * Deleted
	 */
	public static final String STATUS_DELETED = "D";
	/**
	 * 产品id
	 */
	private Integer productId;
	/**
	 * 产品所属银行
	 */
	private Company company;
	/**
	 * 产品所属类型
	 */
	private ProductType productType;
	/**
	 * 产品贷款周期
	 */
	private LendingPeriod lendingPeriod;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品最低利率
	 */
	private double primeLendingRateFrom;
	/**
	 * 产品最高利率
	 */
	private double primeLendingRateTo;
	/**
	 * 产品最低规模
	 */
	private Integer financingAmountFrom;
	/**
	 * 产品最高规模
	 */
	private Integer financingAmountTo;
	/**
	 * 产品联系人
	 */
	private String linkMan;
	/**
	 * 产品所属的地方银行全称
	 */
	private String ownedBank;
	/**
	 * 产品描述
	 */
	private String productDescription;
	/**
	 * 产品上线时间
	 */
	private Date createTime;
	/**
	 * 产品的状态
	 */
	private String status;
	/**
	 * 拥有该产品的申请
	 */
	private Set applies = new TreeSet();

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(Company company, ProductType productType,
			LendingPeriod lendingPeriod, String productName,
			double primeLendingRateFrom, double primeLendingRateTo,
			Integer financingAmountFrom, Integer financingAmountTo,
			String linkMan, String ownedBank, String productDescription,
			Date createTime, Set applies,String status) {
		this.company = company;
		this.productType = productType;
		this.lendingPeriod = lendingPeriod;
		this.productName = productName;
		this.primeLendingRateFrom = primeLendingRateFrom;
		this.primeLendingRateTo = primeLendingRateTo;
		this.financingAmountFrom = financingAmountFrom;
		this.financingAmountTo = financingAmountTo;
		this.linkMan = linkMan;
		this.ownedBank = ownedBank;
		this.productDescription = productDescription;
		this.createTime = createTime;
		this.applies = applies;
		this.status = status;
	}

	// Property accessors


	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public LendingPeriod getLendingPeriod() {
		return this.lendingPeriod;
	}

	public void setLendingPeriod(LendingPeriod lendingPeriod) {
		this.lendingPeriod = lendingPeriod;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrimeLendingRateFrom() {
		return this.primeLendingRateFrom;
	}

	public void setPrimeLendingRateFrom(double primeLendingRateFrom) {
		this.primeLendingRateFrom = primeLendingRateFrom;
	}

	public double getPrimeLendingRateTo() {
		return this.primeLendingRateTo;
	}

	public void setPrimeLendingRateTo(double primeLendingRateTo) {
		this.primeLendingRateTo = primeLendingRateTo;
	}

	public Integer getFinancingAmountFrom() {
		return this.financingAmountFrom;
	}

	public void setFinancingAmountFrom(Integer financingAmountFrom) {
		this.financingAmountFrom = financingAmountFrom;
	}

	public Integer getFinancingAmountTo() {
		return this.financingAmountTo;
	}

	public void setFinancingAmountTo(Integer financingAmountTo) {
		this.financingAmountTo = financingAmountTo;
	}

	public String getLinkMan() {
		return this.linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getOwnedBank() {
		return this.ownedBank;
	}

	public void setOwnedBank(String ownedBank) {
		this.ownedBank = ownedBank;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set getApplies() {
		return this.applies;
	}

	public void setApplies(Set applies) {
		this.applies = applies;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}

	
