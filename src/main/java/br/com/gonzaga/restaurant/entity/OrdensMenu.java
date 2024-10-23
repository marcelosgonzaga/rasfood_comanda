package br.com.gonzaga.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ordens_menu")
public class OrdensMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Menu menu;

    @Column(name = "Valor_de_registro")
    private BigDecimal valueRegister;

    private Integer amount;
    @ManyToOne
    private Ordem ordem;



    public OrdensMenu(Ordem ordem, Menu menu, Integer amount ) {
        this.ordem = ordem;
        this.menu = menu;
        this.amount = amount;
        this.valueRegister = menu.getValue();
    }

    public OrdensMenu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public BigDecimal getValue() {
        return valueRegister;
    }

    public void setValue(BigDecimal value) {
        this.valueRegister = value;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    @Override
    public String toString() {
        return "OrdensMenu{" +
                "id=" + id +
                ", menu=" + menu +
                ", valueRegister=" + valueRegister +
                ", amount=" + amount +
                '}';
    }
}
