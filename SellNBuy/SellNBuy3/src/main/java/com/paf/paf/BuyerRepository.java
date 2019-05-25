package com.paf.paf;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

    public Buyer findBuyerByBuyerCode(String BuyerCode);
    public Buyer findBuyerByBuyerEmail(String BuyerEmail);
    public void deleteBuyerById(int id);
    public Buyer findBuyerById(int id);
}