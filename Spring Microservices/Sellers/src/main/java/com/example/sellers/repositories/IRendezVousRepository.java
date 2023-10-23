package com.example.sellers.repositories;

import com.example.sellers.domain.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRendezVousRepository extends JpaRepository<RendezVous,Integer> {

}
