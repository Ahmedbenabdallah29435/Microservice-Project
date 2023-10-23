package com.example.sellers.services;

import com.example.sellers.domain.SellContract;
import com.example.sellers.model.SellContractDTO;

import java.util.List;

public interface IContratService {
    public void ajouterContrat (SellContract sellerContrat, int user_id, int sellid);



    public void updateContrat (SellContract contract);
    void deleteContrat(int id);
public SellContractDTO get(final Integer contractsellid);
public List<SellContractDTO> findAll();


}
