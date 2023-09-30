package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Enities.Product;

public interface ProductServices {
	
	public Product addProduct(Product product);
	
	public List<Product> getProduct();
	
	public Optional<Product> getProductById(Long productId);
	
	public Product updateProduct(Product product,Long productId);
	
	public void deleteProduct(Long productid);

}
