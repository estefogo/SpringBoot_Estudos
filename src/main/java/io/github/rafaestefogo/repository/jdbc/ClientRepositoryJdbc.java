package io.github.rafaestefogo.repository.jdbc;

import io.github.rafaestefogo.domain.entity.jdbc.ClientEntityJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepositoryJdbc {
    private static String INSERT = "insert into client (name, age) values (?, ?)";
    private static String SELECT_ALL = "select * from client";
    private static String UPDATE = "update client set name = ? where name = ?";
    private static String DELETE_BY_NAME = "delete from client where name = ?";
    private static String DELETE_BY_ID = "delete from client where id = ?";
    private static String FIND_BY_NAME = "select * from client where name like ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveClient(ClientEntityJdbc clientEntity) {
        jdbcTemplate.update(INSERT, clientEntity.getName(), clientEntity.getAge());
    }

    public List<ClientEntityJdbc> listClients() {
        return jdbcTemplate.query(SELECT_ALL, mapperFindClient());
    }

    public void updateClient(String name, String uptadeName) {
        jdbcTemplate.update(UPDATE, uptadeName, name);
    }

    public void deleteClientById(Integer id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }

    public void deleteClientByName(String nome) {
        jdbcTemplate.update(DELETE_BY_NAME, nome);
    }

    public List<ClientEntityJdbc> findByName(String name) {
        return jdbcTemplate.query(FIND_BY_NAME, new Object[]{"%" + name + "%"}, mapperFindClient());
    }

    private RowMapper<ClientEntityJdbc> mapperFindClient() {
        return new RowMapper<ClientEntityJdbc>() {
            @Override
            public ClientEntityJdbc mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                return new ClientEntityJdbc(id, name, age);
            }
        };
    }
}