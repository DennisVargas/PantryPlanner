package com.dvargas.pplanner.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
	<h1>Represents an item stored in the MongoDB database.</h1>
	<p>An item has a name, description, quantity, expiration date, and unique identifier (id).</p>
*/
@Data
@Document(collection = "items")
public class Item {

    @Id
    private String id;

    private String name;

    private String description;

    private int quantity;

    private Date expirationDate;
    
	/**
	 * Sets the name of this item.
	 * 
	 * @param name2 the name to set
	 * @throws IllegalArguementException if the name is null or empty
	 * */
	public void setName(String name2) {
		if (name2 == null || name2.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or empty.");
		}
		this.name = name2.trim();
		
	}
	
    /**
     * Gets the name of this item.
     * 
     * @return the name of this item
     */
	public String getName() {
		return this.name;
	}
	
    /**
     * Sets the description of this item.
     * 
     * @param description2 the description to set
     * @throws IllegalArgumentException if the description is null or empty
     */
	public void setDescription(String description2) {
        if (description2 == null || description2.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description2.trim();
	}
	
    /**
     * Gets the description of this item.
     * 
     * @return the description of this item
     */
	public String getDescription() {
		return this.description;
	}

    /**
     * Sets the quantity of this item.
     * 
     * @param quantity2 the quantity to set
     * @throws IllegalArgumentException if the quantity is negative
     */
	public void setQuantity(int quantity2) {
        if (quantity2 < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity2;
	}
	
    /**
     * Gets the quantity of this item.
     * 
     * @return the quantity of this item
     */
	public int getQuantity() {
		return this.quantity;
	}
	
    /**
     * Sets the expiration date of this item.
     * 
     * @param expirationDate2 the expiration date to set
     * @throws IllegalArgumentException if the expiration date is null or in the past
     */
	public void setExpirationDate(Date expirationDate2) {
        if (expirationDate2 == null || expirationDate2.before(new Date())) {
            throw new IllegalArgumentException("Expiration date cannot be null or in the past");
        }
        this.expirationDate = expirationDate2;
	}
	
    /**
     * Gets the expiration date of this item.
     * 
     * @return the expiration date of this item
     */
	public Date getExpirationDate() {
		return this.expirationDate;
	}
}