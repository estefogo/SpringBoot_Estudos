package io.github.rafaestefogo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "client")//so precisa usar essa annotation se o nome da entidade for diferente do nome na tabela (se o nome da tabela for ClientEntity por exemplo nao precisa)
public class ClientEntity {
    @Id //define a primary key de uma entidade (campo obrigatorio)
    @GeneratedValue(strategy = GenerationType.AUTO) //mesma coisa que o auto_increment -- precisa especificar a estrategia do valor
    @Column(name = "id") //nao precisa colocar essa annotation se for o mesmo nome do campo na aplicacao e no banco de dados
    private Integer id;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY) //o mappedBy indica qual campo da CLASSE ATUAL esta sendo usado pro mapeamento na CLASSE RELACIONADA
    private Set<OrderEntity> clientOrder; //o Set eh uma coleçao que garante que nao havera elementos duplicados

    public Set<OrderEntity> getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(Set<OrderEntity> clientOrder) {
        this.clientOrder = clientOrder;
    }

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public ClientEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public ClientEntity() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id='" + id + "," +
                '\'' + "name='" + name + '\'' +
                '\'' + "age='" + age +
                '}';
    }
}