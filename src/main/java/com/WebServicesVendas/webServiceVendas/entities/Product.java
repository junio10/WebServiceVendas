package com.WebServicesVendas.webServiceVendas.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String descrisption;
	private Double price;
	private String imgUrl;
	@ManyToMany
	@JoinTable(name = "tb_products_category", 
	joinColumns = @JoinColumn(name="product_id"),
	inverseJoinColumns = @JoinColumn(name="category_id"))//define qual a outra chave estrangeira
	private Set<Category> categories = new HashSet<>();
	

	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();//a diferencao entre o "set" e p list
	                                                   //e que o set nao admitir repeticoes
	
	public Product() {
		
	}
	
	
	public Product(Long id, String name, String descrisption, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.descrisption = descrisption;
		this.price = price;
		this.imgUrl = imgUrl;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescrisption() {
		return descrisption;
	}
	public void setDescrisption(String descrisption) {
		this.descrisption = descrisption;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@JsonIgnore
	public Set<Order> getOrderProduct() {
		Set<Order> item = new HashSet<>();
		for(OrderItem x : items) {
			item.add(x.getOrder());
		}
		return item;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}


	public Set<Category> getCategories() {
		return categories;
	}
	
}
