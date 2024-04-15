package io.github.rafaestefogo.repository;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> { //<(entidade do repositorio), (tipo do Id)>
    List<ClientEntity> findByNameContaining(String name);

    //usando o @Query, ele tambem eh valido pra fazer buscas no banco de dados, mas implementa o jpql (query manual)
    @Query("select c from ClientEntity c where c.name like :name")
    List<ClientEntity> findClientByNameQuery(@Param("name") String nameParam); //busca o cliente pelo nome

    @Query("select c from ClientEntity c left join fetch c.clientOrder where c.id = :id")
    ClientEntity findClientFetchOrders(@Param("id") Integer id); //busca o cliente e traz os pedidos dele junto

    @Query("select c from ClientEntity c join c.clientOrder o where o.id = :orderId") //busca o cliente de acordo com o id de um pedido atrelado a ele
    ClientEntity findClientByOrderIdFetchOrders(@Param("orderId") Integer orderId);
}