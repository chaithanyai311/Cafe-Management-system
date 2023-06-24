package com.shopping.model;

public class Item {
	private int itemId;
	private String itemName;
	private int itemPrice;
	private String itemDescription;
	private String imageUrl;
	private String category;
	private int customerId;
	
	public Item(int itemId, String itemName, int itemPrice, String itemDescription, String imageUrl, String category,
			int customerId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
		this.imageUrl = imageUrl;
		this.category = category;
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemDescription="
				+ itemDescription + ", imageUrl=" + imageUrl + ", category=" + category + ", customerId=" + customerId
				+ "]";
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
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
}
