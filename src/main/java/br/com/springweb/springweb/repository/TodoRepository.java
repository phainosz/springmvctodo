package br.com.springweb.springweb.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.springweb.springweb.model.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long>{

}
