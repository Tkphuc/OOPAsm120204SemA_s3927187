package assessment1;

import java.io.Serializable;
import java.util.Date;

public class InsuranceCard implements Serializable {
    private String cardID ;
    private  Customer cardHolder;
    private String policyOwner;
    private Date expirationDate;

    public InsuranceCard(){
        this.cardID = "Default";
        this.cardHolder = null;
        this.policyOwner = "Default";
        this.expirationDate = null;
    }
    public InsuranceCard(String cardID, Customer cardHolder, String policyOwner, Date expirationDate) {
        this.cardID = cardID;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public int hashCode() {
        return this.cardID.length();
    }

    @Override
    public boolean equals(Object other) {
        if(other == this){
            return true;
        }
        if(!(other instanceof Claim)){
            return false;
        }
        InsuranceCard otherCard = (InsuranceCard) other;
        return this.cardID.equals(otherCard.cardID);
    }
    }
}
