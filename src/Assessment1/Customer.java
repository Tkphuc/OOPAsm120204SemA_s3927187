package Assessment1;

import java.util.List;

public abstract class Customer {
    private String customerID;
    private String fullName;
    private  InsuranceCard insuranceCard;
    private List<Claim> claimsList;

    //public Customer(){}
    public Customer() {
        /*
        this.customerID = "Default";
        this.fullName = "Default";
        this.insuranceCard = "Default";
        this.claimsList = "Defal";*/
    }
    public Customer(String customerID, String fullName, InsuranceCard insuranceCard, List<Claim> claimsList) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.claimsList = claimsList;
    }
}
