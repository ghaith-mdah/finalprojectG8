package logic;

import java.io.Serializable;

public class Item implements Serializable{

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	public Item(Integer id, String name, String type, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String type;
	private Double price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
	

