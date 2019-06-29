package com.cg.pos.entity;

public class PizzaDetailsDTO {
	private int itemId;
	private int storeId;
	private String itemName;
	private int quantity;
	private double cost;
	private String addOns;

	public PizzaDetailsDTO() {

	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public PizzaDetailsDTO(int itemId, int storeId, String itemName, int quantity, double cost, String addOns) {

		this.itemId = itemId;
		this.storeId = storeId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.cost = cost;
		this.addOns = addOns;
	}

	@Override
	public String toString() {
		return "PizzaDetails [itemId=" + itemId + ",storeName=" + storeId + ", itemName=" + itemName + ", quantity="
				+ quantity + ", cost=" + cost + ", addOns=" + addOns + "]" + '\n';
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getAddOns() {
		return addOns;
	}

	public void setAddOns(String addOns) {
		this.addOns = addOns;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

}
