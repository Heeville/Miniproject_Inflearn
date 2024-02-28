package com.preproject.inflearnhomework.domain.fruit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Fruit2Repository extends JpaRepository<Fruit2,Long> {

    Optional<Fruit2> findById(Long id);
    boolean existsByName(String name);

    List<Fruit2> findAllByNameAndSales(String name, boolean sales);

    List<Fruit2> findAllByName(String name);

    List<Fruit2> findAllByPriceGreaterThanEqual(long price);

    List<Fruit2> findAllByPriceLessThanEqual(long price);

}
