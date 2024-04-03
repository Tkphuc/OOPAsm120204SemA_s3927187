package Assessment1;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    private String customerID;
    private String fullName;
    private  InsuranceCard insuranceCard;
    private List<Claim> claimsList;

    //public Customer(){}
    public Customer() {
        this.customerID = "Default";
        this.fullName = "Default";
        this.insuranceCard = null;
        this.claimsList = new ArrayList<>();
    }
    public Customer(String customerID, String fullName, InsuranceCard insuranceCard, List<Claim> claimsList) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.claimsList = claimsList;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {

        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public List<Claim> getClaimsList() {
        return claimsList;
    }

    public void setClaimsList(List<Claim> claimsList) {
        this.claimsList = claimsList;
    }
}
