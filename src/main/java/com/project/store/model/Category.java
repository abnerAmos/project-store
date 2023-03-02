package com.project.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // @Transient Evita que este atributo seja inserido no Banco de dados
    @JsonIgnore /* Ignora o campo na construção do Json (caso não adc esta anotação, Será gerado um Looping pois
    * Categorias irá chamar Produtos e vice e versa sem fim. */
    @ManyToMany(mappedBy = "categories") // informa por qual atributo esta sendo mapeado mapeado
    private Set<Product> products = new HashSet<>(); // Set, Evita que a lista não possua produtos repetidos

    public Category () {

    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
