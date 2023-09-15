package paymentinfodto;

public class PaymentInformationDTO {

    private String nameOnTheCard;
    private String NumberOfCard;
    private  Long MontOnTheCard;
    private Long YearOnTheCard;
    private Long NumberOfCvv;

    public PaymentInformationDTO() {
    }

    public PaymentInformationDTO(String nameOnTheCard, String numberOfCard, Long montOnTheCard, Long yearOnTheCard, Long numberOfCvv) {
        this.nameOnTheCard = nameOnTheCard;
        NumberOfCard = numberOfCard;
        MontOnTheCard = montOnTheCard;
        YearOnTheCard = yearOnTheCard;
        NumberOfCvv = numberOfCvv;
    }

    public String getNumberOfCard() {
        return NumberOfCard;
    }

    public void setNumberOfCard(String numberOfCard) {
        NumberOfCard = numberOfCard;
    }

    public Long getMontOnTheCard() {
        return MontOnTheCard;
    }

    public void setMontOnTheCard(Long montOnTheCard) {
        MontOnTheCard = montOnTheCard;
    }

    public Long getYearOnTheCard() {
        return YearOnTheCard;
    }

    public void setYearOnTheCard(Long yearOnTheCard) {
        YearOnTheCard = yearOnTheCard;
    }

    public Long getNumberOfCvv() {
        return NumberOfCvv;
    }

    public void setNumberOfCvv(Long numberOfCvv) {
        NumberOfCvv = numberOfCvv;
    }

    public String getNameOnTheCard() {
        return nameOnTheCard;
    }

    public void setNameOnTheCard(String nameOnTheCard) {
        this.nameOnTheCard = nameOnTheCard;
    }
}
