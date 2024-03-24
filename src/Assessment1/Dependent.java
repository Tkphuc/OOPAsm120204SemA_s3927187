package Assessment1;

import java.util.List;

public class Dependent extends Customer{
    private PolicyHolder dependOn;
    public Dependent (){}
    public  Dependent(String customerID, String fullName, InsuranceCard insuranceCard, List<Claim> claimsList,PolicyHolder dependOn ){
        super();
        this.dependOn = dependOn;
    }
}
