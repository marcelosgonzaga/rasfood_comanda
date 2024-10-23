package br.com.gonzaga.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Boolean availiable;
    private BigDecimal value;

    /*
     * ManyToOne
     * ManyToMany
     * OneToMany
     * OneToOne
     * */
    @ManyToOne
    private Category category;

//    @ManyToMany(mappedBy = "menuList")
//    private List<Ordem>ordemList;

    @Column(name = "registration_data")
    private LocalDateTime registrationDate = LocalDateTime.now();


    public Menu(String name, String description, Boolean availiable, BigDecimal value, Category category) {
        this.name = name;
        this.description = description;
        this.availiable = availiable;
        this.value = value;
        this.category = category;
        //this.registrationDate = registrationDate; , LocalDateTime registrationDate
    }

    public Menu() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailiable() {
        return availiable;
    }

    public void setAvailiable(Boolean availiable) {
        this.availiable = availiable;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Menu(Integer id, String name, String description, Boolean availiable, BigDecimal value, LocalDateTime registrationDate, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.availiable = availiable;
        this.value = value;
        this.registrationDate = registrationDate;
        this.category = category;
    }

    //metodo para exibição de dados em string
    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", availiable=" + availiable + ", value=" + value + ", category=" + category + ", registrationDate=" + registrationDate + '}';
    }
}
