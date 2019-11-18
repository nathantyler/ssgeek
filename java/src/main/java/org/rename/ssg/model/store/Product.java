package org.rename.ssg.model.store;

import java.util.Objects;

public class Product {

	private Long id;
	private String name;
	private String description;
	private DollarAmount price;
	private String imageName;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DollarAmount getPrice() {
		return price;
	}

	public void setPrice(DollarAmount price) {
		this.price = price;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getPriceOfMultiples(Integer amount) {
		DollarAmount total = DollarAmount.ZERO_DOLLARS;
		int n = amount.intValue();
		for (int i = 1; i <= n; i++)
			total = total.plus(getPrice());
		return total.toString();
	}
	
	/* 
	 * Overriding Product.equals and Product.hashCode so that our ShoppingCart class
	 * can add the same product (not necessarily the same product reference, product1 != product2,
	 * but product1.getId() == product2.getId()) and the cart will know to add to the number of that product
	 * that is already in the cart rather than make a new cart key/value pair. (I would thing hashCode would
	 * be more important for HashMaps, but it doesn't hurt to override both, just in case.) 
	 * */

	@Override
	public boolean equals(Object o) {

		if (o == this)
			return true;
		if (!(o instanceof Product))
			return false;

		Product prod = (Product) o;
		
		/* 
		 * Since products are populated from a database and id is a primary key
		 * testing that two products ids match suffices for equality in this situation.
		 * It would be very easy to be more stringent about equality, but it really would be 
		 * overkill at this point. Maybe in some other situation. 
		 * */ 
		return this.getId() == prod.getId();
	}

	@Override
	public int hashCode() {
		/* 
		 * This should be more than sufficient to uniquely identify a product
		 * based on the database from where these products are pulled.  
		 * */
		return Objects.hash(this.id, this.name);
	}

}
