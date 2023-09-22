package com.TastyTreks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TastyTreks.Service.ProductService;
import com.TastyTreks.pojos.Products;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	

	@GetMapping("/allproducts")
	public List<Products> getAdminProducts() {

		return productService.Allproducts();
	}

	@PostMapping("/save")
	public String aveproducts(@RequestBody Products pr ) {
		 return productService.saveprodu(pr);
		
	}
	
	@PutMapping("/update/{id}")
	public Products update(@PathVariable long id,@RequestBody Products pr) {
		return productService.updateproduct(id,pr);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		productService.deleteproduct(id);
		return "successfully deleted";
	}
	
	@GetMapping("/search")
	public List<Products> productSearch(@RequestBody String s)
	{
		return productService.productSearch(s);
		
	}
	
	@GetMapping("/search/{id}")
	public Products productSerach(@PathVariable long id){
		return productService.productSerach(id);
	}
} 