package br.com.gonzaga.restaurant.useful;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUseful {

    private static final EntityManagerFactory RASFOOD = Persistence.createEntityManagerFactory("rasfood");

    public static EntityManager getEntityManagerRasFood(){
        return RASFOOD.createEntityManager();
    }
}
