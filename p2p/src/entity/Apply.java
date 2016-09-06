package entity;

import java.util.Date;

/**
 * Apply entity. @author MyEclipse Persistence Tools
 */

public class Apply implements java.io.Serializable,Comparable<Apply> {
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
	// Fields
	/**
	 * 申请id
	 */
	private Integer applyId;
	/**
	 * 该申请所属产品的id
	 */
	private Integer applyProductId;
	/**
	 * 改申请所属产品
	 */
	private Product product;
	/**
	 * 申请人的姓名
	 */
	private String applyPerson;
	/**
	 * 申请人的身份证号
	 */
	private String applyPersonIdcard;
	/**
	 * 申请数量
	 */
	private Integer applyNum;
	/**
	 * 申请时间
	 */
	private Date applyDate;
	/**
	 * 申请所属产品名
	 */
	private String applyProductName;
	/**
	 * 申请的状态
	 */
	private String status;

	// Constructors

	/** default constructor */
	public Apply() {
	}


	public Integer getApplyId() {
		return applyId;
	}


	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}


	public Integer getApplyProductId() {
		return applyProductId;
	}


	public void setApplyProductId(Integer applyProductId) {
		this.applyProductId = applyProductId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public String getApplyPerson() {
		return applyPerson;
	}


	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}


	public String getApplyPersonIdcard() {
		return applyPersonIdcard;
	}


	public void setApplyPersonIdcard(String applyPersonIdcard) {
		this.applyPersonIdcard = applyPersonIdcard;
	}


	public Integer getApplyNum() {
		return applyNum;
	}


	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}


	public Date getApplyDate() {
		return applyDate;
	}


	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}


	public String getApplyProductName() {
		return applyProductName;
	}


	public void setApplyProductName(String applyProductName) {
		this.applyProductName = applyProductName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((applyDate == null) ? 0 : applyDate.hashCode());
		result = prime * result + ((applyId == null) ? 0 : applyId.hashCode());
		result = prime * result
				+ ((applyNum == null) ? 0 : applyNum.hashCode());
		result = prime * result
				+ ((applyPerson == null) ? 0 : applyPerson.hashCode());
		result = prime
				* result
				+ ((applyPersonIdcard == null) ? 0 : applyPersonIdcard
						.hashCode());
		result = prime * result
				+ ((applyProductId == null) ? 0 : applyProductId.hashCode());
		result = prime
				* result
				+ ((applyProductName == null) ? 0 : applyProductName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apply other = (Apply) obj;
		if (applyDate == null) {
			if (other.applyDate != null)
				return false;
		} else if (!applyDate.equals(other.applyDate))
			return false;
		if (applyId == null) {
			if (other.applyId != null)
				return false;
		} else if (!applyId.equals(other.applyId))
			return false;
		if (applyNum == null) {
			if (other.applyNum != null)
				return false;
		} else if (!applyNum.equals(other.applyNum))
			return false;
		if (applyPerson == null) {
			if (other.applyPerson != null)
				return false;
		} else if (!applyPerson.equals(other.applyPerson))
			return false;
		if (applyPersonIdcard == null) {
			if (other.applyPersonIdcard != null)
				return false;
		} else if (!applyPersonIdcard.equals(other.applyPersonIdcard))
			return false;
		if (applyProductId == null) {
			if (other.applyProductId != null)
				return false;
		} else if (!applyProductId.equals(other.applyProductId))
			return false;
		if (applyProductName == null) {
			if (other.applyProductName != null)
				return false;
		} else if (!applyProductName.equals(other.applyProductName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}


	public Apply(Integer applyId, Integer applyProductId, Product product,
			String applyPerson, String applyPersonIdcard, Integer applyNum,
			Date applyDate, String applyProductName, String status) {
		super();
		this.applyId = applyId;
		this.applyProductId = applyProductId;
		this.product = product;
		this.applyPerson = applyPerson;
		this.applyPersonIdcard = applyPersonIdcard;
		this.applyNum = applyNum;
		this.applyDate = applyDate;
		this.applyProductName = applyProductName;
		this.status = status;
	}


	@Override
	public int compareTo(Apply apply) {
		return apply.hashCode();
	}

}