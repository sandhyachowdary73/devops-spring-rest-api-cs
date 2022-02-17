package com.myapp.spring.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products2")

public class Products{
	
	@Id
	@Column(name="product_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productId;
	
	@Column(name="product_name",nullable=false)
	private String productName;
	
	@Column(name="product_review",nullable=false)
	private String productReview;
	
	@Column(name="product_Brand",nullable=false)
	private String productBrand;
	
	@Column(name="product_price",nullable=false)
	private Double productPrice;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(String productName, String productReview, String productBrand,
			Double productPrice) {
		this.productName = productName;
		this.productReview = productReview;
		this.productBrand = productBrand;
		this.productPrice = productPrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductReview() {
		return productReview;
	}

	public void setProductReview(String productReview) {
		this.productReview = productReview;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productBrand, productId, productName, productPrice, productReview);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Products))
			return false;
		Products other = (Products) obj;
		return Objects.equals(productBrand, other.productBrand) && Objects.equals(productId, other.productId)
				&& Objects.equals(productName, other.productName) && Objects.equals(productPrice, other.productPrice)
				&& Objects.equals(productReview, other.productReview);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productReview=");
		builder.append(productReview);
		builder.append(", ProductBrand=");
		builder.append(productBrand);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
