package com.niit.dao;
import java.util.List;
import com.niit.model.Product;


public interface ProductDAO 
{

	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public List<Product> retrieveProducts();
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);

}
