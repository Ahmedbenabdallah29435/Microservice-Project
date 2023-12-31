package com.example.sellers.repositories;


import com.example.sellers.domain.SellerOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerOfferRepository extends JpaRepository<SellerOffer, Integer> {
    List<SellerOffer> findByFavoriteTrue();
    @Query("SELECT o FROM SellerOffer o WHERE o.surface BETWEEN :minSurface AND :maxSurface")
    List<SellerOffer> findBySurfaceBetween(Double minSurface, Double maxSurface);


    @Query("SELECT p FROM SellerOffer p  ORDER BY p.price asc ")
    List<SellerOffer> findOffreByPriceASC();
}
