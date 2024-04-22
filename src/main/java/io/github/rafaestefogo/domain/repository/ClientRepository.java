package io.github.rafaestefogo.domain.repository;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> { //<(entidade do repositorio), (tipo do Id)>
}