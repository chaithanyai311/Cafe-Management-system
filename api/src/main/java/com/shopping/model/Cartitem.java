package com.shopping.model;

public class Cartitem {
	private int cartId;
	private String cartName;
	private float cartPrice;
	private String cartDescription;
	private String imageUrl;
	private String category;
	private int custId;
	private int itemId;
	private int customerId;
	
	@Override
	public String toString() {
		return "Cartitem [cartId=" + cartId + ", cartName=" + cartName + ", cartPrice=" + cartPrice
				+ ", cartDescription=" + cartDescription + ", imageUrl=" + imageUrl + ", category=" + category
				+ ", custId=" + custId + ", itemId=" + itemId + ", customerId=" + customerId + "]";
	}
	
	public Cartitem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cartitem(int cartId, String cartName, float cartPrice, String cartDescription, String imageUrl,
			String category, int custId, int itemId, int customerId) {
		super();
		this.cartId = cartId;
		this.cartName = cartName;
		this.cartPrice = cartPrice;
		this.cartDescription = cartDescription;
		this.imageUrl = imageUrl;
		this.category = category;
		this.custId = custId;
		this.itemId = itemId;
		this.customerId = customerId;
	}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getCartName() {
		return cartName;
	}
	public void setCartName(String cartName) {
		this.cartName = cartName;
	}
	public float getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(float cartPrice) {
		this.cartPrice = cartPrice;
	}
	public String getCartDescription() {
		return cartDescription;
	}
	public void setCartDescription(String cartDescription) {
		this.cartDescription = cartDescription;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
