package com.codechallenge.springboot.app.transactions.models.dao;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.codechallenge.springboot.app.transactions.models.entity.Transaction;



/***

 * Interface para Transacciones.

 * Nota: Esta claro que las interfaces no llevan implementación. Son un protocolo de métodos de comportamiento que tienen que implementar algunas clases para

 * cumplir con dicho contrato.

 * @author makadown

 */

public interface TransactionDao extends CrudRepository<Transaction, Long>{

    @Query("FROM Transaction ORDER BY ammount ASC")
    List<Transaction> findAllOrderByAmmountAsc();
    
    @Query("FROM Transaction ORDER BY ammount DESC")
    List<Transaction> findAllOrderByAmmountDesc();
    
    @Query("SELECT account FROM Transaction WHERE account=:accountValue")
    Transaction findByAccount(@Param("accountValue") String accountValue);

}