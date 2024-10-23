package br.com.gonzaga.restaurant.dao;

import br.com.gonzaga.restaurant.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {

    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void register(final Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    public Cliente consultById(final Integer id) {
        return this.entityManager.find(Cliente.class, id);
    }

   public List<Cliente> consultAall(){
        String jpql = "SELECT c FROM Cliente c";
        return this.entityManager.createQuery(jpql, Cliente.class).getResultList();
   }

    public void update(final Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    public void delete(final Cliente cliente) {
        this.entityManager.remove(cliente);
    }

}


