package ro.ausy.jewelry.server.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ro.ausy.jewelry.commons.dto.ProductDTO;

/**
 * This class represents a PRODUCT database table.
 * @author cimre
 */
@Entity(name = "product")
public class Product implements Serializable {
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 2478654217L;
	
	/**
	 * This is the Product's ID number which represents the primary key of this table.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productId", updatable = false)
	private int productId;
	
	/**
	 * This is the name of the product.
	 */
	@Basic
	@Column(name = "productName")
	private String productName;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public ProductDTO asDTO() {
		return new ProductDTO(this.productId, this.productName);
	}
	

}
