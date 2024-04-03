package Assessment1;

import java.util.List;

public class Dependent extends Customer implements ClaimProcessManager{
    private PolicyHolder dependOn;
    public Dependent (){super();}
    public  Dependent(String customerID, String fullName, InsuranceCard insuranceCard, List<Claim> claimsList,PolicyHolder dependOn ){
        super(customerID, fullName, insuranceCard, claimsList);
        this.dependOn = dependOn;
    }

    @Override
    public boolean add(Claim claim) {
        if(!this.getClaimsList().contains(claim)){
            this.getClaimsList().add(claim);
            return  true;}
        else{return  false;}
    }

    @Override
    public void update(Claim claim) {

    }

    @Override
    public boolean delete(Claim claim) {
        if(this.getClaimsList().contains(claim)){
            this.getClaimsList().remove(claim);
            return  true;
        }else{
            return false;}
    }
    @Override
    public Claim getOne(String claimID){

    }
    @Override
    public void getAll() {

    }
}
