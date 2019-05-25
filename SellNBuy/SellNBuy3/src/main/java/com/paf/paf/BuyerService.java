package com.paf.paf;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> getAllBuyers(){
        return buyerRepository.findAll();
    }

    public Buyer getBuyerByBuyerCode (String buyerCode){
        return buyerRepository.findBuyerByBuyerCode(buyerCode);
    }

    public Buyer getBuyerByBuyerEmail (String buyerEmail){
        return buyerRepository.findBuyerByBuyerEmail(buyerEmail);
    }

    public Buyer createBuyer(Buyer buyer){
        return buyerRepository.save(buyer);
    }

    public Buyer updateBuyer(int id, Buyer buyerDetails){
        Buyer buyer = buyerRepository.findBuyerById(id);

        buyer.setBuyerCode(buyerDetails.getBuyerCode());
        buyer.setBuyerName(buyerDetails.getBuyerAddress());
        buyer.setBuyerNumber(buyerDetails.getBuyerDate());
        buyer.setBuyerEmail(buyerDetails.getBuyerPassword());

        return buyerRepository.save(buyer);
    }

    public void deleteBuyer(int id){
        buyerRepository.deleteBuyerById(id);
    }
}
