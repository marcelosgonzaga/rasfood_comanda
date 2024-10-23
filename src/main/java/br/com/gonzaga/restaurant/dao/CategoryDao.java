package br.com.gonzaga.restaurant.dao;

import br.com.gonzaga.restaurant.entity.Category;

import javax.persistence.EntityManager;
//import javax.persistence.*;
import java.util.List;

public class CategoryDao {

    private EntityManager entityManager;

    public CategoryDao(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    public void register(final Category category) {
        this.entityManager.persist(category);
    }

    public Category consultById(final Integer id) {
        return this.entityManager.find(Category.class, id);
    }

   public List<Category> consultAall(){
        String jpql = "SELECT c FROM Category c";
        return this.entityManager.createQuery(jpql, Category.class).getResultList();
   }

    public void update(final Category category) {
        this.entityManager.merge(category);
    }

    public void delete(final Category category) {
        this.entityManager.remove(category);
    }

}
