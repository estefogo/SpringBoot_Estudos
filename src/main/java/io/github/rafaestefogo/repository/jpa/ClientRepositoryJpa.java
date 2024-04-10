package io.github.rafaestefogo.repository.jpa;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepositoryJpa {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    //todos os metodos do EntityManager precisam ser anotados assim, pois precisam gerar uma transaçao na base de dados
    public void saveClient(ClientEntity clientEntity) {
        entityManager.persist(clientEntity);
    }

    @Transactional
    public void updateClient(ClientEntity clientEntity) {
        entityManager.merge(clientEntity); //da um merge com o objeto armazenado anteriormente e o novo
    }

    @Transactional
    public void deleteClientById(Integer id) {
        entityManager.remove(entityManager.find(ClientEntity.class, id));
    }

    /*@Transactional
    public void deleteClientByName(String name) {
        entityManager.remove(findByName(name));
    }*/

    @Transactional(readOnly = true)
    public List<ClientEntity> findByName(String name) {
        String jpql = "select c from ClientEntity c where c.name like :name";
        TypedQuery<ClientEntity> query =  entityManager.createQuery(jpql, ClientEntity.class); //o TypedQuery especifica que o retorno tem que ser do tipo ClientEntity
        query.setParameter("name", "%" + name + "%");
        return  query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<ClientEntity> listClients() {
        return entityManager
                .createQuery("from ClientEntity", ClientEntity.class)
                .getResultList();
    }
}