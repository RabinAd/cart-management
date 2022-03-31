package com.service;
import java.util.ArrayList;
import java.util.ListIterator;

import com.entity.*;


public class CartService {
	
	ArrayList<Item> item;
	double totalAmount;
	double payableAmount;
	double discount;
	double tax;
	String coupon;
	CartService() {
		this.item = new ArrayList<Item>();
		this.coupon = "";
		this.totalAmount = 0;
		this.payableAmount = 0;
		this.discount = 0;
		this.tax = 0;
	}
	public void addToCart(Item item) {
		this.item.add(item);
	}
	public void showCart() {
		ListIterator<Item> iterator = item.listIterator();
		while(iterator.hasNext()) {
			Item item1 = iterator.next();
			System.out.println(item1);
		}
	}
	public void removeFromCart(Item i) {
		ListIterator<Item> iterator1 = item.listIterator();
		while(iterator1.hasNext()) {
			Item item2 = iterator1.next();
			if (item2.getProductName().equals(i.getProductName())) {
				this.item.remove(i);
				break;
			}
		}
	}
	public double getTotalAmount() {
		ListIterator<Item> iterator2 = item.listIterator();
		this.totalAmount = 0;
		while(iterator2.hasNext()) {
			Item item3 = iterator2.next();
			this.totalAmount = this.totalAmount + (item3.getUnitPrice() * item3.getQuantity());
		}
		return this.totalAmount;
	}
	public void applyCoupon(String coupon) {
		this.coupon = coupon;
		if (coupon.equals("YUMMYFOOD")) {
			this.discount = this.getTotalAmount() * (0.1);
			this.totalAmount = this.totalAmount - this.discount;
		} else {
			this.totalAmount = this.totalAmount;
		}
	}
	public double getPayableAmount() {
		this.payableAmount = 0;
		this.tax = this.totalAmount * (0.14);
		this.payableAmount = this.totalAmount + this.tax;
		return this.payableAmount;
	}

}
