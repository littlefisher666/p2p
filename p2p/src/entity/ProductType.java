package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Producttype entity. @author MyEclipse Persistence Tools
 */

public class ProductType implements java.io.Serializable {
	
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
	 * 产品类型id
	 */
	private Integer productTypeId;
	/**
	 * 产品类型名
	 */
	private String productTypeName;
	/**
	 * 产品类型的状态
	 */
	private String status;
	private Set products = new HashSet(0);

	// Constructors

	/** default constructor */
	public ProductType() {
	}

	/** full constructor */
	public ProductType(String productTypeName, Set products,String status) {
		this.productTypeName = productTypeName;
		this.products = products;
		this.status = status;
	}

	// Property accessors


	public Integer getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return this.productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}