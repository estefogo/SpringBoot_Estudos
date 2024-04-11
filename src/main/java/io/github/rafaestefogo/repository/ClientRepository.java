package io.github.rafaestefogo.repository;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> { //<(entidade do repositorio), (tipo do Id)>
    List<ClientEntity> findByNameContaining(String name);

    //metodo que tambem eh valido pra fazer buscas no banco de dados, mas que implementa o jpql (query manual)
    @Query("select c from ClientEntity c where c.name like :name")
    List<ClientEntity> findClientByNameQuery(@Param("name") String nameParam);
}