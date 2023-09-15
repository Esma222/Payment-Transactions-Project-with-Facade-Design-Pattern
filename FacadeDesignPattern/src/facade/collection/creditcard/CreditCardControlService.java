package facade.collection.creditcard;

import facade.DateUtil;
import paymentinfodto.PaymentInformationDTO;

import java.util.Date;

public class CreditCardControlService {

    public  boolean isCreditCardValid(PaymentInformationDTO paymentInformationDTO){

        Long montOnTheCard = paymentInformationDTO.getMontOnTheCard();
        Long yearOnTheCard = paymentInformationDTO.getYearOnTheCard();

        Date currentlyDate= DateUtil.currentlyDate();

        Long currentlMonth = DateUtil.dateMonth(currentlyDate);
        Long currentlyYear = DateUtil.dateYear(currentlyDate);

        boolean creditCardValid =false;
        if (yearOnTheCard.compareTo(currentlyYear)>0) {
            creditCardValid = true;
        }else if (yearOnTheCard.compareTo( currentlyYear)==0) {
            if (montOnTheCard.compareTo(currentlMonth)>=0) {
                creditCardValid = true;
            }
        }
        if(!creditCardValid) {
            System.out.println("credit card is invalid");
        }
        return  creditCardValid;
    }

}
