/**
 * 
 */
package com.mballem.demoajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mballem.demoajax.domain.Categoria;
import com.mballem.demoajax.repository.CategoriaRepository;

/**
 * @author andersonnogueira
 * @since Jul 18, 2019
 */
@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias(){
		return categoriaRepository.findAll(); 
	}
	
	@GetMapping("/add")
	public String abrirCadastro() {
		return "promo-add";
	}
}
