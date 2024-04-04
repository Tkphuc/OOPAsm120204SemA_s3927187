package Assessment1;

import java.util.List;

public class Dependent extends Customer{
    private PolicyHolder dependOn;
    public Dependent (){super();}
    public  Dependent(String customerID, String fullName, InsuranceCard insuranceCard, List<Claim> claimsList,PolicyHolder dependOn ){
        super(customerID, fullName, insuranceCard, claimsList);
        this.dependOn = dependOn;
    }


    /*
    @Override
    public Claim getOne(String claimID){
        ClaimList localClaimList = new ClaimList(this.getClaimsList());
        while (localClaimList.hasNext()){
            Claim localClaim = new Claim();
            localClaim = (Claim) localClaimList.next();
            if(localClaim.getClaimID().equals(claimID)){
                return localClaim;
            }
        }
        return null;
    }
    @Override
    public Claim getAll() {
        ClaimList localClaimList = new ClaimList(this.getClaimsList());
        while (localClaimList.hasNext()){
            return localClaimList.next();
        }
        return null;
    }*/
}
