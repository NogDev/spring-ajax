/**
 * 
 */
package com.mballem.demoajax.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import com.mballem.demoajax.domain.Categoria;

/**
 * @author andersonnogueira
 * @since Jul 28, 2019
 * 
 * Esse padrão DTO é usado para editar parcialmente um objeto
 * onde alguns de seus atributos obrigatórios não farão parte 
 * do formulário de edição
 * 
 */
public class PromocaoDTO {
	@NotNull
	private Long id;
	
	@NotBlank(message = "Um texto é requerido")
	private String titulo;
	
	private String descricao;
	
	@NotNull(message = "O preço é requerido")
	@NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal preco;
	
	@NotNull(message = "Uma categoria é requerida")
	private Categoria categoria;
	
	private String linkImagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getLinkImagem() {
		return linkImagem;
	}

	public void setLinkImagem(String linkImagem) {
		this.linkImagem = linkImagem;
	}

}
