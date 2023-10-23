package com.example.sellers.repositories;

import com.example.sellers.domain.OffreFavorit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferFavoriteRepository extends JpaRepository<OffreFavorit,Integer> {
}
