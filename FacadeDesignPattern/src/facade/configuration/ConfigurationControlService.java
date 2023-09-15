package facade.configuration;

import facade.DateUtil;

import java.util.Date;

public class ConfigurationControlService {


    //eğer vade tarihi üzerinden 90 günü geçtiyse yapılandırma bozulur.
    public  boolean isConfigurationBroken(Date fallDueDate){
        long numberOfDays = DateUtil.numberOfDaysCalculator(fallDueDate,DateUtil.currentlyDate());
        if (numberOfDays > 90){
            System.out.println("Debt configuration should be disrupted");
            return true;
        }
        return  false;
    }
}
