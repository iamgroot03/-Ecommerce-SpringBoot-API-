package com.example.demo.serviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Enities.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductServices;

@Service
public class ProductServiceImple implements ProductServices{
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		productRepository.save(product);
		return product;
	}

	@Override
	public List<Product> getProduct() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(Long productId) {
		return productRepository.findById(productId);
	}

	@Override
	public Product updateProduct(Product product, Long productId) {
		productRepository.findById(productId);
		productRepository.save(product);
		return product;
	}

	@Override
	public void deleteProduct(Long productid) {
		Product  product=productRepository.getOne(productid);
		productRepository.delete(product);	
	}

}
