package com.example.umc9th.domain.store.repository;

import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByLocationOrderByNameAsc(String location);
    boolean existsByNameAndDetailAddress(String name, String detailAddress);
}