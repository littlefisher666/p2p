package entity;

import java.io.Serializable;

/**
 * 产品报表细则实体类
 * @author 靳雅楠
 *
 */
public class ReportDetail implements Serializable {
	private Product product;
	private Integer financingActual;
	private Double financingInReturnNum;
	
	public ReportDetail() {
		super();
	}

	public ReportDetail(Product product, Integer financingActual,
			Double financingInReturnNum) {
		super();
		this.product = product;
		this.financingActual = financingActual;
		this.financingInReturnNum = financingInReturnNum;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getFinancingActual() {
		return financingActual;
	}

	public void setFinancingActual(Integer financingActual) {
		this.financingActual = financingActual;
	}

	public Double getFinancingInReturnNum() {
		return financingInReturnNum;
	}

	public void setFinancingInReturnNum(Double financingInReturnNum) {
		this.financingInReturnNum = financingInReturnNum;
	}




	


	
	
	
	

}
