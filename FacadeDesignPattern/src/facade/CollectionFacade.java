package facade;

import facade.collection.CollectionControlService;
import facade.collection.creditcard.CreditCardService;
import facade.debt.Debt;
import paymentinfodto.PaymentInformationDTO;
import facade.latefee.LateFeeCalculationService;

import java.math.BigDecimal;

public class CollectionFacade {
    private LateFeeCalculationService lateFeeCalculationService;
    private CollectionControlService collectionControlService;
    private CreditCardService creditCardService;

    public CollectionFacade(){
        lateFeeCalculationService = new LateFeeCalculationService();
        collectionControlService = new CollectionControlService();
        creditCardService = new CreditCardService();

    }

    public   boolean makeCollection(Debt debt , PaymentInformationDTO paymentInformationDTO){

        boolean availableForCollection = collectionControlService.isAvailableForCollection(debt);
        if (!availableForCollection){
            return  false;
        }
        BigDecimal lateFee = lateFeeCalculationService.lateFee(debt.getAmountOfDebt(), debt.getFallDueDate());
        System.out.println(paymentInformationDTO.getNameOnTheCard()+" late Fee is "+lateFee);
        BigDecimal amountOfPaid = debt.getAmountOfDebt().add(lateFee);
        System.out.println("Informatin : Trying to withdraw "+amountOfPaid+" TL from credit card!");
        boolean isSuccess = creditCardService.tryCollectingFromCreditCard(paymentInformationDTO, amountOfPaid);

        return  isSuccess;

    }
}
