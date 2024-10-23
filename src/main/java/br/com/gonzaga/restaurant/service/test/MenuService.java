package br.com.gonzaga.restaurant.service.test;

import br.com.gonzaga.restaurant.dao.MenuDao;
import br.com.gonzaga.restaurant.useful.JPAUseful;
import br.com.gonzaga.restaurant.useful.Payload;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class MenuService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUseful.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        Payload.registerCategories(entityManager);
        Payload.registerProductMenu(entityManager);
        MenuDao menuDao = new MenuDao(entityManager);
        System.out.println("O produto pesquisado foi: "+
                menuDao.consultforName("Moqueca"));
        entityManager.close();

    }

}
