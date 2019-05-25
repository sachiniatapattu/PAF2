package com.paf.paf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController {
	
//  @Autowired
//  SellerService sellerService;

  @GetMapping(value = "/utils/login", params = {"requesting_email","requesting_password"})
  public Map<String, Object>getUserIfAvailableInSellerOrBuyer(@RequestParam(name = "requesting_email")String requestingEmail,
                                                                 @RequestParam(name = "requesting_password")String requestingPassword){

      System.out.println("LOGIN CONTROLLER - GET USER IF AVAILABLE - Req Email : "+ requestingEmail + ", Req Pass: "+ requestingPassword);
      final String uri = "http://localhost:8000/utils/buyers?buyer_email="+requestingEmail;
      RestTemplate restTemplate = new RestTemplate();
     // String resultBuyersString = restTemplate.getForObject(uri, String.class);
      Buyer resultBuyer = restTemplate.getForObject(uri, Buyer.class);
      if (resultBuyer == null) {
          System.out.println("LOGIN CONTROLLER - No such Email present in Buyers");
//          Map<String, Object> responseMap = new HashMap<>();
//          responseMap.put("error", "No Such email present");
//          return responseMap;
      } else {
          System.out.println("LOGIN CONTROLLER - Result buyer's Password : "+resultBuyer.getBuyerPassword());
          if (resultBuyer.getBuyerPassword().equals(requestingPassword)){
              Map<String, Object> responseMap = new HashMap<>();
              responseMap.put("error", null);
              responseMap.put("buyer_id", resultBuyer.getId());
              responseMap.put("type", "buyer");
              return responseMap;
          } else {
              Map<String, Object> responseMap = new HashMap<>();
              responseMap.put("error", "Invalid Password");
              responseMap.put("buyer_id", null);
              return responseMap;
          }
      }

      //System.out.println("LOGIN CONTROLLER - Result buyers : "+resultBuyersString);

      final String uri2 = "http://localhost:8000/utils/sellers";
      RestTemplate restTemplate2 = new RestTemplate();
      restTemplate2.getForObject(uri2, String.class);

      //return new ResponseEntity<>(sellerService.getSellerBySellerCode(requestingEmail), HttpStatus.OK);
      Map<String, Object> responseMap = new HashMap<>();
      responseMap.put("error", "Email Not found");
      //return new ResponseEntity<>(responseMap, HttpStatus.OK);
      return responseMap;
  }

}
