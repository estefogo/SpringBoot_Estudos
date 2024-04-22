package io.github.rafaestefogo.domain.repository;

import io.github.rafaestefogo.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}