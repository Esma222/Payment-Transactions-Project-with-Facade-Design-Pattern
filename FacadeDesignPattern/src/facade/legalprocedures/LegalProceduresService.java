package facade.legalprocedures;

import facade.DateUtil;

import java.util.List;

public class LegalProceduresService {
    private  LegalProceedingEntityService legalProceedingEntityService;

    public  LegalProceduresService(){
       legalProceedingEntityService = new LegalProceedingEntityService();
    }
    public  boolean inLegalProceedings(Long debtId){
       List<Long> listOfDebtsInLegal = legalProceedingEntityService.findAllLegalProcedures();
       Boolean inLegalProceedings= listOfDebtsInLegal.contains(debtId);
       if (inLegalProceedings){
           System.out.println("The debt in legal process. Money cannot be received");
       }
       return inLegalProceedings;
    }

}
