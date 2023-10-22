package com.example.techmasterpi.service;

import com.example.techmasterpi.domain.RentalContract;
import com.example.techmasterpi.domain.User;
import com.example.techmasterpi.model.RentalContractDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface IRentalContract {

    int addRentalContract(RentalContract rentalContract, int userId,int rentalOfferId)throws MessagingException;
    boolean updateRentalContract(RentalContract rentalContract);
    boolean deleteRentalContract(int id);
    public RentalContractDTO getById(final Integer contractid);
    public List<RentalContractDTO> findAll();
  //  List<RentalContract> getAll();
    double getChiffreAffaireByUser(int userId);
    public void exportcontrat(  int idContrat, String filePath) throws IOException;

    public void rappelFinContrat() throws MessagingException;
    public Charge createCharge(String token, int amount, String currency, int idcontract) throws StripeException;
}
