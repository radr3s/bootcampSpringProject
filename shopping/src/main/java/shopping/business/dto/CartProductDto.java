package shopping.business.dto;

import java.math.BigDecimal;

public class CartProductDto {
	
	private Long cartProductId;
	
	private Long cartId;
	
	private Long productId;
	
	private String productName;
	
	private Integer salesQuantity;
	
	private BigDecimal salesPrice;
	
	private BigDecimal lineAmount;

	public Long getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(Long cartProductId) {
		this.cartProductId = cartProductId;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(Integer salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}

	public BigDecimal getLineAmount() {
		return lineAmount;
	}

	public void setLineAmount(BigDecimal lineAmount) {
		this.lineAmount = lineAmount;
	}

	@Override
	public String toString() {
		return "CartProductDto [cartProductId=" + cartProductId + ", cartId=" + cartId + ", productId=" + productId
				+ ", productName=" + productName + ", salesQuantity=" + salesQuantity + ", salesPrice=" + salesPrice
				+ ", lineAmount=" + lineAmount + "]";
	}
	
	

	
}