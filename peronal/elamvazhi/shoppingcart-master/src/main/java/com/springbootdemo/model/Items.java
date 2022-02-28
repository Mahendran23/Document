package com.springbootdemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Items implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemID;
	@Column(name="itemName")
	private String itemName;
	@Column(name="itemPrice")
	private double itemPrice;
	@Column(name="itemQuality")
	private String itemQuality;
	@Column(name="referenceID")
	private static int referenceID;

	public Items() {

	}

	public Items(int int1, String string, double double1, String string2) {
		super();
		this.itemID = int1;
		this.itemName = string;
		this.itemPrice = double1;
		this.itemQuality = string2;
	}

	public Items(String string, double double1, String string2) {
		this.itemName = string;
		this.itemPrice = double1;
		this.itemQuality = string2;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemQuality() {
		return itemQuality;
	}

	public void setItemQuality(String itemQuality) {
		this.itemQuality = itemQuality;
	}

	public static int getReferenceID() {
		return referenceID;
	}

	public static void setReferenceID(int referenceID) {
		Items.referenceID = referenceID;
	}

}
