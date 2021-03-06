package az.developia.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.shopping.dao.OrderDAO;
import az.developia.shopping.dao.ProductDAO;
import az.developia.shopping.model.OrderModel;
import az.developia.shopping.model.Product;

@RestController
@RequestMapping(path="/products")
@CrossOrigin(origins="*")
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	@PostMapping
	public Product add(@RequestBody Product product){
	
	 return productDAO.save(product);
	
	}
	
	@PutMapping
	public Product update(@RequestBody Product product){
	
	 return productDAO.save(product);
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteById(@PathVariable Integer id){
	
	  productDAO.deleteById(id);
	}
	
	@GetMapping
	public List<Product> findAll(){
	
	 return productDAO.findAll();
	}
	
	
	@GetMapping(path="/{id}")
	public Product findById(@PathVariable Integer id){
	Optional<Product> p=productDAO.findById(id);
	Product product=null;
	if(p.isPresent()) {
		product=p.get();
	}
	 return product;
	}
	
	
	@GetMapping(path="/find-all/{username}")
	public List<Product> findAllByUsername(@PathVariable String username){
	return productDAO.findAllByUsername(username);
	
	
	
	
	}
	
	
	
	
	
	
}
