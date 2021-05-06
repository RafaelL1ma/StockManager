package br.com.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.models.User;

public interface UserRepository extends CrudRepository<User, Long> {	
	
}
