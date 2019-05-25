package com.paf.paf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {
	
	@Autowired
    private BuyerService buyerService;

    @GetMapping(value = "/utils/buyers",params = "buyer_code")
    public ResponseEntity<Buyer> getBuyerByBuyerCode (@RequestParam(name = "buyer_code") String buyerCode){
        return new ResponseEntity<>(buyerService.getBuyerByBuyerCode(buyerCode), HttpStatus.OK);
    }


// Get mapping for user login

    @GetMapping(value = "/utils/buyers",params = "buyer_email")
    public ResponseEntity<Buyer> getBuyerByBuyerEmail (@RequestParam(name = "buyer_email") String buyerEmail){
        return new ResponseEntity<>(buyerService.getBuyerByBuyerEmail(buyerEmail), HttpStatus.OK);
    }

    @GetMapping("/utils/buyers")
    public ResponseEntity<List<Buyer>> getAllBuyers(){
        return new ResponseEntity<>(buyerService.getAllBuyers(), HttpStatus.OK);
    }

    @PostMapping("/utils/buyers")
    public ResponseEntity<Buyer> createBuyer (@RequestBody Buyer buyer){
        return new ResponseEntity<>(buyerService.createBuyer(buyer), HttpStatus.OK);
    }

    @PutMapping("/utils/buyers/{id}")
    public ResponseEntity <Buyer> updateBuyer (@PathVariable int id, @RequestBody Buyer buyer){
        return new ResponseEntity<Buyer>(buyerService.updateBuyer(id, buyer), HttpStatus.OK);
    }

    @DeleteMapping("/utils/buyers/{id}")
    public ResponseEntity<Buyer> deleteBuyer (@PathVariable int id){
        buyerService.deleteBuyer(id);
        return new ResponseEntity<Buyer>(HttpStatus.OK);
    }


}
