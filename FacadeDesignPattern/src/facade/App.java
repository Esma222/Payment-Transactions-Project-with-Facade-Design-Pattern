package facade;

import facade.debt.Debt;
import facade.debt.EnumDebtType;
import paymentinfodto.PaymentInformationDTO;

import java.math.BigDecimal;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        CollectionFacade collectionFacade = new CollectionFacade();
        Date fallDueDate=DateUtil.makeDate("01.9.2023");
        Debt debt = new Debt(10L, EnumDebtType.CONFIGURATION,new BigDecimal(99),fallDueDate);
        PaymentInformationDTO paymentInformationDTO= new PaymentInformationDTO("Esma FacadeDesignPattenÖğrenenOğlu","53887309111851",12L,2025L,067L);
        boolean isSuccess = collectionFacade.makeCollection(debt,paymentInformationDTO);
        if (isSuccess){
            System.out.println("payment successful");
        }
        else
            System.out.println("payment failed");
    }
}
