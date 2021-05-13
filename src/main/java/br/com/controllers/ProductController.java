package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.models.Product;
import br.com.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository pr;
	
	@RequestMapping(value = "/new-product", method = RequestMethod.GET)
	public String newProduct() {
		return "product/newProduct";
	}
	
	@RequestMapping(value = "/new-product", method = RequestMethod.POST)
	public String save(Product product) {
		pr.save(product);
		return "redirect:list-product";
	}
	
	@RequestMapping(value = "/list-product", method = RequestMethod.GET)
	public ModelAndView listProduct() {
		ModelAndView mv = new ModelAndView("product/listProduct");
		Iterable<Product> product = pr.findAll();
		mv.addObject("product", product);
		return mv;
	}
	@RequestMapping(value = "delete-product/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") long id) {
		Product product = pr.findById(id);
		pr.delete(product);
		return "redirect:/list-product";
	}
	
	@RequestMapping(value = "/update-product/{id}", method = RequestMethod.GET)
	public ModelAndView updateProduct(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("product/updateProduct");
		Product product = pr.findById(id);
		mv.addObject("product", product);
		return mv;
	}
	
	@RequestMapping(value = "/update-product/{id}", method = RequestMethod.POST)
	public String updateProductPost(@PathVariable("id") long id, Product product) {
		pr.save(product);
		return "redirect:/list-product";
	}
}
