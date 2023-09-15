package facade.latefee;

import facade.DateUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class LateFeeCalculationService {
    private LateFeeRateEntitiyService lateFeeRateEntitiyService;

    public LateFeeCalculationService() {
        lateFeeRateEntitiyService = new LateFeeRateEntitiyService();
    }

    public BigDecimal lateFee(BigDecimal amountOfMoney , Date fallDueDate){
        BigDecimal lateFee = BigDecimal.ZERO;
        if (fallDueDate.compareTo(new Date())> 0){
            return  lateFee;

        }
        lateFee= lateFeeCalculate(amountOfMoney ,fallDueDate);
        return lateFee;
    }

    private BigDecimal lateFeeCalculate(BigDecimal amountOfMoney , Date fallDueDate){

        BigDecimal lateFeeRate= lateFeeRateEntitiyService.getLateFeeRate();
        Date currentlyDate = DateUtil.currentlyDate();

        Long numberOfDays = DateUtil.numberOfDaysCalculator(fallDueDate, currentlyDate);
        BigDecimal differenceOfDay = BigDecimal.valueOf(numberOfDays);
        BigDecimal lateFee = lateFeeRate.multiply(differenceOfDay).multiply(amountOfMoney);
        lateFee  = lateFee.setScale(2, RoundingMode.HALF_DOWN);

        if (fallDueDate.compareTo(new Date())> 0){
            System.out.println("Amount of lateFee : "+lateFee);

        }        return lateFee;
    }

}
