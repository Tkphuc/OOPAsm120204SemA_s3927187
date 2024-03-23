package Assessment1;

import java.util.Date;

public class InsuranceCard {
    private String cardID ;
    private  Customer cardHolder;
    private String policyOwner;
    private Date expirationDate;

    public InsuranceCard(){}
    public InsuranceCard(String cardID, Customer cardHolder, String policyOwner, Date expirationDate) {
        this.cardID = cardID;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }
}
