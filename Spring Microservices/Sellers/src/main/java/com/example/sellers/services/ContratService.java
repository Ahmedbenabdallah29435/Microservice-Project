package com.example.sellers.services;

import com.example.sellers.domain.SellContract;
import com.example.sellers.domain.SellerOffer;
import com.example.sellers.domain.User;
import com.example.sellers.model.SellContractDTO;
import com.example.sellers.repositories.SellContractRepository;
import com.example.sellers.repositories.SellerOfferRepository;

import com.example.sellers.repositories.UserRepository;
import com.example.sellers.utils.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class    ContratService implements IContratService{
    @Autowired
    private SellContractRepository sellContractRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SellerOfferRepository sellerOfferRepository;




    @Override
    public void ajouterContrat(SellContract sellerContrat,int user_id,int sellid)  {
        User u=userRepository.findById(user_id).get();
        sellerContrat.setUserContractsale(u);
        SellerOffer v=sellerOfferRepository.findById(sellid).get();
        sellerContrat.setContractSell(v);
        sellerContrat.setPrice(v.getPrice());

        sellContractRepository.save(sellerContrat);

    }

    @Override
    public void updateContrat(SellContract contract) {
        if (sellContractRepository.findById(contract.getContractsellid()).isPresent())
            sellContractRepository.save(contract);
        else
            System.out.println("doesnt exist");

    }

    @Override
    public void deleteContrat(int id) {
        sellContractRepository.deleteById(id);

    }
    public SellContractDTO get(final Integer contractsellid) {
        return sellContractRepository.findById(contractsellid)
                .map(sellContract -> mapToDTO(sellContract, new SellContractDTO()))
                .orElseThrow(NotFoundException::new);
    }


    public List<SellContractDTO> findAll() {
        final List<SellContract> sellContracts = sellContractRepository.findAll(Sort.by("contractsellid"));
        return sellContracts.stream()
                .map((sellContract) -> mapToDTO(sellContract, new SellContractDTO()))
                .collect(Collectors.toList());
    }




    private SellContractDTO mapToDTO(final SellContract sellContract,
                                     final SellContractDTO sellContractDTO) {
        sellContractDTO.setContractsellid(sellContract.getContractsellid());
        sellContractDTO.setPrice(sellContract.getPrice());
        sellContractDTO.setSelldate(sellContract.getSelldate());
        sellContractDTO.setContractSell(sellContract.getContractSell() == null ? null : sellContract.getContractSell().getSellid());
        sellContractDTO.setUserContractsale(sellContract.getUserContractsale() == null ? null : sellContract.getUserContractsale().getUserid());
        return sellContractDTO;
    }

    private SellContract mapToEntity(final SellContractDTO sellContractDTO,
                                     final SellContract sellContract) {
        sellContract.setPrice(sellContractDTO.getPrice());
        sellContract.setSelldate(sellContractDTO.getSelldate());
        final SellerOffer contractSell = sellContractDTO.getContractSell() == null ? null : sellerOfferRepository.findById(sellContractDTO.getContractSell())
                .orElseThrow(() -> new NotFoundException("contractSell not found"));
        sellContract.setContractSell(contractSell);
        final User userContractsale = sellContractDTO.getUserContractsale() == null ? null : userRepository.findById(sellContractDTO.getUserContractsale())
                .orElseThrow(() -> new NotFoundException("userContractsale not found"));
        sellContract.setUserContractsale(userContractsale);
        return sellContract;
    }

}
