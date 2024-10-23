package br.com.gonzaga.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "data_de_criacao")
    private LocalDateTime dataDeCriacao = LocalDateTime.now();

    @ManyToOne
    private Cliente cliente;
    /*
    * ALL = Realiza toas as operações em cascata
    * DETACH = Operação detach excuta no pai e no filho
    * MERG = Salva pai e filho, podendo já haver a entidade gerênciada
    * PERSIST = Cria pai e filho
    * REFRESH = Atualiza entidade com operações do banco
    * REMOVE = Proga remoção entre pai filho
     */
    @OneToMany(mappedBy = "ordem",cascade = CascadeType.ALL)
    private List<OrdensMenu> ordensMenuList = new ArrayList<>();

    //construtor vazio obrigatório pela JPA
    public Ordem() {
    }

    public void addOrdensMenu(OrdensMenu ordensMenu){
        ordensMenu.setOrdem(this);
        this.ordensMenuList.add(ordensMenu);
    }

    public Ordem(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<OrdensMenu> getOrdensMenuList() {
        return ordensMenuList;
    }

    public void setOrdensMenuList(List<OrdensMenu> ordensMenuList) {
        this.ordensMenuList = ordensMenuList;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataDeCriacao=" + dataDeCriacao +
                ", cliente=" + cliente +
                ", ordensMenuList=" + ordensMenuList +
                '}';
    }
}
// @ManyToMany
//    @JoinTable(
//            name = "oredens_cardapio",
//            joinColumns = @JoinColumn(name = "ordens_id"),
//            inverseJoinColumns = @JoinColumn(name = "cardapio_id")
//    )
//