package facade.collection.creditcard;

import paymentinfodto.PaymentInformationDTO;

import java.math.BigDecimal;

public class CreditCardService {
    private  CreditCardControlService creditCardControlService;

    public CreditCardService(){
        creditCardControlService = new CreditCardControlService();
    }
    public boolean tryCollectingFromCreditCard(PaymentInformationDTO paymentInformationDTO, BigDecimal amountOfPaid){
       boolean creditCardValid= creditCardControlService.isCreditCardValid(paymentInformationDTO);
       if (!creditCardValid){
           return false;
       }
       boolean limitEnough = isLimitEnough(paymentInformationDTO,amountOfPaid);
       if (!limitEnough){
           return  false;
       }
        System.out.println(amountOfPaid +"TL was charged on credit card");
       return  true;
    }

    private boolean isLimitEnough(PaymentInformationDTO paymentInformationDTO, BigDecimal amountOfPaid) {

      BigDecimal limit = getCreditCardLimit(paymentInformationDTO);
      boolean limitEnough = limit.compareTo(amountOfPaid)> 0;
      if (!limitEnough){
          System.out.println("Limit is not enough");
      }
       return  limitEnough;
    }

    private BigDecimal getCreditCardLimit(PaymentInformationDTO paymentInformationDTO) {
        BigDecimal limit = BigDecimal.ZERO;
        String nameOnTheCard = paymentInformationDTO.getNameOnTheCard();
        if (nameOnTheCard.contains("Esma")){
            limit = new BigDecimal(100);
        }else if(nameOnTheCard.contains("Esra")){
            limit=new BigDecimal(1000);
        } else if (nameOnTheCard.contains("Nisa")) {
            limit = BigDecimal.TEN;
        }
        return  limit;
    }
}
