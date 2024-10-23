package br.com.gonzaga.restaurant.service.test;

import br.com.gonzaga.restaurant.dao.ClienteDao;
import br.com.gonzaga.restaurant.dao.MenuDao;
import br.com.gonzaga.restaurant.dao.OrdemDao;
import br.com.gonzaga.restaurant.entity.Cliente;
import br.com.gonzaga.restaurant.entity.Endereco;
import br.com.gonzaga.restaurant.entity.Ordem;
import br.com.gonzaga.restaurant.entity.OrdensMenu;
import br.com.gonzaga.restaurant.useful.JPAUseful;
import br.com.gonzaga.restaurant.useful.Payload;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUseful.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        Payload.registerCategories(entityManager);
        Payload.registerProductMenu(entityManager);

        MenuDao menuDao = new MenuDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Endereco endereco = new Endereco("0000000", "rua 20", "depois da ", "Vga", "MG");
        Cliente felipe = new Cliente("11111111111", "Felipe");
        felipe.addEndereco(endereco);
        Ordem ordem = new Ordem(felipe);
        ordem.addOrdensMenu(new OrdensMenu(ordem,menuDao.consultById(1),2));
        clienteDao.register(felipe);
        ordemDao.register(ordem);
        System.out.println(ordem);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
