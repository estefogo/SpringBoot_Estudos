package io.github.rafaestefogo.domain.entity.jdbc;

public class ClientEntityJdbc {
    private Integer id;
    private String name;
    private int age;

    public ClientEntityJdbc(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public ClientEntityJdbc(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public ClientEntityJdbc() {
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
                '}';
    }
}
