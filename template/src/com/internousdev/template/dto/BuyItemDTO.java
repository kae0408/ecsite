package com.internousdev.template.dto;

public class BuyItemDTO {
	
	public int id;
	
	public String itemName;
	
	public  int itemPrice;

	public int total_price;
	
	public int count;
	
	public int total_count;
	
	public String pay;
	
	public int item_stock;
	
	private String item_category;

	private String item_description;

	private String image_file_path;
	
	
	
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
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	public int getTotal_price() {
		return total_price;
	}
	
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	public String getPay() {
		return pay;
	}
	
	public void setPay(String pay) {
		this.pay = pay;
	}
	
	public int getItem_stock() {
		return item_stock;
	}
	
	public void setItem_stock(int item_stock) {
		this.item_stock = item_stock;
	}
	public int getTotal_count(){
		return total_count;
	}
	public void setTotal_count(int total_count){
		this.total_count=total_count;
	}
	
	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public String getItem_description() {
		return item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}

	public String getImage_file_path() {
		return image_file_path;
	}

	public void setImage_file_path(String image_file_path) {
		this.image_file_path = image_file_path;
	}

	

}
