package io.github.rafaestefogo.domain.repository;

import io.github.rafaestefogo.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}