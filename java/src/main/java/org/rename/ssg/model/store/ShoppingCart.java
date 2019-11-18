package org.rename.ssg.model.store;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	
	Map<Product, Integer> cart;

	/**
	 * 
	 */
	public ShoppingCart() {
		cart = new HashMap<>();
	}

	/**
	 * @return the cart
	 */
	public Map<Product, Integer> getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Map<Product, Integer> cart) {
		this.cart = cart;
	}
	
	public void addToCart(Product product, Integer quantity) {
		cart.put(product, cart.getOrDefault(product, Integer.valueOf(0)) + quantity);
	}
	
	public DollarAmount getTotal() {
		DollarAmount total = new DollarAmount(0);
		for (Map.Entry<Product, Integer> item : cart.entrySet())
			total = total.plus(multiplyNDollarAmounts(item.getKey().getPrice(), item.getValue()));
		return total;
	}
	
	public DollarAmount multiplyNDollarAmounts(DollarAmount amount, Integer times) {
		int n = times.intValue();
		DollarAmount product = DollarAmount.ZERO_DOLLARS;
		for (int i = 1; i <= n; i++)
			product = product.plus(amount);
		return product;
	}
	
	public String getTotalAsString() {
		return getTotal() != null ? getTotal().toString() : "$0.00";
	}
}
