package facade.collection;

import facade.configuration.ConfigurationControlService;
import facade.debt.Debt;
import facade.debt.EnumDebtType;
import facade.legalprocedures.LegalProceduresService;

public class CollectionControlService {

    private ConfigurationControlService configurationControlService;
    private LegalProceduresService legalProceduresService;

    public CollectionControlService() {
        configurationControlService = new ConfigurationControlService();
        legalProceduresService = new LegalProceduresService();
    }

    public  boolean isAvailableForCollection(Debt debt){
        boolean configurationBroken = false;
        if (EnumDebtType.CONFIGURATION.equals(debt.getEnumDebtType())){
            configurationBroken = configurationControlService.isConfigurationBroken(debt.getFallDueDate());
        }
        boolean legalProcess = legalProceduresService.inLegalProceedings(debt.getId());

        //yapılandırma bozulmuyorken ve hukuki islemde değilken para tahsilata uygundur
        boolean isDebtAvailableForCollection = !(legalProcess||configurationBroken);
        return  isDebtAvailableForCollection;
    }
}
