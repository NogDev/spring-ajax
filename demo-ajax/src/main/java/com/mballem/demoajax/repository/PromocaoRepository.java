/**
 * 
 */
package com.mballem.demoajax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mballem.demoajax.domain.Promocao;

/**
 * @author andersonnogueira
 * @since Jul 18, 2019
 */
public interface PromocaoRepository extends JpaRepository<Promocao, Long>{
	@Transactional(readOnly=false)
	@Modifying
	@Query("update Promocao p set p.likes = p.likes + 1 where p.id = :id")
	void updateSomarLikes(@Param("id") Long id );
	
	@Query("select p.likes from Promocao p where p.id = :id")
	int findLikesById(@Param("id") Long id );
}
