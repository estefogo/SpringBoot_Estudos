package io.github.rafaestefogo.repository;

import io.github.rafaestefogo.domain.entity.ItemOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, Integer> {
}
