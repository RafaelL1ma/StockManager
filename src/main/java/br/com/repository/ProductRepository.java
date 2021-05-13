package br.com.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	Product findById(long id);
}
