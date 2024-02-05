package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	private Product product;
	
	public OrderItem() {
		
	}
	
	public OrderItem (Integer quantity, Double price, Product product) {
		setQuantity(quantity);
		setPrice(price);
		setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double subTotal() {
		return getQuantity() * getPrice();
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(product.getName() + ", ");
		sb.append( "R$: " + getPrice() + ", ");
		sb.append("Quantity: " + getQuantity() + ", ");
		sb.append("Subtotal: " + String.format("%.2f", subTotal()));
		
		return sb.toString();
		
	}
}
