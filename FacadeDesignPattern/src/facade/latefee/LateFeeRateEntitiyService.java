package facade.latefee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LateFeeRateEntitiyService {
    public BigDecimal getLateFeeRate(){
        BigDecimal ratio =new  BigDecimal(1.6);
        ratio = ratio.divide(new BigDecimal(100),4, RoundingMode.HALF_DOWN);
        return ratio;
    }
}
