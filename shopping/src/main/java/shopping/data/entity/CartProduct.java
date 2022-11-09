package shopping.data.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartProduct {

	@Id @GeneratedValue
	private Long cartProductId;
	
	private Long cartId;
	
	private Long productId;
	
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

	public Integer getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(Integer salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public BigDecimal getLineAmount() {
		return lineAmount;
	}

	public void setLineAmount(BigDecimal lineAmount) {
		this.lineAmount = lineAmount;
	}

	@Override
	public String toString() {
		return "CartProduct [cartProductId=" + cartProductId + ", cartId=" + cartId + ", productId=" + productId
				+ ", salesQuantity=" + salesQuantity + ", lineAmount=" + lineAmount + "]";
	}

	public BigDecimal getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice) {
		this.salesPrice = salesPrice;
	}	
	
	
}