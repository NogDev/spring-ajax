/**
 * 
 */
package com.mballem.demoajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mballem.demoajax.domain.Categoria;

/**
 * @author andersonnogueira
 * @since Jul 18, 2019
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
