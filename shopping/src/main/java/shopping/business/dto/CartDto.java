package shopping.business.dto;

import java.math.BigDecimal;
import java.util.List;

public class CartDto {

	private Long cartId;
	
	private String customerName;
	
	private BigDecimal totalAmount;
	
	private boolean cartStatus;
	
	private List<CartProductDto> cartProductsDto;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(boolean cartStatus) {
		this.cartStatus = cartStatus;
	}

	@Override
	public String toString() {
		return "CartDto [cartId=" + cartId + ", customerName=" + customerName + ", totalAmount=" + totalAmount
				+ ", cartStatus=" + cartStatus + ", cartProductsDto=" + cartProductsDto + "]";
	}

	public List<CartProductDto> getCartProductsDto() {
		return cartProductsDto;
	}

	public void setCartProductsDto(List<CartProductDto> cartProductsDto) {
		this.cartProductsDto = cartProductsDto;
	}
	
	
	
}
