package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Enities.Product;
import com.example.demo.Enities.User;
import com.example.demo.services.ProductServices;

@RestController
@RequestMapping("/homes")
public class ProductContaroller {
	
	@Autowired
	private ProductServices productServices;
	
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return this.productServices.addProduct(product);
		
	}
	
	@GetMapping("/allproduct")
	public List<Product> getProducts(){
		return this.productServices.getProduct();
	}
	
	@PutMapping("/product/{productId}")
	public ResponseEntity<Product> updateProductById(@PathVariable String productId,@RequestBody Product product) {
	    this.productServices.updateProduct(product, Long.parseLong(productId));
	    return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<HttpStatus>deleteProduct(@PathVariable String productId){
		try {
			this.productServices.deleteProduct(Long.parseLong(productId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/product/{productId}")
	public Optional<Product> getProductById(@PathVariable String productId) {
		return this.productServices.getProductById(Long.parseLong(productId));
	}

}
