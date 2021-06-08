package com.udemy.projeto.spring;

import com.udemy.projeto.spring.domain.Categoria;
import com.udemy.projeto.spring.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria("Informática");
		Categoria cat2 = new Categoria("Escritório");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}
