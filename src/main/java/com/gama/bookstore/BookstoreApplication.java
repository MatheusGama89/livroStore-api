package com.gama.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gama.bookstore.domain.Categoria;
import com.gama.bookstore.domain.Livro;
import com.gama.bookstore.repositories.CategoriaRepository;
import com.gama.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepositury;
	@Autowired
	private LivroRepository livroRepositury;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica", "livros");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martins","Lorem ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepositury.saveAll(Arrays.asList(cat1));
		this.livroRepositury.saveAll(Arrays.asList(l1));
		
		
	}
	
	

}
