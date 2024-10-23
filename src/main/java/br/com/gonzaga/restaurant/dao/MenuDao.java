package br.com.gonzaga.restaurant.dao;

import br.com.gonzaga.restaurant.entity.Menu;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class MenuDao {

    private EntityManager entityManager;

    public MenuDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    /*
     * CRUD
     * CREATE
     * READ
     * UPDATE
     * DELETE
     * */


    public void register(final Menu menu) {

        this.entityManager.persist(menu);
    }

    public Menu consultById(final Integer id) {

        return this.entityManager.find(Menu.class, id);
    }

    public Menu consultforName(final String filtro) {
        try {
            String jpql = "SELECT c FROM Menu c WHERE UPPER(c.name) = UPPER(:name)";
            return this.entityManager.createQuery(jpql, Menu.class).setParameter(
                    "name", filtro).getSingleResult();
        } catch (Exception e) {
             System.out.println("nada encontrado");
            return null;
        }
    }

    public List<Menu> checkValue(final BigDecimal filtro) {
        try {
            String jpql = "SELECT c FROM Menu c WHERE c.value = :value";
            return this.entityManager.createQuery(jpql, Menu.class).setParameter(
                    "value", filtro).getResultList();

        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Menu> consultAll() {
        try {
            String jpql = "SELECT c FROM Menu c";
            return this.entityManager.createQuery(jpql, Menu.class).getResultList();

        } catch (Exception e) {
            return Collections.emptyList();
        }

    }

    public void update(final Menu menu) {
        this.entityManager.merge(menu);
    }

    public void delete(final Menu menu) {
        this.entityManager.remove(menu);
    }


}
