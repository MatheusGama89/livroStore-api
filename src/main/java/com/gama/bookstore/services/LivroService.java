package com.gama.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gama.bookstore.domain.Categoria;
import com.gama.bookstore.domain.Livro;
import com.gama.bookstore.repositories.LivroRepository;
import com.gama.bookstore.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public Livro findById(Integer id){
		Optional<Livro> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!: " + id + ", Tipo: " + Categoria.class.getName()));

	}

}
