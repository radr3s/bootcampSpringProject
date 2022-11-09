package com.commerce.business.dto;

import java.math.BigDecimal;

public class ProductDto {

	private Long productId;
	
	private String productName;
	
	private BigDecimal salesPrice;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", salesPrice=" + salesPrice
				+ "]";
	}
	
	
}
