package com.example.main.controller;

import com.example.main.model.Product;
import com.example.main.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String test(){
		return "Testing";
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
	}

	@PostMapping("/product")
	public String addProduct(@RequestBody Product product){
		productService.addProduct(product);
		return "Product Added!!";
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductUsingId(@PathVariable int id){
		Product product = productService.getProductById(id);
		if(product.getName() != null)
			return new ResponseEntity<>(product, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}



}
