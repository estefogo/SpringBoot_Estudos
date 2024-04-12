package io.github.rafaestefogo.repository;

import io.github.rafaestefogo.domain.entity.ClientEntity;
import io.github.rafaestefogo.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findByClient(ClientEntity client);
}