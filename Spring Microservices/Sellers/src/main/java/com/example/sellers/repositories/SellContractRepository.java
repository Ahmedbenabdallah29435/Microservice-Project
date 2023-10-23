package com.example.sellers.repositories;


import com.example.sellers.domain.SellContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellContractRepository extends JpaRepository<SellContract, Integer> {

}
