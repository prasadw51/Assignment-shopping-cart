package com.assignment.controller;

import com.assignment.entity.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProdController {

	static {

	}
	@Autowired
	ProductRepository prodrepo;

	@GetMapping("/getallproducts")
	public List<Product> getAllProduct() {
		return prodrepo.findAll();
	}

	@GetMapping("/search/{price}")
	public List<Product> getAllProductByPrice(@PathVariable("price") long price) {
		return prodrepo.findByPrice(price);
	}

	@GetMapping("/search/{product}")
	public List<Product> getAllProductByProduct(@PathVariable("product") String product) {
		return prodrepo.findByPname(product);
	}

	@GetMapping("/search/{type}")
	public List<Product> getAllProductByType(@PathVariable("type") String productType) {
		return prodrepo.findByType(productType);
	}

	@GetMapping("/search/p")
	public List<Product> getAllProduct(Product product) {
		return prodrepo.findByPnameOrPriceOrType(product.getPname(), product.getPrice(), product.getType());
	}

	@PostMapping("/saveproduct")
	public Product addProduct(Product p) {
		return prodrepo.save(p);
	}

	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product p) {
		Product product = prodrepo.getById(p.getPid());
		if(product!=null) {
		product.setPname(p.getPname());
		product.setCat(p.getCat());
		product.setPrice(p.getPrice());
		product.setType(p.getType());
		return prodrepo.save(product);
		}
		return null;
	}

	@DeleteMapping("/delete/{pid}")
	public void removeProduct(@PathVariable("pid") long pid) {
		prodrepo.deleteById(pid);
	}

}
