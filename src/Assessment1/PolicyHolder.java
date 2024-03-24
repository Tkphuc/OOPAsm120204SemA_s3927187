package Assessment1;

import java.util.List;

public class PolicyHolder extends Customer{
    private List<Dependent> dependents;
    public PolicyHolder (){}
    public PolicyHolder(String customerID, String fullName, InsuranceCard insuranceCard, List<Claim> claimsList, List<Dependent> dependents){
        super(customerID, fullName, insuranceCard, claimsList);
        this.dependents = dependents;
    }

}
