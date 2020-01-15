package ro.ausy.jewelry.commons.dto;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

/**
 * This is the Data Transfer Object for <code>Product</code> object.
 * @author cimre
 *
 */
@Repository
public class ProductDTO implements Serializable {
	
	/**
	 * UID
	 */
	private static final long serialVersionUID = 21478745687L;
	
	/**
	 * This is the Product's ID number which represents the primary key of this table.
	 */
	private int productDTOId;
	
	/**
	 * This is the productName that accesses the application.
	 */
	private String productName;

	public int getProductDTOId() {
		return productDTOId;
	}

	public void setProductDTOId(int productDTOId) {
		this.productDTOId = productDTOId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(int productDTOId, String productName){
		super();
		this.productDTOId = productDTOId;
		this.productName = productName;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productDTOId +", productName= " + productName + "]";
	}
}
