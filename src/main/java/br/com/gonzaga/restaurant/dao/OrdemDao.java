package br.com.gonzaga.restaurant.dao;

import br.com.gonzaga.restaurant.entity.Cliente;
import br.com.gonzaga.restaurant.entity.Ordem;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {

    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void register(final Ordem ordem) {
        this.entityManager.persist(ordem);
    }

    public Ordem consultById(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }

   public List<Ordem> consultAall(){
        String jpql = "SELECT c FROM Ordem c";
        return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
   }

    public void update(final Ordem ordem) {
        this.entityManager.merge(ordem);
    }

    public void delete(final Ordem ordem) {
        this.entityManager.remove(ordem);
    }

}


